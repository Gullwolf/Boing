//Added

/**
 * Square class that creates squares that can be bounced around the screen.
 * <br>
 * It inherits methods from the the class ClosedShape.
 *<br>
 * Last edited: 21/03/2019
 *<br>
 * @author George Cook (984336)
 * @version 1.0
 *
 *
 */


import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Square is a square that can be drawn on the screen either filled, with a colour, or unfilled, just an outline.
 * <br>
 * Position is determined from the top left corner of the bounding box.
 */

public class Square extends ClosedShape{
	private int sideLength;

    /**
     * This is the constructor for the square object that will then be outputted to the screen.
     * <br>
     *
     * @param insertionTime How long after the window is created that the square will be created and displayed.
     * @param x The position on the x-axis where the square will be created.
     * @param y The position on the y-axis where the square will be created.
     * @param vx The velocity in the x axis that the square will have.
     * @param vy The velocity in the y axis that the square will have.
     * @param sideLength The space in terms of width and height that the square will take up.
     * @param colour The colour that the square will be created in.
     * @param isFilled A boolean to say where the square will be filled in or not.
     */
	public Square(int insertionTime, int x, int y, int vx, int vy, int sideLength, Color colour, boolean isFilled){
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        setWidth(sideLength);
        setheight(sideLength);
    }

    /**
     * A toString method that converts the Square object to a readable string.
     * <br>
     * @return Returns all the properties about Square object as a human readable string.
     */
    public String toString () {
        String result = "This is a square\n";
        result += super.toString ();
        result += "Its side length is " + this.sideLength + "\n";
        return result;
    }

    /**
     * Method to set the value of the width of the square.
     * <br>
     * @param sideLength The width that you want this square to be.
     */
    public void setWidth(int sideLength){
        this.sideLength = sideLength;
    }

    /**
     * Method to set the value of the height of the square.
     * <br>
     * @param sideLength The height that you want this square to be.
     */
    public void setheight(int sideLength){
        this.sideLength = sideLength;
    }

    /**
     * Method to return the value of width.
     * <br>
     * @return Returns the integer value of width.
     */
    public int getWidth(){
        return this.sideLength;
    }

    /**
     * Method to return the value of height.
     * <br>
     * @return Returns the integer value of height.
     */
    public int getHeight(){
        return this.sideLength;
    }

    /**
     * Draws the square.
     * <br>
     * @param s The graphics object of the square.
     */
    public void draw(GraphicsContext s){
        s.setFill(colour);
        s.setStroke(colour);
        if (isFilled) {
            s.fillRect(x, y, sideLength, sideLength);
        } else {
            s.strokeRect(x, y, sideLength, sideLength);
        }
    }
}