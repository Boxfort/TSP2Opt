package tsp;

import java.util.ArrayList;

public class TourManager 
{
	private static ArrayList<City> _cities = new ArrayList<City>();
	private static int [][] _distances;

	public static void setCities(ArrayList<City> cities)
	{
		_cities = cities;
	}
	
	public static void addCity(City city)
	{
		_cities.add(city);
	}
	
	public static City getCity(int index)
	{
		return _cities.get(index);
	}
	
	public static ArrayList<City> getCities()
	{
		return (ArrayList<City>) _cities.clone();
	}
	
	public static void clearCities()
	{
		_cities.clear();
	}
	
	public static int numberOfCities()
	{
		return _cities.size();
	}
	
	public static void calculateDistanceMatrix()
	{
		_distances = new int[numberOfCities()][numberOfCities()];
		
		for(int i = 0; i < _cities.size(); i++)
		{
			for(int j = 0; j < _cities.size(); j++)
			{
				_distances[i][j] = _cities.get(i).distanceTo(_cities.get(j));
			}
		}
	}
	
	public static int getDistanceBetween(City cityA, City cityB)
	{
		int x = _cities.indexOf(cityA);
		int y = _cities.indexOf(cityB);
		
		return _distances[x][y];
	}
}
