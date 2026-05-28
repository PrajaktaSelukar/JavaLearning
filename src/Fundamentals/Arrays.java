public class Arrays {
    public static void main(String[] args) {
        // Problem 6 — Arrays
        int [] arr = new int [5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;
        for(int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
        System.out.println();

        int[] nums = {43, 17, 89, 5, 62, 31, 74};
        int minimum = Integer.MAX_VALUE;
        int maximum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < minimum) minimum = nums[i];
            if(nums[i] > maximum) maximum = nums[i];
        }
        System.out.println(minimum + " " + maximum);

        int[] array = {1, 2, 3, 4, 5};
        reverse(array);
        for(int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
        System.out.println();

        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void reverse(int[] arr) {
        for(int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}
