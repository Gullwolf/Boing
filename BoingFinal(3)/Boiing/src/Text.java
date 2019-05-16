//Added
/**
 * Text class that creates text that can be bounced around the screen.
 * <br>
 * It inherits methods from the the class ClosedShape.
 * <br>
 * Last edited: 21/03/2019
 * <br>
 * @author George Cook (984336)
 * @version 1.0
 *
 *
 */

import javafx.geometry.VPos;
import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;

import java.util.concurrent.TimeUnit;

/**
 * Text is text that can be drawn on the screen either filled(bold) or unfilled.
 * <br>
 * Position is determined from the top left corner of the bounding box.
 */
public class Text extends ClosedShape {
    private String text;
    private int width;
    private int height;

    /**
     * This is the constructor for the Text objects that will then be outputted to the screen.
     * <br>
     *
     * @param text The text that is going to be displayed.
     * @param insertionTime How long after the window is created that the text show be created and displayed.
     * @param x The position on the x-axis where the text will be created.
     * @param y The position on the y-axis where the text will be created.
     * @param vx The velocity in the x axis that the text will have.
     * @param vy The velocity in the y axis that the text will have.
     * @param width The space in terms of width that the text will take up, forms a hit box around the text.
     * @param height The space in terms of height that the text will take up, forms a hit box around the text.
     * @param colour The colour that the text will be created in.
     * @param isFilled A boolean to say where the text will be filled in or not.
     */
    public Text(String text, int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled) {
        super(insertionTime, x, y, vx, vy, colour, isFilled);
        setheight(height);
        setWidth(width);
        setText(text);

    }

    /**
     * A toString method that converts the text object to a readable string.
     * <br>
     * @return Returns all the properties about text object as a human readable string.
     */
    public String toString() {
        String result = "This is a text\n";
        result += super.toString();
        result += "Its width is " + this.width + "\n";
        result += "Its height is " + this.height + "\n";
        return result;
    }

    /**
     * Method to set the text variables value.
     * <br>
     * @param text The string that the text is to be set to
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Method to set the value of the hit boxes width that is around the text.
     * <br>
     * @param width The width that you want this hit box to be.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Method to set the value of the hit boxes height that is around the text.
     * <br>
     * @param height The height that you want this hit box to be.
     */
    public void setheight(int height) {
        this.height = height;
    }

    /**
     * Method to return the value of text.
     * <br>
     * @return Returns the string value of text.
     */
    public String getText() {
        return this.text;
    }

    /**
     * Method to return the value of width.
     * <br>
     * @return Returns the integer value of width.
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Method to return the value of height.
     * <br>
     * @return Returns the integer value of height.
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Draws the text.
     * <br>
     * @param t The graphics object of the text.
     */
    public void draw(GraphicsContext t) {

        t.setTextBaseline(VPos.TOP);
        t.setFill(colour);
        t.setStroke(colour);

        if (isFilled) {
            t.fillText(text, x, y, width);
            if(isPulsing){
                pulse(t);
            }

        } else {
            t.strokeText(text, x, y, width);
        }

    }

    public void pulse(GraphicsContext t) throws InterruptedException{
        while (true){
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                throw new InterruptedException();
            }

            t.setFont(new Font(20));

            try{
                TimeUnit.SECONDS.sleep(1);
            }catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
                throw new InterruptedException();
            }

            t.setFont(new Font(10));
        }
    }
}

