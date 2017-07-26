package tsp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Tour 
{
	private ArrayList<City> tour = new ArrayList<City>();
	private int distance = 0;
	
	public Tour()
	{
		generateNNTour();
	}
	
	public Tour(ArrayList<City> tour)
	{
		this.tour = tour;
	}
	
	private void generateRandomTour()
	{
		//Take a copy of the list of cities and re-arrange them into a random order
		this.tour = TourManager.getCities();
		Collections.shuffle(this.tour);
	}
	
	private void generateNNTour()
	{
		City c = TourManager.getCity(0);
		
		this.tour.add(c);
		
		City currentCity = this.tour.get(0);
		City closest = null;
			
		while(this.tour.size() < TourManager.numberOfCities())
		{	
			int distance = Integer.MAX_VALUE;
			
			for(int i = 0; i < TourManager.numberOfCities(); i++)
			{
				if(TourManager.getDistanceBetween(currentCity, TourManager.getCity(i)) < distance && this.tour.contains(TourManager.getCity(i)) == false)
				{
					closest = TourManager.getCity(i);
					distance = TourManager.getDistanceBetween(currentCity, closest);
				}
			}
			
			this.tour.add(closest);
			currentCity = closest;
		}
	}
	
	public boolean isValidTour()
	{
		//Ensure the tour contains all of the cities
		for(City c : TourManager.getCities())
		{
			if(!this.tour.contains(c))
			{
				return false;
			}
		}
		
		//Dump tour into HashSet to remove duplicate entries
		HashSet<City> set = new HashSet<City>(this.tour);
		//If the length of tour has changed, i.e. there were duplicates, return false
		if(this.tour.size() < set.size())
		{
			return false;
		}
		
		return true;
	}
	
	public void setCity(int index, City city)
	{
		this.tour.set(index, city);
		distance = 0;
	}
	
	public int getDistance()
	{
		if(this.distance == 0)
		{
			for(int i = 0; i < this.tour.size(); i++)
			{
				int nextCity = (i+1) % this.tour.size();
				
				this.distance += TourManager.getDistanceBetween(this.tour.get(i), this.tour.get(nextCity));
			}
		}
		
		return this.distance;
	}
	
	public int tourSize()
	{
		return this.tour.size();
	}
	
	public City getCity(int index)
	{
		return this.tour.get(index);
	}
	
	public ArrayList<City> getTour()
	{
		return (ArrayList<City>) this.tour.clone();
	}
}
