package uk.co.suboctave.robot.domain;

import uk.co.suboctave.robot.exception.PlanetException;

import java.util.HashSet;
import java.util.Set;

/**
 * Models a planet, as a named grid with maximum x/y co-ordinates, history of scent positions.
 * Planet acts as a Robot factory and can validate positions
 */
public class Planet {
    private String name;
    private int upperRightX;
    private int upperRightY;

    /**
     * Contains all positions from which Robots have subsequently been lost upon moving forward
     */
    private Set<RobotPosition> scents = new HashSet<>();

    public Planet(String name, int upperRightX, int upperRightY) {
        this.name = name;
        this.upperRightX = upperRightX;
        this.upperRightY = upperRightY;
    }

    /**
     * Robot factory method.  Evaluates to a Robot instance with the given starting position.
     * @param x
     * @param y
     * @param orientation
     * @return
     */
    IRobot buildRobot(int x, int y, Orientation orientation) {
        RobotPosition startPosition = new RobotPosition(x, y, orientation);
        if (isValid(startPosition)) {
            return new Robot(this, new RobotPosition(x, y, orientation));
        }
        else {
            throw new PlanetException("Proposed start position is invalid.");
        }
    }

    /**
     * Validate a position.  Evaluates to true if and only if the position is within the grid of this planet.
     * @param position
     * @return
     */
    boolean isValid(RobotPosition position) {
        return (position.x >= 0 && position.y >= 0 && position.x <= upperRightX && position.y <= upperRightY);
    }

}
