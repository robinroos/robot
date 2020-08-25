package uk.co.suboctave.robot.app;

import uk.co.suboctave.robot.domain.IRobot;
import uk.co.suboctave.robot.domain.Orientation;
import uk.co.suboctave.robot.domain.Planet;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Parser of commands to drive Robots on Planets.
 * This application makes no attempt actually to validate input.
 */
public class RobotFun {

    /**
     * Static entry point.  No args are required and all are ignored.
     * @param args
     */
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            String fileName = args[0];
            File file = new File(fileName);
            FileReader fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
//            BufferedReader br = new BufferedReader(new InputStreamReader(RobotFun.class.getResourceAsStream(fileName)));
            new RobotFun().go(br);
        }
        else {
            System.out.println("usage: RobotFun <inputFile>");
        }
    }

    /**
     * Non-static method to have fun.  Read from stdin and write to stdout.
     */
    public void go(BufferedReader br) throws IOException {

        // Read the planet dimensions
        String inputLine = br.readLine();

        StringTokenizer st = new StringTokenizer(inputLine);
        int planetMaximumX = Integer.parseInt(st.nextToken());
        int planetMaximumY = Integer.parseInt(st.nextToken());

        Planet planet = new Planet("Mars", planetMaximumX, planetMaximumY);

        String startPosition = br.readLine();
        while (startPosition != null) {
            String actions = br.readLine();

            robotFun(planet, startPosition, actions);

            // read the blank line which might be null
            String blankLine = br.readLine();
            if (blankLine != null) {
                if (!blankLine.isBlank()) {
                    throw new RuntimeException("Blank line expected, but read: " + blankLine);
                }
            }

            // read next start position and loop until EOF
            startPosition = br.readLine();
        }




    }

    private void robotFun(Planet planet, String startPosition, String actions) {
        IRobot robot;
        PrintWriter printWriter = new PrintWriter(System.out);
        try {

            // build the robot
            {
                StringTokenizer st = new StringTokenizer(startPosition, " ");
                int robotX = Integer.parseInt(st.nextToken());
                int robotY = Integer.parseInt(st.nextToken());
                Orientation robotOrientation = Orientation.valueOf(st.nextToken());

                robot = planet.buildRobot(robotX, robotY, robotOrientation);
            }

            char[] actionChars = actions.toCharArray();
            for (int i = 0; i < actionChars.length; i++) {
                char c = actionChars[i];
                switch (c) {
                    case 'L':
                        robot.left();
                        break;
                    case 'R':
                        robot.right();
                        break;
                    case 'F':
                        robot.forward();
                        break;
                    default:
                        throw new RuntimeException("Unrecognized action '" + c + "' when parsing action string: " + actions);

                }
            }

            // all actions have been processed
            robot.report(printWriter);
        }
        finally {
            printWriter.flush();
        }
    }

}
