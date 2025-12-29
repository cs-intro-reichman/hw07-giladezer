/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        int x = 5;
        System.out.println("Binary representation of " + x + " is: " + toBinary(x));
    }

    private static String toBinaryPositive(int x) {
        if (x == 0) {
            return "";
        }
        return toBinaryPositive(x / 2) + (x % 2);
    }

    private static String toBinaryNegative(int x) {
        if (x == 0) {
            return "";
        }
        return toBinaryNegative(x >>> 1) + (x & 1);
    }


    /** Returns the binary representation of the given integer, as a string of 0's and 1's. 5 = 101 */
    public static String toBinary(int x) {

        // Case 1: zero
        if (x == 0) {
            return "0";
        }

        // Case 2: positive number
        if (x > 0) {
            return toBinaryPositive(x);
        }

        // Case 3: negative number (two’s complement)
        return toBinaryNegative(x);
    }
  
 }
