package uk.co.suboctave.robot.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotStatusTest {

    @Test
    public void okIsAnActiveStatus() {
        assertTrue(RobotStatus.OK.isActive());
    }

    @Test
    public void lostIsNotAnActiveStatus() {
        assertFalse(RobotStatus.LOST.isActive());
    }
}