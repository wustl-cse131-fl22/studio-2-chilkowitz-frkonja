package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double startAmount;
		double endAmount;
		double winChance;
		double winLimit;
		int roundCounter = 0;
		int totalSimulations = 0;
		int totalWins = 0;
		int amountDays;
		
		System.out.println("How much money did you bring to play with?");
		startAmount = in.nextDouble();
		System.out.println("What is the chance of winning (from 0 to 1)");
		winChance = in.nextDouble();
		System.out.println("What is your Win Limit (after what amount are you going home?)");
		winLimit = in.nextDouble();
		System.out.println("How many days do you want to play?");
		amountDays = in.nextInt();
		
		
		for (int i = amountDays ; i > 0 ; i-- ) {
			totalSimulations++;
			endAmount = startAmount;
			while (endAmount > 0 && endAmount < winLimit) {
				roundCounter ++;
				double win = Math.random ();
				if (win <= winChance) {
					endAmount ++;
				}
				else {
					endAmount --;
				}	
			}
			
			if (endAmount == winLimit) {
				totalWins ++;
			}

		
		
		 System.out.println("Start Amount: " + startAmount);
		 System.out.println("Win Chance: " + winChance);
		 System.out.println("Win Limit: " + winLimit);
		 System.out.println("Total simulations: " + totalSimulations);
		 System.out.println("Total wins: " + totalWins);
		}
		double ruinRate;
		double a = (1-winChance)/winChance;
		if (winChance == 0.5) {
			ruinRate = 1- startAmount/winLimit;	
		}
		else {
			ruinRate = (Math.pow(a, startAmount)-Math.pow(a, winLimit))/(1-Math.pow(a, winLimit));
		}
		System.out.println("Ruin Rate: " +ruinRate);
		
		
	}

}
