package uk.co.suboctave.robot.domain;

/**
 * Orientation is North (N), South (S), East (E) or West (W).
 *
 * Orientation has no dynamic state and is modelled as an enum.
 *
 * Orientation knows how to execute position-related actions; each action takes a starting position, and returnes the resulting position.
 *
 */
public enum Orientation {
    N {
        public RobotPosition forward(RobotPosition position) {
            return new RobotPosition(position.x, position.y + 1, position.orientation);
        }
    },
    S {
        public RobotPosition forward(RobotPosition position) {
            return new RobotPosition(position.x, position.y - 1, position.orientation);
        }
    },
    E {
        public RobotPosition forward(RobotPosition position) {
            return new RobotPosition(position.x + 1, position.y, position.orientation);
        }
    },
    W {
        public RobotPosition forward(RobotPosition position) {
            return new RobotPosition(position.x -1, position.y, position.orientation);
        }
    };

    public abstract RobotPosition forward(RobotPosition position);
}
