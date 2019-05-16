//Added

/**
 * Rectangle class that creates rectangles that can be bounced around the screen.
 * <br>
 * It inherits methods from the the class ClosedShape.
 * <br>
 *
 * Last edited: 21/03/2019
 * <br>
 *
 * @author George Cook (984336)
 * @version 1.0
 *
 *
 */


import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 * Rectangle is a rectangle that can be drawn on the screen either filled, with a colour, or unfilled, just an outline.
 * <br>
 * Position is determined from the top left corner of the bounding box.
 */

public class Rectangle extends ClosedShape{
    private int width;
    private int height;

    /**
     * This is the constructor for the rectangle object that will then be outputted to the screen.
     * <br>
     *
     * @param insertionTime How long after the window is created that the rectangle will be created and displayed.
     * @param x The position on the x-axis where the rectangle will be created.
     * @param y The position on the y-axis where the rectangle will be created.
     * @param vx The velocity in the x axis that the rectangle will have.
     * @param vy The velocity in the y axis that the rectangle will have.
     * @param width The space in terms of width that the rectangle will take up.
     * @param height The space in terms of height that the rectangle will take up.
     * @param colour The colour that the rectangle will be created in.
     * @param isFilled A boolean to say where the rectangle will be filled in or not.
     */
    public Rectangle(int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled){
        super (insertionTime, x, y, vx, vy, colour, isFilled);
        setheight(height);
        setWidth(width);
    }

    /**
     * A toString method that converts the Rectangle object to a readable string.
     * <br>
     * @return Returns all the properties about Rectangle object as a human readable string.
     */
    public String toString () {
        String result = "This is a rectangle\n";
        result += super.toString ();
        result += "Its width is " + this.width + "\n";
        result += "Its height is " + this.height + "\n";
        return result;
    }

    /**
     * Method to set the value of the width of the rectangle.
     * <br>
     * @param width The width that you want this rectangle to be.
     */
    public void setWidth(int width){
        this.width = width;
    }

    /**
     * Method to set the value of the height of the rectangle.
     * <br>
     * @param height The height that you want this rectangle to be.
     */
    public void setheight(int height){
        this.height = height;
    }

    /**
     * Method to return the value of width.
     * <br>
     * @return Returns the integer value of width.
     */
    public int getWidth(){
        return this.width;
    }

    /**
     * Method to return the value of height.
     * <br>
     * @return Returns the integer value of height.
     */
    public int getHeight(){
        return this.height;
    }

    /**
     * Draws the rectanlge.
     * <br>
     * @param r The graphics object of the rectangle.
     */
    public void draw(GraphicsContext r){
        r.setFill(colour);
        r.setStroke(colour);
        if (isFilled) {
            r.fillRect(x, y, width, height);
        } else {
            r.strokeRect(x, y, width, height);
        }
    }
}