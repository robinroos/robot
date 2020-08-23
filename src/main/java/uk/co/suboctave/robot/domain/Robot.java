package uk.co.suboctave.robot.domain;


import static uk.co.suboctave.robot.domain.RobotStatus.OK;

/**
 * Model a Robot.  The robot knows its position and status.  The robot does not know what planet it is on.
 */
public class Robot {
    private RobotPosition position;
    private RobotStatus status = OK;
    private Planet planet;

    /**
     * Non-public constructor: use Planet to make instances of Robot
     * @param position
     */
    Robot(Planet planet, RobotPosition position) {
        this.planet = planet;
        this.position = position;
    }

    /**
     * Evatuates true if the Robot is active (i.e. has not been lost).
     * @return
     */
    public boolean isActive() {
        return status.isActive();
    }

    /**
     * Expose the immutable position object.
     * @return
     */
    public RobotPosition getPosition() {
        return position;
    }
}
