package uk.co.suboctave.robot.domain;

import org.junit.Before;
import org.junit.Test;
import uk.co.suboctave.robot.exception.PlanetException;

import static org.junit.Assert.*;

public class PlanetTest {

    private Planet planet;

    @Before
    public void init() {
        planet = new Planet("Mars", 3, 5);
    }

    @Test
    public void robotFactoryForValidPosition() {
        IRobot robot = planet.buildRobot(2, 2, Orientation.N);
        RobotPosition p = robot.getPosition();
    }

    @Test(expected = PlanetException.class)
    public void robotFactoryForInvalidPosition() {
        IRobot robot = planet.buildRobot(6, 6, Orientation.N);
    }

    @Test
    public void positionWithinBoundsIsValid() {
        assertTrue(planet.isValid(new RobotPosition(0, 0, Orientation.N)));
        assertTrue(planet.isValid(new RobotPosition(2, 3, Orientation.N)));
        assertTrue(planet.isValid(new RobotPosition(3, 5, Orientation.N)));
    }

    @Test
    public void positionOutsideBoundsIsInvalid() {
        assertFalse(planet.isValid(new RobotPosition(-1, 0, Orientation.N)));
        assertFalse(planet.isValid(new RobotPosition(0, -1, Orientation.N)));
        assertFalse(planet.isValid(new RobotPosition(4, 0, Orientation.N)));
        assertFalse(planet.isValid(new RobotPosition(0, 6, Orientation.N)));
    }


}