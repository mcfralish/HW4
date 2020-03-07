/* Michael C Fralish
 * 03/06/2020
 * PID: 001-17-6489
 * Title: Draw
 * This program creates a drawing panel with the picture in the assignment.
 */
import java.awt.*;
public class Draw {

	public static void main(String[] args) {


		DrawingPanel panel = new DrawingPanel(400,425);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.CYAN);
		shape(g,0,0,100,10,1);
		shape(g,18,175,24,4,6);
		shape(g,180,25,40,5,5);
		shape(g,180,250,36,6,4);
		
	}
	
	// Template for drawing the shape
	public static void shape(Graphics g,int startX, int startY, int subd, int numCirc, int d) {
		int x = startX;
		int y = startY;
		for(int r=0;r<d;r++) {
			for(int c=0;c<d;c++) {
				squares(g,x,y,subd);
				circles(g,x,y,subd,numCirc);
				lines(g,x,y,subd);
				x+=subd;
			}
			x = startX;
			y+=subd;
		}
		
	}
	
	// Draws all the squares
	public static void squares(Graphics g, int x, int y, int d) {
		g.setColor(Color.GREEN);
		g.fillRect(x,y,d,d);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, d, d);
	}
	
	// Draws all the circles
	public static void circles(Graphics g, int x, int y, int d, int num) {
		int r = d;
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, r, r);
		g.setColor(Color.BLACK);
		while (r>=d/num) {
			g.drawOval(x,y,r,r);
			x+=(d/(num*2));
			y+=(d/(num*2));
			r-=(d/num);
		}
	}
	
	// Draws the lines
	public static void lines(Graphics g,int x,int y, int d) {
		g.drawLine(x, y, x+d, y+d);
		g.drawLine(x+d, y, x, y+d);	
		g.drawLine(x, y+(d/2), x+d, y+(d/2));
	}

}
