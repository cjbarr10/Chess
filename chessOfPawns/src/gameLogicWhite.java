import java.util.Scanner;

public class gameLogicWhite {
    public gameLogicWhite(boolean player, String[][] board, Board b1) {
        boolean isTrue = true;
        String colorPiece;
        String colorPiece1;
        if (player) {
            colorPiece = "P ";
            colorPiece1 = "Q ";
        } else {
            colorPiece = "p ";
            colorPiece1 = "q ";
        }
        Scanner scanner = new Scanner(System.in);
        String name;
        if(colorPiece.equals("P ")){
            name = "P/Q";
        }else{
            name = "p/q";
        }
        while(isTrue) {
            System.out.println("What piece would you like to move " + name + ": ");
            System.out.println("Row: ");
            int row = scanner.nextInt();
            System.out.println("Column");
            int column = scanner.nextInt();
            isTrue = checkPiece(row, column, colorPiece, board, player, colorPiece1);
            if(isTrue){
                System.out.println("Can't do that");
                b1.printDisplay(board);
            }
        }
    }

    private boolean checkPiece(int row, int column, String piece, String[][] board, boolean player, String colorPiece1) {
        boolean isTrue = true;
            if (board[row][column].equals(piece) || board[row][column].equals(colorPiece1)) {
                String mainPiece = board[row][column];
                Scanner scanner = new Scanner(System.in);
                System.out.println("Where would you like to move.");
                System.out.println("Row: ");
                int moveRow = scanner.nextInt();
                System.out.println("Column: ");
                int moveColumn = scanner.nextInt();
                isTrue = checkIfPieceCanMove(row, column, moveRow, moveColumn, board, player, mainPiece);
            } else {
                System.out.println("False");
            }
        return isTrue;
    }

    private boolean checkIfPieceCanMove(int row, int column, int moveRow, int moveColumn, String[][] board, boolean player, String colorPiece1) {
        if(player){
            if(colorPiece1.equals("Q ")){
                return checkIfQueenPieceCanMove(row, column, moveRow, moveColumn, board, true);
            }else{
                if(moveRow - row < 2 && moveColumn - column < 2) {
                    if((column == 5 || row == 5) && board[row + 1][column - 1].equals(board[moveRow][moveColumn]) && (board[moveRow][moveColumn].equals("p ") ||
                            board[moveRow][moveColumn].equals("q ")) && column != moveColumn || ((board[row + 1][column].equals(board[moveRow][moveColumn])) &&
                            board[moveRow][moveColumn].equals("- ") && column == moveColumn)) {

                        board[moveRow][moveColumn] = "P ";
                        board[row][column] = "- ";
                        if (moveRow == board.length - 1) {
                            board[moveRow][moveColumn] = "Q ";
                        }
                        return false;
                    }else if(column == 5){
                        return true;
                    }else if (((board[row + 1][column + 1].equals(board[moveRow][moveColumn]) || board[row + 1][column - 1].equals(board[moveRow][moveColumn])) &&
                            (board[moveRow][moveColumn].equals("p ") || board[moveRow][moveColumn].equals("q ")) && column != moveColumn) ||
                            ((board[row + 1][column].equals(board[moveRow][moveColumn])) && board[moveRow][moveColumn].equals("- ") && column == moveColumn)) {

                        board[moveRow][moveColumn] = "P ";
                        board[row][column] = "- ";
                        if (moveRow == board.length - 1) {
                            board[moveRow][moveColumn] = "Q ";
                        }
                        return false;
                    }
                }
            }
        }else {
            if(colorPiece1.equals("p ")){
                return checkIfQueenPieceCanMove(row, column, moveRow, moveColumn, board, false);
            }else{
                if(row - moveRow < 2 && moveColumn - column < 2) {
                    if ((column == 5 || row == 5) && (board[moveRow][moveColumn].equals(board[row - 1][column - 1]) &&
                            (board[moveRow][moveColumn].equals("P ") || board[moveRow][moveColumn].equals("Q ")))) {

                        board[moveRow][moveColumn] = "p ";
                        board[row][column] = "- ";
                        if (moveRow == 1) {
                            board[moveRow][moveColumn] = "q ";
                        }
                        return false;
                    } else if ((board[row - 1][column].equals(board[moveRow][moveColumn]) && board[moveRow][moveColumn].equals("- ")) ||
                            board[row - 1][column - 1].equals(board[moveRow][moveColumn]) || board[row - 1][column + 1].equals(board[moveRow][moveColumn]) &&
                            (board[moveRow][moveColumn].equals("P ")|| board[moveRow][moveColumn].equals("Q "))) {
                        board[moveRow][moveColumn] = "p ";
                        board[row][column] = "- ";
                        if (moveRow == 1) {
                            board[moveRow][moveColumn] = "q ";
                        }
                        return false;
                    }
                }
                return true;
            }

        }
        return true;
    }

    private boolean checkIfQueenPieceCanMove(int row, int column, int moveRow, int moveColumn, String[][] board, boolean player) {
        boolean b = (moveRow - 1 == row || moveRow == row || moveRow + 1 == row) && (moveColumn - 1 == column || moveColumn == column || moveColumn + 1 == column);
        if(player){
            if(b){
                if ((board[row - 1][column - 1].equals(board[moveRow][moveColumn]) || board[row][column - 1].equals(board[moveRow][moveColumn]) ||
                        board[row + 1][column - 1].equals(board[moveRow][moveColumn]) || board[row + 1][column].equals(board[moveRow][moveColumn]) ||
                        board[row - 1][column].equals(board[moveRow][moveColumn]) || board[row + 1][column + 1].equals(board[moveRow][moveColumn]) ||
                        board[row][column + 1].equals(board[moveRow][moveColumn]) || board[row - 1][column + 1].equals(board[moveRow][moveColumn])) &&
                        (board[moveRow][moveColumn].equals("- ") || board[moveRow][moveColumn].equals("p ")) || board[moveRow][moveColumn].equals("q ")) {
                    System.out.println("surface");
                    board[moveRow][moveColumn] = "Q ";
                    board[row][column] = "- ";
                    return false;
                }
            }else if(checkDirection(row, column, moveRow, moveColumn, board, true)){
                board[moveRow][moveColumn] = "Q ";
                board[row][column] = "- ";
                System.out.println("Direction");
                return false;
            }
        }else{
            if(b) {
                if ((board[row - 1][column - 1].equals(board[moveRow][moveColumn]) || board[row][column - 1].equals(board[moveRow][moveColumn]) ||
                        board[row + 1][column - 1].equals(board[moveRow][moveColumn]) || board[row + 1][column].equals(board[moveRow][moveColumn]) ||
                        board[row - 1][column].equals(board[moveRow][moveColumn]) || board[row + 1][column + 1].equals(board[moveRow][moveColumn]) ||
                        board[row][column + 1].equals(board[moveRow][moveColumn]) || board[row - 1][column + 1].equals(board[moveRow][moveColumn]) &&
                        (board[moveRow][moveColumn].equals("- ") || board[moveRow][moveColumn].equals("P ")) || board[moveRow][moveColumn].equals("P "))) {

                    board[moveRow][moveColumn] = "q ";
                    board[row][column] = "- ";
                    return false;
                }
            }else if(checkDirection(row, column, moveRow, moveColumn, board, false)){

                board[moveRow][moveColumn] = "q ";
                board[row][column] = "- ";
                return false;
            }
        }
        return true;
    }
    private boolean checkDirection(int row, int column, int moveRow, int moveColumn, String[][] board, boolean player) {
        if(player){
            for (int i = 1; i < board.length; i++){
                if(row + i == moveRow && column + i == moveColumn) {
                    for (int j = row+1; j < moveRow; j++) {
                        if(board[j][j].equals("p ") || board[j][j].equals("q ")){
                            return false;
                        }
                    }
                }else if(row + i == moveRow && column - i == moveColumn){
                    int num = 1;
                    for (int j = row+1; j < moveRow; j++) {
                        if(board[j][column-num].equals("p ") || board[j][column-num].equals("q ")){
                            return false;
                        }
                        num++;
                    }
                }else if(row - i == moveRow && column - i == moveColumn){
                    for (int j = row-1; j > moveRow; j--) {
                        if(board[j][j].equals("p ") || board[j][j].equals("q ")){
                            return false;
                        }
                    }
                }else if(row - i == moveRow && column + i == moveColumn){
                    int num = 1;
                    for (int j = row-1; j < moveRow; j++) {
                        if(board[j][column+num].equals("p ") || board[j][column+num].equals("q ")){
                            return false;
                        }
                        num--;
                    }
                }else if(row == moveRow && column + i == moveColumn){
                    for (int j = column+1; j < moveColumn; j++) {
                        if(board[row][j].equals("p ") || board[row][j].equals("q ")){
                            return false;
                        }
                    }
                }else if(row == moveRow && column - i == moveColumn){
                    for (int j = column-1; j > moveColumn; j--) {
                        if(board[row][j].equals("p ")|| board[row][j].equals("q ")){
                            return false;
                        }
                    }
                }else if(row + i == moveRow && column == moveColumn){
                    for (int j = row+1; j < moveRow; j++) {
                        if(board[j][column].equals("p ")|| board[j][column].equals("q ")){
                            return false;
                        }
                    }
                }else if(row - i == moveRow && column == moveColumn){
                    for (int j = row-1; j < moveRow; j++) {
                        if(board[j][column].equals("p ") || board[j][column].equals("q ")){
                            return false;
                        }
                    }
                }
            }
        }else {
            for (int i = 1; i < board.length; i++){
                if(row + i == moveRow && column + i == moveColumn) {
                    for (int j = row+1; j < moveRow; j++) {
                        if(board[j][j].equals("P ")|| board[j][j].equals("Q ")){
                            return false;
                        }
                    }
                }else if(row + i == moveRow && column - i == moveColumn){
                    int num = 1;
                    for (int j = row+1; j < moveRow; j++) {
                        if(board[j][column-num].equals("P ") || board[j][column-num].equals("Q ")){
                            return false;
                        }
                        num++;
                    }
                }else if(row - i == moveRow && column - i == moveColumn){
                    for (int j = row-1; j > moveRow; j--) {
                        if(board[j][j].equals("P ")|| board[j][j].equals("Q ")){
                            return false;
                        }
                    }
                }else if(row - i == moveRow && column + i == moveColumn){
                    int num = 1;
                    for (int j = row-1; j < moveRow; j++) {
                        if(board[j][column+num].equals("P ") || board[j][column+num].equals("Q ")){
                            return false;
                        }
                        num--;
                    }
                }else if(row == moveRow && column + i == moveColumn){
                    for (int j = column+1; j < moveColumn; j++) {
                        if(board[row][j].equals("P ")|| board[row][j].equals("Q ")){
                            return false;
                        }
                    }
                }else if(row == moveRow && column - i == moveColumn){
                    for (int j = column-1; j > moveColumn; j--) {
                        if(board[row][j].equals("P ") || board[row][j].equals("Q ")){
                            return false;
                        }
                    }
                }else if(row + i == moveRow && column == moveColumn){
                    for (int j = row+1; j < moveRow; j++) {
                        if(board[j][column].equals("P ") || board[j][column].equals("Q ")){
                            return false;
                        }
                    }
                }else if(row - i == moveRow && column == moveColumn){

                    for (int j = row-1; j < moveRow; j++) {
                        if(board[j][column].equals("P ") || board[j][column].equals("Q ")){
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }
}