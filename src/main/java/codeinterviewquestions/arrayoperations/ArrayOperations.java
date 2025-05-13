package codeinterviewquestions.arrayoperations;

public class ArrayOperations {

    public static void reverseArray(int[] array) {

        int left = 0; // Initialize left pointer

        int right = array.length - 1; // Initialize right pointer

        // Swap elements until left pointer is less than right pointer

        while (left < right) {

            // Swap the elements at left and right pointers

            int temp = array[left];

            array[left] = array[right];

            array[right] = temp;

            // Move the pointers towards the center

            left++;

            right--;

        }

    }

//    Q153. Write a program to find the index of first occurrence
//    and last occurrence of an element in the array in a single iteration.
    public static int[] findFirstAndLastOccurrence(int[] arr, int target) {
        int firstIndex = -1;
        int lastIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                if (firstIndex == -1) {
                    firstIndex = i;
                }
                lastIndex = i;
            }
        }
        return new int[]{firstIndex, lastIndex};
    }

    //Binary Search
//    Q162. You are given a sorted array of integers. It is given that each element in the array is unique.
//    You have to find the index where the element is located in the array. If it is not located in the array,
//    you have to return the index at which it should be inserted in the array
//    so that the array remains sorted. You can’t use extra space and the expected time complexity is O(log2N)
//    where N is the number of elements in the array.
    public static int searchInsertPosition(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        int[] array = {1, 2, 3, 4, 5};

        // Print original array

        System.out.println("Original Array: ");

        for (int i : array) {

            System.out.print(i + " ");

        }

        System.out.println();

        // Reverse the array

        reverseArray(array);

        // Print reversed array

        System.out.println("Reversed Array: ");

        for (int i : array) {

            System.out.print(i + " ");

        }

        int target = 3;
        int[] arr = {1, 2, 3, 4, 3, 5, 3, 6};
        int[] indices = findFirstAndLastOccurrence(arr, target);
        int firstIndex = indices[0];
        int lastIndex = indices[1];

        System.out.println("First occurrence of " + target + " is at index: " + firstIndex);
        System.out.println("Last occurrence of " + target + " is at index: " + lastIndex);


        int[] nums = {1, 3, 5, 6};

        int target2 = 5;
        System.out.println(searchInsertPosition(nums, target2)); // Output: 2

        target2 = 2;
        System.out.println(searchInsertPosition(nums, target2)); // Output: 1

        target2 = 7;
        System.out.println(searchInsertPosition(nums, target2)); // Output: 4

        target2 = 0;
        System.out.println(searchInsertPosition(nums, target2)); // Output: 0


    }
}
