public class Speed {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        long startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            sb.append("A");
        }
        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);

    }
}
