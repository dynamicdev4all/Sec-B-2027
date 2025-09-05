package Functions;

public class StarRow {
    static void printStar(int i) {
        if (i >= 5066) {
            return;
        }
        System.out.print("*");
        printStar(i + 1);
    }

    static void printStar2(int starCount) {
        if (starCount <= 0) {
            return;
        }
        System.out.print("*");
        printStar2(starCount - 1);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.print("*");
        }
        System.out.println();
        printStar(0);
        System.out.println();
        printStar2(50);
    }
}
