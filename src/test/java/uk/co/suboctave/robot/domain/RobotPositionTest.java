package uk.co.suboctave.robot.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotPositionTest {

    @Test
    public void testToString() {
        RobotPosition position = new RobotPosition(2,3,Orientation.S);
        assertEquals("[2,3,S]", position.toString());
    }
}