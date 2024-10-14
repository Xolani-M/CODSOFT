package task_1_number_game.src;

import java.util.Scanner;

public class UserInput {
    private final Scanner scanner = new Scanner(System.in);

    public int getUserInput(){

        while(true){
            System.out.println("Flip a coin... or just guess the target");
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e){
                System.out.println("Coin toss didn't go your way. Enter a valid integer.");
            }
        }

    }

    public boolean playAgain(){
        System.out.println("Do you want to play again? (yes/no): ");

        String response = scanner.next();
        return response.equalsIgnoreCase("yes");
    }

    public void closeScanner(){
        scanner.close();
    }
}
