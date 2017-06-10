import java.util.Stack;
import java.util.Scanner;

public class bowling
{
	int frame = 1;
	int frameSum;
	int amountOfRolls = 0;
	int firstRoll;
	int secondRoll;
	int thirdRoll;
	int totalScore = 0;
	Stack<Integer> score = new Stack<Integer>();
	Scanner sc = new Scanner(System.in);
	boolean start = true;
	
	public void scoring()
	{
		if(start == true)
		{
			System.out.println("Welcome to the bowling score calculator.");
			System.out.println("If you get a strike just type in '10' for the firstroll for that frame, not 'X'.  For a spare, type in the number of pins knocked down in each roll, do not type '/'.");
			start = false;
		}
		
		while(frame <= 10)
		{
			if(frame == 10)
			{
				tenthFrame();
				break;
			}
			System.out.println("Frame " + frame);
			System.out.println("Enter the score for the first roll:");
			firstRoll =  sc.nextInt();
			if(firstRoll == 10)
			{
				strike(score);
			}
			
			else
			{
				System.out.println("Enter the score for the second roll:");
				secondRoll =  sc.nextInt();
			}
			
			if(secondRoll + firstRoll == 10)
			{
				spare(score);
			}
			
			
			
			else
			{
				
				frameSum = firstRoll + secondRoll;
				score.push(frameSum);
				amountOfRolls++;
				frame++;
			}

			
		}
		
		for(int i = 0; i < score.size();)
		{
			totalScore += (int) score.pop();
		}
		
	}
	
	public void strike(Stack<Integer> score)
	{
		score.push(10);
		frame++;
		if(frame == 10)
		{
			tenthFrame();
		}
		System.out.println("Frame " + frame);
		System.out.println("Enter the score for the first roll:");
		firstRoll =  sc.nextInt();
		while(firstRoll == 10 && frame < 10)
		{
			score.push(10);
			frame++;
			if(frame == 10)
			{
				tenthFrame();
				return;
			}
			System.out.println("Frame " + frame);
			System.out.println("Enter the score for the first roll:");
			firstRoll = sc.nextInt();
			score.push(firstRoll);
			score.push(10);
			
			
		}
		
		System.out.println("Enter the score for the second roll:");
		secondRoll = sc.nextInt();
		
		
		if(secondRoll + firstRoll == 10)
		{
			spare(score);
		}
		
		if((secondRoll + firstRoll == 10) && frame == 10)
		{
			tenthFrame();
		}
		
		
		else
		{
			
			score.push(firstRoll + secondRoll);
			amountOfRolls++;
		}

		
	}
	
	//change return type to int later
	public void spare(Stack<Integer> score)
	{
		frame++;
		amountOfRolls++;
		score.push(10);
		System.out.println("Frame " + frame);
		System.out.println("Enter the socre for the first roll.");
		firstRoll =  sc.nextInt();
		if(firstRoll == 10)
		{
			strike(score);
		}
		
		amountOfRolls++;
		System.out.println("Enter the score for the second roll:");
		secondRoll = sc.nextInt();
		
		if(secondRoll + firstRoll == 10)
		{
			spare(score);
		}
		
		
		score.push((firstRoll * 2) + secondRoll);
		frame++;
		amountOfRolls++;
		
		
	}
	
	public void tenthFrame()
	{
		System.out.println("Frame " + frame);
		System.out.println("Enter the score for the first roll:");
		firstRoll = sc.nextInt();
		if(firstRoll == 10)
		{
			score.push(firstRoll);
			System.out.println("Enter the score for the second roll:");
			secondRoll = sc.nextInt();
			if(secondRoll == 10)
			{
				score.push(secondRoll);
				score.push(secondRoll);
				//score.push(10);
				System.out.println("Enter the score for the third roll");
				thirdRoll = sc.nextInt();
				//score.push(10);
				score.push(thirdRoll);
				score.push(thirdRoll);
			}
			
			else
			{
				score.push(secondRoll);
				
				System.out.println("Enter the score for the third roll");
				thirdRoll = sc.nextInt();
				score.push(thirdRoll);
				
			}
			
		}
		else
		{
			System.out.println("Enter the score for the second roll.");
			secondRoll = sc.nextInt();
			if(firstRoll + secondRoll == 10)
			{
				score.push(firstRoll + secondRoll);
				System.out.println("Enter the score for the third roll.");
				thirdRoll = sc.nextInt();
				score.push(thirdRoll);
			}
			else
			{
				score.push(firstRoll + secondRoll);
			}
		
		}
	}
	
	
}
