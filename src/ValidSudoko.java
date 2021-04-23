import java.util.HashMap;
import java.util.HashSet;

public class ValidSudoko {
    public boolean isValidSudoku(char[][] board) {
//        {'8', '3', '.', '.', '7', '7', '.', '.', '.'},
//        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
//        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
//        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
//        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
//        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
//        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
//        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
//        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}));
        HashSet<String> seen = new HashSet<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3)) {
                        System.out.println(seen);
                        return false;
                    }
                }
            }
            System.out.println(seen);
        }

        return true;
    }
}
