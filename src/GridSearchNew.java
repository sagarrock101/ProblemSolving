public class GridSearchNew {

    int l = 0;
    int m = 0;
    int markedJ = -1;

    public String gridSearch(String[] g, String[] p) {
        for (int i = 0; i <= g.length - p.length ; i++) {
            for (int j = 0; j <= g[0].length() - p[0].length(); j++) {
                boolean found = true;
                for (int x = 0; x < p.length; x++) {
                    for (int y = 0; y < p[0].length(); y++) {
                        if (g[i + x].charAt(j + y) != p[x].charAt(y)) {
                            found = false;
                            break;
                        }
                    }
                }
                if(found) return "YES";
            }
        }
        return "NO";
    }

    public boolean checkForSameJ(int j) {
        if (markedJ == -1 && j != -1) {
            markedJ = j;
        }
        return j == markedJ;
    }
}
