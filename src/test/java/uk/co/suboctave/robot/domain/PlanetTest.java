package uk.co.suboctave.robot.domain;

import org.junit.Before;
import org.junit.Test;
import uk.co.suboctave.robot.exception.PlanetException;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;
import static uk.co.suboctave.robot.domain.Orientation.N;

public class PlanetTest {

    private Planet planet;

    @Before
    public void init() {
        planet = new Planet("Mars", 3, 5);
    }

    @Test
    public void robotFactoryForValidPosition() {
        IRobot robot = planet.buildRobot(2, 3, N);
        assertEquals(new RobotPosition(2, 3, N), robot.getPosition());
    }

    @Test(expected = PlanetException.class)
    public void robotFactoryForInvalidPosition() {
        IRobot robot = planet.buildRobot(6, 6, N);
    }

    @Test
    public void positionWithinBoundsIsValid() {
        assertTrue(planet.isValid(new RobotPosition(0, 0, N)));
        assertTrue(planet.isValid(new RobotPosition(2, 3, N)));
        assertTrue(planet.isValid(new RobotPosition(3, 5, N)));
    }

    @Test
    public void positionOutsideBoundsIsInvalid() {
        assertFalse(planet.isValid(new RobotPosition(-1, 0, N)));
        assertFalse(planet.isValid(new RobotPosition(0, -1, N)));
        assertFalse(planet.isValid(new RobotPosition(4, 0, N)));
        assertFalse(planet.isValid(new RobotPosition(0, 6, N)));
    }

    @Test
    public void forwardWithinBounds() {
        Planet planet = new Planet("Mars", 3, 4);
        IRobot robot = planet.buildRobot(1, 1, N);
        robot.forward();
        assertEquals(new RobotPosition(1, 2, N), robot.getPosition());
        assertTrue(robot.isActive());
    }


    @Test
    public void forwardBeyondBounds() {
        Planet planet = new Planet("Mars", 3, 4);
        IRobot robot = planet.buildRobot(1, 4, N);
        robot.forward();
        // robot has not chaned position
        assertEquals(robot.getPosition(), new RobotPosition(1, 4, N));
        // robot is no longer active (it is lost)
        assertFalse(robot.isActive());
        // leverage this test to constrain the robot's report() method, to get coverage over one that is LOST
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        robot.report(pw);
        assertEquals("1 4 N LOST\n", sw.toString());
    }

    @Test
    public void forwardAtScentBoundary() {
        Planet planet = new Planet("Mars", 3, 4);

        {
            IRobot robotWhichWillBeLost = planet.buildRobot(1, 4, N);
            robotWhichWillBeLost.forward();

            // robot has not changed position
            assertEquals(robotWhichWillBeLost.getPosition(), new RobotPosition(1, 4, N));
            // robot is no longer active (it is lost)
            assertFalse(robotWhichWillBeLost.isActive());
        }

        {
            IRobot subsequentRobot = planet.buildRobot(1, 4, N);
            subsequentRobot.forward();

            // robot has not changed position
            assertEquals(subsequentRobot.getPosition(), new RobotPosition(1, 4, N));
            // robot is still active (it is NOT lost)
            assertTrue(subsequentRobot.isActive());
        }

    }

}