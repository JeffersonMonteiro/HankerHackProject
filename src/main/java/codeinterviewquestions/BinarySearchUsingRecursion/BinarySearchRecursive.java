package codeinterviewquestions.BinarySearchUsingRecursion;

public class BinarySearchRecursive {

    public static void main(String[] args) {
        //********* Note: The program assumes that the array is sorted in ascending order.
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int target = 23;

        int result = binarySearch(arr, target);
        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index " + result);
        }
    }

    // Binary search using recursion
    public static int binarySearch(int[] arr, int target) {
        return binarySearchRecursive(arr, target, 0, arr.length - 1);
    }

    private static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // Element not found
        }

        int mid = (low + high) / 2;

        if (arr[mid] == target) {
            return mid; // Element found at mid index
        } else if (arr[mid] > target) {
            // Search in the left half
            return binarySearchRecursive(arr, target, low, mid - 1);
        } else {
            // Search in the right half
            return binarySearchRecursive(arr, target, mid + 1, high);
        }
    }
}
