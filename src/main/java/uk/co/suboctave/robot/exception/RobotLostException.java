package uk.co.suboctave.robot.exception;

/**
 * Application exception indicating that a Robot has become lost.
 */
public class RobotLostException extends PlanetException {
    public RobotLostException(String message) {
        super(message);
    }
}
