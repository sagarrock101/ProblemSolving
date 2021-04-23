public class NonRepeatingUniqueNumber {
    public static int nonRepeatingUniqueNumber(int[] arr) {
        //[1,2,3,1,3]
        /*
         *
         * 8 4 2 1
         *
         * */
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans ^= arr[i];
            System.out.println(ans);
        }

        return ans;

    }
}
