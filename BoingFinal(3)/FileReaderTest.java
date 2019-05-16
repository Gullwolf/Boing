
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 *
 * @author you
 */

import javafx.scene.paint.Color;

import java.io.*;
import java.net.Inet4Address;
import java.util.Scanner;

public class ReadShapeFile {

    // TODO: You will likely need to write four methods here. One method to
    // construct each shape
    // given the Scanner passed as a parameter. I would suggest static
    // methods in this case.

    /**
     * Reads the data file used by the program and returns the constructed queue
     *
     * @param in
     *            the scanner of the file
     * @return the queue represented by the data file
     */
    private static Queue<ClosedShape> readDataFile(Scanner in) {
        Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

        //read in the shape files and place them on the Queue

        //Right now, returning an empty Queue.  You need to change this.
        return shapeQueue;
    }


    /**
     * Method to read the file and return a queue of shapes from this file. The
     * program should handle the file not found exception here and shut down the
     * program gracefully.
     *
     * @param filename
     *            the name of the file
     * @return the queue of shapes from the file
     */
    public static Queue<ClosedShape> readDataFile(String filename) { //Changed

        File inputFile = new File(filename + ".txt");
        Scanner in = null;
        try {

            in = new Scanner(inputFile);

            while(in.hasNext()) {
                String shapesName = in.next();

                if (shapeName.equals(circle)){
                    int cordX = Integer.valueOf(in.next());
                    int cordY = Integer.valueOf(in.next());
                    int velocityX = Integer.valueOf(in.next());
                    int velocityY = Integer.valueOf(in.next());
                    boolean filled = Boolean.valueOf(in.next());
                    int diameter = Integer.valueOf(in.next());
                    int redValue = Integer.valueOf(in.next());
                    int greenValue = Integer.valueOf(in.next());
                    int blueValue = Integer.valueOf(in.next());
                    int insertionTime = Integer.valueOf(in.next());

                    Color shapeColour = Color.rgb(redValue,greenValue,blueValue);

                    Circle shape = new Circle(insertionTime, cordX, cordY, velocityX, velocityY, diameter, shapeColour, filled);

		    shapeQueue.enqueue(shape);

                    System.out.println(shape.toString());

                } else if (shapeName.equals(oval)){
                    int cordX = Integer.valueOf(in.next());
                    int cordY = Integer.valueOf(in.next());
                    int velocityX = Integer.valueOf(in.next());
                    int velocityY = Integer.valueOf(in.next());
                    boolean filled = Boolean.valueOf(in.next());
                    int width = Integer.valueOf(in.next());
                    int height = Integer.valueOf(in.next());
                    int redValue = Integer.valueOf(in.next());
                    int greenValue = Integer.valueOf(in.next());
                    int blueValue = Integer.valueOf(in.next());
                    int insertionTime = Integer.valueOf(in.next());

                    Color shapeColour = Color.rgb(redValue,greenValue,blueValue);

                    Oval shape = new Oval(insertionTime, cordX, cordY, velocityX, velocityY, width, height, shapeColour, filled);
			
		    shapeQueue.enqueue(shape);

                    System.out.println(shape.toString());
                }                             

            }

        } catch (FileNotFoundException e) {
            System.out.println("Cannot open " + filename);
            System.exit(0);
        }
        return ReadShapeFile.readDataFile(in);

    }
}