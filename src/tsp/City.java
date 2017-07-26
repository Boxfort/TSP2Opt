package tsp;

public class City 
{
	private int x, y;
	
	public City()
	{
		this.x = (int)(Math.random() * 300);
		this.y = (int)(Math.random() * 300);
	}
	
	public City(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int distanceTo(City city)
	{
		long dx = Math.abs(this.x - city.x);
		long dy = Math.abs(this.y - city.y);
		
		int distance = (int)Math.sqrt((dx * dx) + (dy * dy));
		
		return distance;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
}
