import java.util.*;

public class NascarRaceEvent
{
	public static void main(String[] arg) throws InterruptedException
	{
		int numRacers;
		Scanner k = new Scanner(System.in);
		String choice;
		Race race;
		int repeat = 0;

		// Limit to number of race cars on track.
		do{
			// Prompt for number of racers
			System.out.print("Enter the number of Racers: (Max:1000) ");	
			numRacers = getNumberOfRacer();
		}while(numRacers > 1000);
		
		
		do
		{
			// Do you want to give each racer a specific name?
			System.out.print("Do you want to enter " + numRacers + " names for each racer (y/n)? ");
			choice = k.nextLine();
			
			if(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y') // if yes...
			{
				race = promptForNames(numRacers);
				System.out.println("Names of Racers are on the LineUp!");
			}
			else												   // if no...
			{					
				race = defaultNames(numRacers);
				System.out.println("The LineUp is Ready!");
			}
		
		
			startRace(race);
			
			while(true)
			{
				if(Thread.activeCount() == 1)
				{
					System.out.print("The race is over. Want to race again? ");
					choice = k.nextLine();
					break;
				}
			}
         
         System.out.print("Bob");
         System.err.print("Bob2");
		}while(choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');
		
	}
	
	/*
	 * Instantiates a certain number of racers
	 * with prompted names from the user.
	 */
	public static Race promptForNames(int num)
	{
		String[] racers = new String[num];
		
		for(int i=0; i<racers.length; i++)
		{
			System.out.print("\t" + (i+1) + ") Enter racer name: ");
			racers[i] = getRacerName();
		}
		return  new Race(racers);
	}
	
	/*
	 * Instantiates a certain number of racers
	 * with default names.
	 */
	public static Race defaultNames(int num)
	{
		return  new Race(num);
	}
	
	/*
	 * Prompts user for integer
	 */
	public static int getNumberOfRacer()
	{
		Scanner k = new Scanner(System.in);
		return k.nextInt();
	}
	
	/*
	 * Prompts user of String
	 */
	public static String getRacerName()
	{
		Scanner k = new Scanner(System.in);
		return k.nextLine();
	}
	
	public static void startRace(Race r) throws InterruptedException
	{
		// The count down
		Thread.sleep(2000);
		System.out.println("\n!...On Your Mark...!");
		Thread.sleep(2000);
		System.out.println("  ~...Get Set...~");
		Thread.sleep(2000);
		System.out.println("        GO!\n");
		r.startRace();
	}
}
