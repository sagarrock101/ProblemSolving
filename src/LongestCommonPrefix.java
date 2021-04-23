public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String lCpTemp = "";
        String temp = "";
        String lCp = "";

        /*"flower",
           "flow",
           "flight"
         flower, flow
        lcp = flow
        flow, flight


        */
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        for (int i = 0; i < strs.length - 1; i++) {
            String str1 = strs[i];
            String str2 = strs[i + 1];
            int l = 0;
            int j = 0;
            int k = 0;
            int m = 0;
            if (!lCp.isEmpty()) {
                while (k < lCp.length() && m < str2.length()) {
                    if (lCp.charAt(k) == str2.charAt(m)) {
                        lCpTemp += lCp.charAt(k);
                        k++;
                        m++;
                    } else {
                        if (lCpTemp.isEmpty())
                            return "";
                        else break;
                    }
                    ;
                }
                lCp = lCpTemp;
                lCpTemp = "";
            } else {
                while (l < str1.length() && j < str2.length()) {
                    if (str1.charAt(l) == str2.charAt(j)) {
                        lCp += str1.charAt(l);
                        l++;
                        j++;
                    } else {
                        break;
//                        if (!lCp.isEmpty()) {
//                            if (str1.length() >= str2.length()) {
//                                l++;
//                                if (l == str1.length())
//                                    break;
//                            } else {
//                                if (l != str1.length() - 1)
//                                    j++;
//                                else
//                                    break;
//                            }
//                        } else {
//                            return "";
//                        }
                    }
                }
                if (lCp.isEmpty())
                    return "";
            }
        }

        return lCp;
    }
}
