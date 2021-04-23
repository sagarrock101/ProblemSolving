package codeChef;

import java.util.ArrayList;

public class ChefAndGroups {
    public static int chefAndGroups(String sitting) {
        int groups = 0, cont = 0;
        boolean contOne = false;
        for(int i = 0; i < sitting.length(); i++) {
            if (sitting.charAt(i) == '1') {
                if(contOne) {
                    cont++;
                } else {
                    contOne = true;
                    cont+=1;
                }
            }else {
                contOne = false;
                if(cont > 0) {
                    groups += 1;
                    cont = 0;
                }
            }
        }
        if (cont > 0)
            groups+=1;

        return groups;
    }
}
