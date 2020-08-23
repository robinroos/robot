package uk.co.suboctave.robot.domain;

import org.junit.Test;

import static org.junit.Assert.*;
import static uk.co.suboctave.robot.domain.Orientation.*;

public class OrientationTest {

    @Test
    public void forwardWhenOrientatedNoth() {
        RobotPosition before = new RobotPosition(1, 1, N);
        RobotPosition after = before.forward();
        assertEquals(1, after.x);
        assertEquals(2, after.y);
        assertEquals(N, after.orientation);
    }


    @Test
    public void forwardWhenOrientatedSouth() {
        RobotPosition before = new RobotPosition(1, 1, S);
        RobotPosition after = before.forward();
        assertEquals(1, after.x);
        assertEquals(0, after.y);
        assertEquals(S, after.orientation);
    }


    @Test
    public void forwardWhenOrientatedEast() {
        RobotPosition before = new RobotPosition(1, 1, E);
        RobotPosition after = before.forward();
        assertEquals(2, after.x);
        assertEquals(1, after.y);
        assertEquals(E, after.orientation);
    }


    @Test
    public void forwardWhenOrientatedWest() {
        RobotPosition before = new RobotPosition(1, 1, W);
        RobotPosition after = before.forward();
        assertEquals(0, after.x);
        assertEquals(1, after.y);
        assertEquals(W, after.orientation);
    }

}