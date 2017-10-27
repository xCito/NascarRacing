
public class Race 
{
	private RaceCar[] cars;			// Each individual racer
	private PitStop pit;			// The pitStop they share
	private int place = 0;			// To return their position in race 
	private String[] names;			// Optional: to hold names
	
	// Constructor
	// to give racers a default name for race.
	public Race(int numCars)
	{
		cars = new RaceCar[numCars];
		pit = new PitStop();
		getCarsInRace();
	}
	
	// Constructor
	// to give each racer a specific name.
	public Race(String[] n)
	{
		names = n.clone();
		cars = new RaceCar[names.length];
		pit = new PitStop();
		getCarsInRace(names);
	}
	
	// Default name
	public void getCarsInRace()
	{
		for(int i=0; i<cars.length; i++)
		{
			cars[i] = new RaceCar("Car #" + i, this, pit);
			Thread t = new Thread(cars[i]);
			t.start();		
		}
	}
	
	// Specific name
	public void getCarsInRace(String[] n)
	{
		for(int i=0; i<n.length; i++)
		{
			cars[i] = new RaceCar(n[i], this, pit);
			Thread t = new Thread(cars[i]);
			t.start();		
		}
	}
	
	/*
	 * Collects all the racers onto race track
	 * 
	 * Holds all the threads at this statement.
	 */
	public synchronized void getReady() throws InterruptedException
	{
		this.wait();
	}
	
	/*
	 * All racers are released at the same time.
	 * 
	 * All threads continue running simultaneously.
	 */
	public synchronized void startRace() 
	{
		this.notifyAll();
	}
	
	/*
	 * First racer to call this method get their position
	 * in the race returned.
	 */
	public synchronized int finished()
	{
		return ++place;
	}
	
}
