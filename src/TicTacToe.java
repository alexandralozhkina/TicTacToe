public class TicTacToe {
    String[][] field;
    String nowPlayer;

    public TicTacToe() {
        newGame();
    }

    void newGame() {
        field = new String[][]{{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};
        nowPlayer = "X";
    }

    String[][] getField() {
        return field;
    }

    String makeMove(int x, int y) {
        x -= 1;
        y -= 1;

        // Check if game is already over
        String gameStatus = this.checkGame();
        if (gameStatus != null) return "Game was ended";

        // Check if cell is occupied
        if (!field[x][y].equals("-")) {
            return "Cell " + (x + 1) + ", " + (y + 1) + " is already occupied";
        }

        // Make the move
        field[x][y] = nowPlayer;

        // Check game status after move
        gameStatus = checkGame();
        if (gameStatus != null) {
            if (gameStatus.equals("X")) return "Player X won";
            else if (gameStatus.equals("O")) return "Player O won"; // Fixed: "O" instead of "0"
            else return "Draw";
        }

        // Switch player
        nowPlayer = nowPlayer.equals("X") ? "O" : "X"; // Fixed: "O" instead of "0"
        return "Move completed";
    }

    String checkGame() {
        // Check rows and columns for both players
        for (int i = 0; i < 3; i++) {
            // Check rows for X
            if (field[i][0].equals("X") && field[i][1].equals("X") && field[i][2].equals("X")) {
                return "X";
            }
            // Check rows for O
            if (field[i][0].equals("O") && field[i][1].equals("O") && field[i][2].equals("O")) {
                return "O";
            }
            // Check columns for X
            if (field[0][i].equals("X") && field[1][i].equals("X") && field[2][i].equals("X")) {
                return "X";
            }
            // Check columns for O
            if (field[0][i].equals("O") && field[1][i].equals("O") && field[2][i].equals("O")) {
                return "O";
            }
        }

        // Check diagonals for X
        if (field[0][0].equals("X") && field[1][1].equals("X") && field[2][2].equals("X")) {
            return "X";
        }
        if (field[0][2].equals("X") && field[1][1].equals("X") && field[2][0].equals("X")) {
            return "X";
        }

        // Check diagonals for O
        if (field[0][0].equals("O") && field[1][1].equals("O") && field[2][2].equals("O")) {
            return "O";
        }
        if (field[0][2].equals("O") && field[1][1].equals("O") && field[2][0].equals("O")) {
            return "O";
        }

        // Check for draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j].equals("-")) {
                    return null; // Game continues
                }
            }
        }

        return "D"; // Draw
    }
}