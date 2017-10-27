import java.util.Random;

public class RaceCar implements Runnable
{
	private String racerName;
	private PitStop pit;
	private Race race;
	
	public RaceCar(String name, Race r, PitStop ps)
	{
		racerName = name;
		race = r;
		pit = ps;
		System.out.println(racerName + " is in the Race");
	}
	
	/*
	 * Randomized Time ranging from 3-4 seconds to complete
	 * one lap around the track.
	 */
	public int lapTime()
	{
		Random r = new Random();
		return (int)((r.nextDouble() * 1000) + 3000);
	}
	
	public void run() 
	{
		int lapTime;
		try
		{
			
			this.race.getReady();
			
			lapTime = lapTime();
			Thread.sleep(lapTime);
			System.out.println(racerName + " lap " + (1) + "..." + lapTime);
			
			for(int i=1; i<10; i++)
			{
				lapTime = lapTime();
				Thread.sleep(lapTime);
				System.out.println(racerName + " lap " + (i+1) + "..." + lapTime);
				
				if(i == 5)							// PitStop by the 5th Lap
				{
					pit.shortBreak(racerName);
				}
				
			}
			Thread.sleep(lapTime);
			System.out.println("\t*****"+ racerName + " FINISHED***** PLACE: " + race.finished());
			
		}
		catch(Exception e){
			System.out.println(racerName + " had a car accident    :'( ");
		}
	}

}