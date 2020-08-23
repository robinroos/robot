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

        public RobotPosition right(RobotPosition position) {
            return new RobotPosition(position.x, position.y, E);
        }

        public RobotPosition left(RobotPosition position) {
            return new RobotPosition(position.x, position.y, W);
        }
    },
    S {
        public RobotPosition forward(RobotPosition position) {
            return new RobotPosition(position.x, position.y - 1, position.orientation);
        }

        public RobotPosition right(RobotPosition position) {
            return new RobotPosition(position.x, position.y, W);
        }

        public RobotPosition left(RobotPosition position) {
            return new RobotPosition(position.x, position.y, E);
        }
    },
    E {
        public RobotPosition forward(RobotPosition position) {
            return new RobotPosition(position.x + 1, position.y, position.orientation);
        }

        public RobotPosition right(RobotPosition position) {
            return new RobotPosition(position.x, position.y, S);
        }

        public RobotPosition left(RobotPosition position) {
            return new RobotPosition(position.x, position.y, N);
        }
    },
    W {
        public RobotPosition forward(RobotPosition position) {
            return new RobotPosition(position.x -1, position.y, position.orientation);
        }

        public RobotPosition right(RobotPosition position) {
            return new RobotPosition(position.x, position.y, N);
        }

        public RobotPosition left(RobotPosition position) {
            return new RobotPosition(position.x, position.y, S);
        }
    };

    /**
     * Evaluates to the position resulting from moving forward from the given position
     * @param position
     * @return
     */
    public abstract RobotPosition forward(RobotPosition position);

    /**
     * Evaluates to the position resulting from turning right from the given position
     * @param position
     * @return
     */
    public abstract RobotPosition right(RobotPosition position);


    /**
     * Evaluates to the position resulting from turning left from the given position
     * @param position
     * @return
     */
    public abstract RobotPosition left(RobotPosition position);

}
