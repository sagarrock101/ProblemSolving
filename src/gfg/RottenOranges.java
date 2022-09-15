package gfg;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    //Function to find minimum time required to rot all oranges.
    public static int orangesRotting(int[][] grid) {
        // Code here
        Queue<int []> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        int countFresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
               if (grid[i][j] == 1) {
                   countFresh++;
               }
               if (grid[i][j] == 2) {
                   queue.add(new int[]{i, j});
               }
            }
        }

        int[] dx = new int[]{0, 0, -1, 1};
        int [] dy = new int[]{-1, 1, 0, 0};
        int count = 0;
        int countMin = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count += size;
            int[] point = queue.poll();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < 4; j++) {
                    int x = point[0] + dx[j];
                    int y = point[1] + dy[j];

                    if ( x < 0 || y < 0 || x>= rows || y >= cols || grid[x][y] == 0 || grid[x][y] == 2)  continue;
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }
            if (queue.size() != 0) {
                countMin++;
            }
        }

        return countFresh == count ? countMin : -1;
    }

}
