public class runner{
    public static void main(String[] args) {
        String c = "bobcat";
        String d = c;
        c = null;
        System.out.println(d);
    }
}