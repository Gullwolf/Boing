
/**
 * This class reads a shape file.  For the format of this shape file, see the assignment description.
 * <br>
 * Also, please see the shape files ExampleShapes.txt, ExampleShapesStill.txt, and TwoRedCircles.txt
 * <br>
 *
 * Last edited: 21/03/2019
 * <br>
 *
 * @author George Cook (984336)
 */

import javafx.scene.paint.Color;

import java.awt.*;
import java.io.*;
import java.net.Inet4Address;
import java.util.Scanner;

public class ReadShapeFile {

    // TODO: You will likely need to write four methods here. One method to
    // construct each shape
    // given the Scanner passed as a parameter. I would suggest static
    // methods in this case.

    /**
     * Reads the data file used by the program and returns the constructed queue.
     * <br>
     *
     * @param in the scanner of the file
     * @return the queue represented by the data file
     */
    private static Queue<ClosedShape> readDataFile(Scanner in) {
        Queue<ClosedShape> shapeQueue = new Queue<ClosedShape>();

        while (in.hasNext()) { //Loops whilst the file has a next line.
            String shapeName = in.next(); /*Gets the first string value of a line which should be name
                                            of the object to be created*/

            if (shapeName.equals("circle")) { /*If statement that reads in the line if the shape is meant to be a
                                                circle and then adds the object to the queue.*/
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

                Color shapeColour = Color.rgb(redValue, greenValue, blueValue); //Determining the colour of the object.

                //Creating a new Circle object.
                Circle shape = new Circle(insertionTime, cordX, cordY, velocityX, velocityY, diameter, shapeColour, filled);

                shapeQueue.enqueue(shape); //Adding to the queue, the newly created object.

                System.out.println(shape.toString());

            } else if (shapeName.equals("oval")) {/*If statement that reads in the line if the shape is meant to be a
                                                    oval and then adds the object to the queue.*/
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

                Color shapeColour = Color.rgb(redValue, greenValue, blueValue); //Determining the colour of the object.

                //Creating a new Oval object.
                Oval shape = new Oval(insertionTime, cordX, cordY, velocityX, velocityY, width, height, shapeColour, filled);

                shapeQueue.enqueue(shape); //Adding to the queue, the newly created object.

                System.out.println(shape.toString());
            } else if (shapeName.equals("rect")) {/*If statement that reads in the line if the shape is meant to be a
                                                    rectangle and then adds the object to the queue.*/
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

                Color shapeColour = Color.rgb(redValue, greenValue, blueValue); //Determining the colour of the object.

                //Creating a new Rectangle object.
                Rectangle shape = new Rectangle(insertionTime, cordX, cordY, velocityX, velocityY, width, height, shapeColour, filled);

                shapeQueue.enqueue(shape); //Adding to the queue, the newly created object.

                System.out.println(shape.toString());
            } else if (shapeName.equals("square")) {/*If statement that reads in the line if the shape is meant to be a
                                                      square and then adds the object to the queue.*/
                int cordX = Integer.valueOf(in.next());
                int cordY = Integer.valueOf(in.next());
                int velocityX = Integer.valueOf(in.next());
                int velocityY = Integer.valueOf(in.next());
                boolean filled = Boolean.valueOf(in.next());
                int sideLength = Integer.valueOf(in.next());
                int redValue = Integer.valueOf(in.next());
                int greenValue = Integer.valueOf(in.next());
                int blueValue = Integer.valueOf(in.next());
                int insertionTime = Integer.valueOf(in.next());

                Color shapeColour = Color.rgb(redValue, greenValue, blueValue); //Determining the colour of the object.

                //Creating a new Square object.
                Square shape = new Square(insertionTime, cordX, cordY, velocityX, velocityY, sideLength, shapeColour, filled);

                shapeQueue.enqueue(shape); //Adding to the queue, the newly created object.

                System.out.println(shape.toString());
            } else if (shapeName.equals("text")) {/*If statement that reads in the line if the shape is meant to be
                                                    text and then adds the object to the queue.*/

                String text = in.next(); //Taking in the text that is to be displayed.

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


                Color shapeColour = Color.rgb(redValue, greenValue, blueValue); //Determining the colour of the object.

                //Creating a new Text object.
                Text shape = new Text(text, insertionTime, cordX, cordY, velocityX, velocityY, width, height, shapeColour, filled);

                shapeQueue.enqueue(shape); //Adding to the queue, the newly created object.

                System.out.println(shape.toString());
            }
            //read in the shape files and place them on the Queue

            //Right now, returning an empty Queue.  You need to change this.
        }
            return shapeQueue;

    }

    /**
     * Method to read the file and return a queue of shapes from this file.
     * <br>
     * The program should handle the file not found exception here and shut down the
     * program gracefully.
     * <br>
     *
     * @param filename the name of the file
     * @return the queue of shapes from the file
     */
    public static Queue<ClosedShape> readDataFile(String filename) { //Changed

        File inputFile = new File("Boiing/" + filename);
        Scanner in = null;
        try { //Opening the file if it exists.

            in = new Scanner(inputFile);


        } catch (FileNotFoundException e) { //If the file does not exist it will display an error message.
            System.out.println("Cannot open " + filename);
            System.exit(0);
        }
        return ReadShapeFile.readDataFile(in); //Passes it to readDataFile method so the objects can be created.

    }
}
