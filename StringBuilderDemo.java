public class StringBuilderDemo {
    public static void main(String[] args) {
        // String name = "yash";
        // name = name + " Sharma";

        // StringBuilder sb = new StringBuilder();
        // System.out.println(sb.length() + "," + sb.capacity());
        // sb.append("YashYashYashYashYYashYashYashYashY1");
        // System.out.println(sb.length() + "," + sb.capacity());
        StringBuffer sb = new StringBuffer(20);
        System.out.println(sb.length() + "," + sb.capacity());
        sb.append("YashYashYashYashYash1");
        System.out.println(sb.length() + "," + sb.capacity());

    }
}
