public class NearHundred {
    public static void main(String[] args) {
        // Test cases
        System.out.println(nearHundred(10));
        System.out.println(nearHundred(100));
        System.out.println(nearHundred(150));
        System.out.println(nearHundred(180));
    }

    public static boolean nearHundred(int n) {
        return (Math.abs(100 - n) <= 10) || (Math.abs(200 - n) <= 10);
    }
}