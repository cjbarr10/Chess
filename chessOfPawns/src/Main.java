import java.util.Scanner;

public class Main {
    static void main() {
        //true == white and false == black
        boolean player = true;
        int boardSize;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("What size you want the Board x by x: ");
            boardSize = scanner.nextInt();
        } while (boardSize <= 1);
        String[][] board = new String[boardSize+1][boardSize+1];
        Board b1 = new Board(board);

        b1.setSize(board);
        b1.printDisplay(board);

        while(gameOver(board)){
            new gameLogicWhite(player, board, b1);
            player = !player;
            b1.printDisplay(board);
        }
    }

    private static boolean gameOver(String[][] board) {
        int whitePiece = 0;
        int blackPiece = 0;
        for (int i = 0; i <board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].equals("P ") || board[i][j].equals("Q ")){
                    whitePiece += 1;
                }else if(board[i][j].equals("p ") || board[i][j].equals("q ")){
                    blackPiece += 1;
                }
            }
        }

        return whitePiece > 0 && blackPiece > 0;
    }

}
