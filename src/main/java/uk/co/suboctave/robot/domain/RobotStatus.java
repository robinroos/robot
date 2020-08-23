package uk.co.suboctave.robot.domain;

/**
 * Model whether or not a Robot has been LOST.
 * By modelling active as a boolean property we can later add other active/inactive states
 */
public enum RobotStatus {
    ACTIVE(true),
    LOST(false);

    private boolean active;

    public boolean isActive() {
        return active;
    }

    RobotStatus(boolean active) {
        this.active = active;
    }
}
