package uk.co.suboctave.robot.domain;


import static uk.co.suboctave.robot.domain.RobotStatus.ACTIVE;

/**
 * Model a Robot.  The robot knows its position and status.  The robot does not know what planet it is on.
 */
public class Robot {
    private RobotPosition position;
    private RobotStatus status = ACTIVE;

    public Robot(RobotPosition position) {
        this.position = position;
    }

    public Robot(int x, int y, Orientation orientation) {
        this(new RobotPosition(x, y, orientation));
    }

    public boolean isActive() {
        return status == ACTIVE;
    }

    public RobotPosition getPosition() {
        return position;
    }

    void setPosition(RobotPosition position) {
        this.position = position;
    }

    public RobotStatus getStatus() {
        return status;
    }

    void setStatus(RobotStatus status) {
        this.status = status;
    }
}
