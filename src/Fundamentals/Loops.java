public class Loops {
    public static void main(String[] args) {
        // Problem 4 — Loops
        for (int i = 2; i <= 20; i = i + 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        int n = 1;
        while (n <= 500) {
            System.out.print(n + " ");
            n *= 2;
        }
        System.out.print(n + " ");
        System.out.println();

        for(int i = 1; i <= 15; i++) {
            if(i % 3 == 0) continue;
            if(i > 11) break;
            System.out.print(i + " ");
        }
    }
}
