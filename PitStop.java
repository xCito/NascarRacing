import java.util.Random;

public class PitStop
{
	Random r = new Random();
	
	/*
	 * Racer stops by the PitStop station for a quick break. PitStop only
	 * has room for one. Other must wait until first racer exits.
	 * 
	 * Actually: Only one thread(racer) should be "using" this method
	 * at any given time. Once the first thread(racer) exits this method, other
	 * threads(racers) can "use" it. This is due to the keyword 'synchronized'.  
	 * 
	 * Their shortBreak time is RANDOMIZED each time called.
	 */
	public synchronized void shortBreak(String n) throws InterruptedException
	{
		int time = (int)(r.nextDouble()*1000);
		System.out.println(n + " is at the PitStop..." + time);
		Thread.sleep(time);
	}
}