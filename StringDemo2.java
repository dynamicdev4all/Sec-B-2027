public class StringDemo2 {
    public static void main(String[] args) {
        String name = "Yash";
        for (int i = 0; i < 100000; i++) {
            name = name + "A";
        }
    }
}