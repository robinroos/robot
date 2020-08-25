package uk.co.suboctave.robot.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * I was going to show off my Mockito skills here, but Mockito is inappropriate for this
 * because RobotPosition is a value object with public attributes, and because RobotPosition
 * has methods which return further RobotPosition instances.  This would result in a test
 * with lots of mocks and high congnitive complexity, for no benefit.
 */
public class RobotTest {

    @Test
    public void left() {
        Planet p = new Planet("Mars", 3, 4);
        IRobot r = p.buildRobot(1, 1, Orientation.N);
        r.left();
        assertEquals(r.getPosition(), new RobotPosition(1, 1, Orientation.W));
    }

    @Test
    public void right() {
        Planet p = new Planet("Mars", 3, 4);
        IRobot r = p.buildRobot(1, 1, Orientation.N);
        r.right();
        assertEquals(r.getPosition(), new RobotPosition(1, 1, Orientation.E));
    }

    @Test
    public void forward() {
        Planet p = new Planet("Mars", 3, 4);
        IRobot r = p.buildRobot(1, 1, Orientation.N);
        r.forward();
        assertEquals(r.getPosition(), new RobotPosition(1, 2, Orientation.N));
    }

    @Test
    public void report() {
        Planet p = new Planet("Mars", 3, 4);
        IRobot r = p.buildRobot(1, 2, Orientation.N);
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        r.report(pw);
        assertEquals("1 2 N", sw.toString());

    }

}