package codeChef;

public class TicTacToe {
    public static int isWinning(String[] grid) {
        int xCount = 0;
        int oCount = 0;
        int spaceCount = 0;
        for(int i = 0; i < grid.length; i++) {
           for(int j = 0; j < grid.length; j++) {
               if(grid[i].charAt(j) == 'X')
                   xCount++;
               else if(grid[i].charAt(j) == 'O')
                   oCount++;
               else spaceCount++;
           }
        }

        System.out.println("SpaceCount: " + spaceCount);

        if (xCount == 3 && oCount == 3)
            return 3;

        if(spaceCount == 0) {
            if(xCount == 5 && oCount == 4)
                return 1;
            else
                return 3;
        } else if(spaceCount >= 1) {
            if(spaceCount % 2 == 0) {
                if (xCount != oCount + 1)
                    return 3;
            } else if(xCount != oCount)
                return 3;
            else if(spaceCount == 2)
                return 1;
            return 2;
        }

        return 2;
    }

}
