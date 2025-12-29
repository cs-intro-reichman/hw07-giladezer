/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = 5;
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

    /** Returns the binary representation of the given integer, as a string of 0's and 1's. 5 = 101 */
    public static String toBinary(int x) {
        if (x < 0) {
            return "-" + toBinary(-x);
        }
        if (x < 2) {
            return "" + x;
        }
        return toBinary(x / 2) + (x % 2);
    }
  
 }
