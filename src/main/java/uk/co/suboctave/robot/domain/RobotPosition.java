package uk.co.suboctave.robot.domain;

/**
 * RobotPosition, comprising x and y co-ordinates and orientation.
 * Modelled as immutable - attributes are public final.
 */
public class RobotPosition {
    public final int x;
    public final int y;
    public final Orientation orientation;

    public RobotPosition(int x, int y, Orientation orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }
}
