package uk.co.suboctave.robot.domain;

public interface IRobot {
    /**
     * Evaluates true if robot remains active (has not been lost)
     * @return
     */
    boolean isActive();

    /**
     * Exposes the Robot's current position as an immutable RobotPosition object
     * @return
     */
    RobotPosition getPosition();

    /**
     * Instruct the Robot to turn right
     */
    void right();

    /**
     * Instruct the Robot to turn Left
     */
    void left();

    /**
     * Instruct the Robot to move Forward
     */
    void forward();
}
