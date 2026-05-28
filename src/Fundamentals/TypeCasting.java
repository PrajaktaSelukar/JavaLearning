public class TypeCasting {
    public static void main(String[] args) {
        // Problem 2 — Type Casting
        double price = 99.99;
        int quantity = 3;
        double total = price * quantity;
        int roundedTotal = (int)total;

        System.out.println("Exact total: " + total);
        System.out.println("Rounded down total: " + roundedTotal);

        // byte b = 130; why getting error because byte overflows after 127 range is from -126 to 127
        int b = 130;
    }
}
