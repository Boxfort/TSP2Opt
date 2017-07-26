package tsp;

import java.util.Collections;

public class TSPSolver 
{
	public Tour solve(Tour t)
	{
		// Get tour size
	    int size = t.tourSize();
	 
	    // repeat until no improvement is made 
	    boolean improvement = true;
	    
	    while ( improvement )
	    {
	    	Tour newTour = new Tour();
	    	
	    	improvement = false;
	    	
	        double best_distance = t.getDistance();
	 
	        for ( int i = 0; i < size - 1; i++ ) 
	        {
	            for ( int k = i + 1; k < size; k++) 
	            {
	                newTour = twoOptSwap( i, k, t );
	 
	                double new_distance = newTour.getDistance();
	 
	                if ( new_distance < best_distance ) 
	                {
	                    // Improvement found so loop again
	                    improvement = true;
	                    t = newTour;
	                    best_distance = new_distance;
	                    System.out.println("Current distance: " + best_distance);
	                }
	            }
	        }	 
	    }
	    
	    return t;
	}
	
	private Tour twoOptSwap(int i, int k, Tour tour)
	{
	    Tour newTour = new Tour(tour.getTour());
	 
	    //take route[0] to route[i-1] and add them in order to new_route
	    for ( int c = 0; c <= i - 1; ++c )
	    {
	        newTour.setCity( c, tour.getCity( c ) );
	    }
	     
	    //take route[i] to route[k] and add them in reverse order to new_route
	    int dec = 0;
	    for ( int c = i; c <= k; c++ )
	    {
	        newTour.setCity( c, tour.getCity( k - dec ) );
	        dec++;
	    }
	 
	    //take route[k+1] to end and add them in order to new_route
	    for ( int c = k + 1; c < tour.tourSize(); c++ )
	    {
	        newTour.setCity( c, tour.getCity( c ) );
	    }
	    
	    return newTour;
	}
}
