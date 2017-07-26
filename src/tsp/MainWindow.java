package tsp;

import java.util.ArrayList;

import javax.swing.JFrame;

public class MainWindow extends JFrame
{	
	private static final long serialVersionUID = 4585859708523438265L;
	private PathPainter painter = new PathPainter();
	
	public MainWindow()
	{
		super("Travelling Salesman Problem");
		
        setContentPane(painter);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(1024, 768);

        setVisible(true); 
	}
	
	public void setPath(ArrayList<City> arrayList)
	{
		painter.setPath(arrayList);
	}
	
	public void drawPath()
	{
		painter.repaint();
	}
}
