public class ArmStrongNumber {
    public static void main(String[] args) {
        int num = 153;
        int numCopy = num;
        int numCopy2 = num;
        int len = 0;
        int armStrongSum = 0;
        // this code is to find the len of the number

        while (num != 0) {
            num = num / 10;
            len++;
        }

        while (numCopy != 0) {
            int base = numCopy % 10;
            int exp = len;
            int result = 1;
            for (int i = 1; i <= exp; i++) {
                result = result * base;
            }
            numCopy = numCopy / 10;
            armStrongSum = armStrongSum + result;
        }

        if (armStrongSum == numCopy2) {
            System.out.println("The number is ArmStrong");
        } else {
            System.out.println("The number is not Armstrong");
        }

    }
}
