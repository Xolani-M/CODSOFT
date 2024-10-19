package task_1_number_game.src;

import java.util.Scanner;

public class UserInput {
    private final Scanner scanner = new Scanner(System.in);

    public int getUserInput(){

        while(true){
            System.out.println(GameMessenger.FLIP_COIN_MSG);
            try {
                return Integer.parseInt(scanner.next());
            } catch (NumberFormatException e){
                System.out.println(GameMessenger.INVALID_INPUT_MSG);
            }
        }

    }

    public boolean playAgain(){
        System.out.println(GameMessenger.PLAY_AGAIN_PROMPT);

        String response = scanner.next();
        return response.equalsIgnoreCase("yes");
    }

    public void closeScanner(){
        scanner.close();
    }
}
