import java.util.Arrays;

public class GridSearch {
    public String gridSearch(String[] g, String[] p) {
        int[][] numGrid = new int[g.length][g[0].length()];
        int[][] numPattern = new int[p.length][p[0].length()];
        boolean flag = false;

        for (int gi = 0; gi < g.length; gi++) {
            for (int gj = 0; gj < g[gi].length(); gj++) {
                numGrid[gi][gj] = g[gi].charAt(gj) - 48;
            }
        }

        for (int pi = 0; pi < p.length; pi++) {
            for (int pj = 0; pj < p[pi].length(); pj++) {
                numPattern[pi][pj] = p[pi].charAt(pj) - 48;
            }
        }

        for (int i = 0; i <g.length - p.length + 1 ; i++) {
            for (int j = 0; j < g[0].length() - p[0].length() ; j++) {
                flag = false;
                for(int k = 0 ; k < p.length; k++ ) {
                    for(int l = 0 ; l < p[k].length(); l++) {
                        if(numGrid[i + k][j + l] != numPattern[k][l]) {
                        flag = true;
                        break;
                        }
                    }
                    if(flag) break;
                }
                if(!flag) return "YES";
            }
        }
        return "NO";
    }
}
