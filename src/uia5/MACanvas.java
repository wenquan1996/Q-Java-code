package uia5;

import java.util.Observable;
import java.util.Observer;
//import java.util.logging.Logger;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;


/**
 * A sample canvas that draws a rainbow of lines
 * @author MMUNSON
 */
public class MACanvas extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;
	//private Logger log = Logger.getLogger(MACanvas.class.getName());
    private int stepSize = 20;
    private Color col = null;
    private long counter = 0L;
	
    /**
     * MACanvas constructor
     */
	public MACanvas() {
		col = Color.WHITE;
	}

	/**
	 * The UI thread calls this method when the screen changes, or in response.
	 * to a user initiated call to repaint();
	 */
	public void paint(Graphics g) {
		  drawMA( (Graphics2D) g); // Our Added-on drawing
    }
	
	/**
	 * Draw the MA graphics panel
	 * @param g
	 */
	public void drawMA(Graphics2D g2d) {
		//System.out.println("Drawing MA " + counter++);
		Dimension size = getSize();
		
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, size.width, size.height);
				
		int maxRows = size.height / stepSize;
		int maxCols = size.width / stepSize;
		for (int j = 0; j < maxRows; j++) {
		   for (int i = 0; i < maxCols; i++) {
			   
			   int redVal = validColor(i*5); // Random calculations just to get some color variation
			   int greenVal = validColor(255-j*5);
			   int blueVal = validColor((j*5)-(i*2));
			   
			   col = new Color(redVal, greenVal, blueVal);
			   
			   int startx = i*stepSize;
			   int starty = j*stepSize;
			   //int endx = startx + 15;
			   //int endy = starty + 15;
			   //paintLine( g2d, startx, starty, endx, endy, col); 
			   
			   // Draw a box, one pixel less than the step size to create a black outline
			   paintRect(g2d, startx, starty, stepSize-1, stepSize-1, col); 
		   }
		}
		
		g2d.setColor(Color.RED);
		g2d.drawString("Overlay", 10, 15);
	}
	
	/*
	 * A local routine to ensure that the color value is in the valid 0 to 255 range.
	 */
	private int validColor(int colorVal) {
		//if (colorVal > 255)
		//	colorVal = 255;
		//if (colorVal < 0)
		//	colorVal = 0;
		colorVal &= 0xFF; // It's faster to just crop the value to the lower 8 bits (i.e. 0x00 through 0xFF)
		return colorVal;
	}
	
	/*
	 * A convenience routine to set the color and draw a line
	 * @param g2d the 2D Graphics context
	 * @param startx the line start position on the x-Axis
	 * @param starty the line start position on the y-Axis
	 * @param endx the line end position on the x-Axis
	 * @param endy the line end position on the y-Axis
	 * @param color the line color
	 */
	private void paintLine(Graphics2D g2d, int startx, int starty, int endx, int endy, Color color) {
		g2d.setColor(color);
		g2d.drawLine(startx, starty, endx, endy);
	}
	
	/*
	 * A convenience routine to set the color and draw a filled rectangle
	 * @param g2d
	 * @param x the upper top left box start position on the x-Axis
	 * @param y the upper top left box start position on the y-Axis
	 * @param width the width in pixels
	 * @param height the height in pixels
	 * @param color
	 */
	private void paintRect(Graphics2D g2d, int x, int y, int width, int height, Color color) {
		g2d.setColor(color);
		g2d.fillRect(x, y, width, height);
	}	

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("MACanvas received an update");
		
		// this.repaint(); // Request the UI to redraw the JPanel
	}
	
}
