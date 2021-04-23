public class ReverseInt {
    /*
   123
   q = 12
   temp = 3
   rev = 3 * 10
   rev = rev * 10 + temp
   rev = 0 * 10 + 3
   rev = 3

   q= 1
   temp = 2





     */
    public int reverse(int x) {
        int rev = 0;
        int temp = 0;
        while (x != 0) {
            temp = rev * 10 + x % 10;
            System.out.println(temp);
            if( temp / 10 != rev) {
                System.out.println("After over flow temp/10 value: " + temp/10 + " rev value: " + rev);
                return 0;
            }
            rev = temp;
            x/=10;
        }
        return rev;
    }
}
