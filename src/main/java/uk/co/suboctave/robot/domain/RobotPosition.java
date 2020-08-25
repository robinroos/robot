package uk.co.suboctave.robot.domain;

import java.util.Objects;

/**
 * RobotPosition, comprising x and y co-ordinates and orientation.
 * Modelled as immutable - attributes are public final, and mutating actions result in a new RobotPosition instance.
 *
 * RobotPosition models position-related actions, mostly by delegating these to the positions current Orientation.
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

    /**
     * Evaluates to the position resulting from moving forward
     * @return
     */
    public RobotPosition forward() {
        return orientation.forward(this);
    }

    /**
     * Evaluates to the position resulting from turning right
     * @return
     */
    public RobotPosition right() {
        return orientation.right(this);
    }

    /**
     * Evaluates to the position resulting from turning left
     * @return
     */
    public RobotPosition left() {
        return orientation.left(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RobotPosition that = (RobotPosition) o;
        return x == that.x &&
                y == that.y &&
                orientation == that.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, orientation);
    }
}
