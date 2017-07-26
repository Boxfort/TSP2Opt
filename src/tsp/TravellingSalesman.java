package tsp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class TravellingSalesman 
{
	public static void main(String[] args) 
	{
        //Load .tsp file and add to tourManager
		ArrayList<City> cities = TSPLibLoader.loadTSPLib("C:\\Users\\Jack\\workspace\\TSP2Opt\\src\\data\\berlin52.tsp"); 	
		for(int i = 0; i < cities.size(); i++)
		{
			System.out.println("X: "+cities.get(i).getX()+" | Y: "+cities.get(i).getY());
			TourManager.addCity(cities.get(i));
		}
		
		//Calculate distances between all points
		
		int iterations = 1;
		//long[] results = new long[iterations];
		
		//FileWriter fw = new FileWriter("C:\\Users\\Jack\\workspace\\TSP2Opt\\src\\results\\results1.csv");
		
		//fw.append("Count");
		//fw.append(',');
		//fw.append("Run time");
		//fw.append('\n');
		
		TourManager.calculateDistanceMatrix();

		for(int j = 0; j < iterations; j++)
		{
			long startTime = System.nanoTime();
		    
		    //Solve problem
		    TSPSolver solver = new TSPSolver();
		    //Tour t = solver.solve(new Tour());
		    Tour t = new Tour();
		    
		    long elapsedTime = System.nanoTime() - startTime;
		    
		    System.out.println("Final Distance: " + t.getDistance());
		    System.out.println("Is tour valid? " + t.isValidTour());
		    
		    //Convert time elapsed from nanoseconds to milliseconds and print
		    System.out.println("Time elapsed: " + (TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS)) + " milliseconds");
		    
		    //Create window and draw solution
		    MainWindow window = new MainWindow();
		    window.setPath(t.getTour());
		    window.drawPath();
		    
			//results[j] = TimeUnit.MILLISECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS);
		}
		
		//double total = 0;
		//double average = 0;
		
		//for(int j = 0; j < iterations; j++)
		//{
		//	total += results[j];
		//}
		
		//average = total / iterations;
		
		//fw.append(i+"");
		//fw.append(',');
		//fw.append(average+"");
		//fw.append('\n');
		//fw.flush();
		TourManager.clearCities();
		//fw.close();
	}
}
