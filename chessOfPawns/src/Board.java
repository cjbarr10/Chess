public class Board {
    String[][] board;

    Board(String[][] board){
        this.board = board;
    }

    public void setSize(String[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(i == 0){
                    board[i][j] = j + " ";
                }else if(j == 0){
                    board[i][j] = i + " ";
                }else if(i == 1){
                    board[i][j] = "P ";
                }else if(i == board.length-1){
                    board[i][j] = "p ";
                }else{
                    board[i][j] = "- ";
                }
            }
        }
    }

    public void printDisplay(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
