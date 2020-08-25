package uk.co.suboctave.robot.domain;


import uk.co.suboctave.robot.exception.RobotLostException;

import java.io.PrintWriter;

import static uk.co.suboctave.robot.domain.RobotStatus.LOST;
import static uk.co.suboctave.robot.domain.RobotStatus.OK;

/**
 * Model a Robot.  The robot knows its position and status.  The robot does not know what planet it is on.
 */
public class Robot implements IRobot {
    private RobotPosition position;
    private RobotStatus status = OK;
    private IPlanet planet;

    /**
     * Non-public constructor: use Planet to make instances of Robot
     * @param position
     */
    Robot(IPlanet planet, RobotPosition position) {
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
     * Move forward by having the planet generate the new position.
     */
    @Override
    public void forward() {
        try {
            position = planet.forward(this);
        }
        catch (RobotLostException e) {
            status = LOST;
        }
    }

    @Override
    public void report(PrintWriter writer) {
        writer.print(String.format("%s %s %s", position.x, position.y, position.orientation));
        if (status == LOST) {
            writer.print(" LOST");
        }
    }
}
