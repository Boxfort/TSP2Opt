package tsp;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PathPainter extends JPanel
{
	private static final long serialVersionUID = 3730888132214793456L;
	
	private ArrayList<City> path;
	private final int CITY_DIAMETER = 10;
	
	private final double scale = 0.5;
	private final int xOffset = 1;
	private final int yOffset = 1;
	
    @Override
    public void paintComponent(Graphics g) 
    {
    	if(path == null)
    		return;
    	
    	for(int i = 0; i < path.size(); i++)
		{
			City cityA = path.get(i);
			int j = (i+1) % path.size();
			City cityB = path.get(j);
			
			g.setColor(Color.BLACK);
			
			//Line positions
			int x1 = (int)((cityA.getX() + (CITY_DIAMETER/2)) * scale) + xOffset;
			int x2 = (int)((cityB.getX() + (CITY_DIAMETER/2)) * scale) + xOffset;
			int y1 = (int)((cityA.getY() + (CITY_DIAMETER/2)) * scale) + yOffset;
			int y2 = (int)((cityB.getY() + (CITY_DIAMETER/2)) * scale) + yOffset;
			
			g.drawLine(x1, y1, x2, y2);
			
			//Circle positions
			int x = (int)(path.get(i).getX() * scale) + xOffset;
			int y = (int)(path.get(i).getY() * scale) + yOffset;
			int diameter = (int)(CITY_DIAMETER * scale); 
			
			g.drawOval(x, y, diameter, diameter);
		}
    }
    
    public void setPath(ArrayList<City> path)
    {
    	this.path = path;
    }
} 
