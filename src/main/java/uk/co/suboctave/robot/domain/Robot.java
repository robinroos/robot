package uk.co.suboctave.robot.domain;


import static uk.co.suboctave.robot.domain.RobotStatus.OK;

/**
 * Model a Robot.  The robot knows its position and status.  The robot does not know what planet it is on.
 */
public class Robot implements IRobot {
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
    @Override
    public boolean isActive() {
        return status.isActive();
    }

    /**
     * Expose the immutable position object.
     * @return
     */
    @Override
    public RobotPosition getPosition() {
        return position;
    }

    /**
     * Turn right by having the current position generate the new position.
     */
    @Override
    public void right() {
        if (isActive()) {
            this.position = position.right();
        }
    }

    /**
     * Turn left by having the current position generate the new position.
     */
    @Override
    public void left() {
        if (isActive()) {
            this.position = position.left();
        }
    }

    /**
     * Move forward by having the current position generate the new position.
     * Simplistic implementation with no Scent processing.
     */
    @Override
    public void forward() {
        // TODO execute this through Planet to get Scent processing
        if (isActive()) {
            RobotPosition candidate = position.forward();
            if (planet.isValid(candidate)) {
                position = candidate;
            }
        }
    }
}
