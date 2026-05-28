public class Methods {
    public static void main(String[] args) {
        // Problem 5 — Methods
        // Method 1 — isEven
        System.out.println(isEven(5));
        //Method 2 — maxOfThree
        System.out.println(maxOfThree(6, 8, 3));
        //Method 3 — repeatString
        System.out.println(repeatString("ha", 3));
        //Method 4 — isPalindrome
        System.out.println(isPalindrome("racecar"));
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int maxOfThree(int num1, int num2, int num3) {
        if(num1 > num2 && num1 > num3) return num1;
        else if(num2 > num3) return num2;
        else return num3;
    }

    public static String repeatString(String str, int n) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < n; i++) result.append(str);
        return result.toString();
    }

    public static boolean isPalindrome(String str) {
        if(str.length() == 0) return true;
        if(str.length() == 1) return true;
        for(int i = 0; i < str.length()/2; i++) {
            if(str.charAt(i) != str.charAt((str.length()-i-1))) return false;
        }
        return true;
    }
}
