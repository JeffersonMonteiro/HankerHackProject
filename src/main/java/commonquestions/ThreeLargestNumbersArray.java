package commonquestions;

public class ThreeLargestNumbersArray {

    public static void findLargestNumbersInAnArray(int[] array) {

        if (array.length < 3) {
            System.out.println("Invalid input, Array size is less than 3");
        }

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            if (current > first) {
                third = second;
                second = first;
                first = current;
            } else if (current > second) {
                third = second;
                second = current;
            } else if (current > third) {
                third = current;
            }
        }
        System.out.println("Three largest elements are: " + first + " - " + second + " - " + third);
    }

    public static void main(String[] args) {
        int[] list = {19, 5, 78, 1, 33, 11, 20};
        findLargestNumbersInAnArray(list);
    }
}
