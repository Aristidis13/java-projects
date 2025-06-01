import java.util.Random;
import java.util.Scanner;

/**
 * The type Numbers game.
 */
public class NumbersGame {
		/**
		 * The entry point of application.
		 *
		 * @param args the input arguments
		 */
		public static void main(String[] args) {
				int available_tries = 10;
				int selectedNumber = selectANumber(available_tries);
				tryToFindTheSelectedNumber(selectedNumber, available_tries);
		}

		private static void tryToFindTheSelectedNumber(int selectedNumber, int available_tries) {
				boolean userFoundTheNumber = false;
				int remaining_tries = available_tries;
				Scanner userInputReceiver = new Scanner(System.in);
				do {
						int userInput = userInputReceiver.nextInt();
						--remaining_tries;
						if (userInput > selectedNumber) {
								System.out.printf("%s%n", userInput + " is larger than the selected number!");
						} else if (userInput < selectedNumber) {
								System.out.println(userInput + " is smaller than the selected number!");
						} else {
								userFoundTheNumber = true;
								System.out.println("You successfully found the number! Congratulations\n");
						}

						if (!userFoundTheNumber) {
								System.out.println("\nPlease Select a new number");
								System.out.println(remaining_tries + " more tries are available");
						}
				} while (!userFoundTheNumber && remaining_tries > 0);
		}

		private static int selectANumber(int available_tries) {
				Random randomConstructor = new Random();
				int selectedNumber = randomConstructor.nextInt(100);
				System.out.printf("%s%s%s%n%n%s",
								"Welcome to the Numbers Game\n",
								"I have selected a Number from 0 to 100 and you must find it otherwise the world is gonna end\n",
								"You have " + available_tries + " tries",
								"What is the number I chose?\n"
				);
				return selectedNumber;
		}
}