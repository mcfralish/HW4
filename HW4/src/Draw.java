/* Michael C Fralish
 * 03/06/2020
 * PID: 001-17-6489
 * Title: Draw
 * This program creates a drawing panel with the option for it to look like either the picture or the table.
 * This was a bit confusing because the picture does not match the table.
 * The user may choose which one will print out.
 */
import java.awt.*;
import java.util.*;
public class Draw {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Options for the grader to choose the picture or the table
		System.out.println("Would you like the drawing panel to look like the picture or the what the table requests?");
		System.out.println("The two are different.");
		System.out.println("1 Picture");
		System.out.println("2 Table");
		int answer = sc.nextInt();
		
		while (answer>2||answer<1) {
			System.out.println("Please select Picture or Table.");
			answer = sc.nextInt();
		}
		
		// This makes it look like the picture
		if (answer==1) {
			DrawingPanel panel = new DrawingPanel(400,425);
			Graphics g = panel.getGraphics();
			panel.setBackground(Color.CYAN);
			shape(g,0,0,100,10,1);
			shape(g,18,175,24,4,6);
			shape(g,180,25,40,5,5);
			shape(g,180,250,36,6,4);
		}
		
		// This makes it look like the table describes
		if (answer==2) {
			DrawingPanel panel = new DrawingPanel(400,400);
			Graphics g = panel.getGraphics();
			panel.setBackground(Color.CYAN);
			shape(g,0,0,100,5,1);
			shape(g,10,120,24,4,5);
			shape(g,150,20,40,5,6);
			shape(g,130,275,36,3,3);
		}	
		
		sc.close();
		
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
