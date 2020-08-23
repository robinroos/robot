package uk.co.suboctave.robot.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    @Test
    public void robotWithStateActiveIsActive() {
        Robot r = new Robot(1, 1, Orientation.N);
        assertTrue(r.isActive());
    }

    @Test
    public void robotWithStateLostIsNotActive() {
        Robot r = new Robot(1, 1, Orientation.N);
        r.setStatus(RobotStatus.LOST);
        assertFalse(r.isActive());
    }



}