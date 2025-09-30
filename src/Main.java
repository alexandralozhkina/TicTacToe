import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Players will take turns entering coordinates (row column) from 1 to 3.");
        System.out.println("For example: '1 2' for row 1, column 2");
        System.out.println("Type 'exit' to quit the game.\n");

        while (true) {
            game.printField();
            System.out.println("Player " + game.nowPlayer + "'s turn:");
            System.out.print("Enter your move (row column): ");

            String input = scanner.nextLine().trim();

            // Check for exit command
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for playing!");
                break;
            }

            // Parse input
            String[] coordinates = input.split(" ");
            if (coordinates.length != 2) {
                System.out.println("Invalid input! Please enter two numbers separated by space (e.g., '1 2').");
                continue;
            }

            try {
                int row = Integer.parseInt(coordinates[0]);
                int col = Integer.parseInt(coordinates[1]);

                String result = game.makeMove(row, col);
                System.out.println(result);

                // Check if game has ended
                if (result.contains("won") || result.contains("Draw") || result.contains("ended")) {
                    game.printField();
                    System.out.println("Game over!");

                    // Ask if players want to play again
                    System.out.print("Would you like to play again? (yes/no): ");
                    String playAgain = scanner.nextLine().trim();
                    if (playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("y")) {
                        game.newGame();
                        System.out.println("New game started!\n");
                    } else {
                        System.out.println("Thanks for playing!");
                        break;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter numbers only.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
