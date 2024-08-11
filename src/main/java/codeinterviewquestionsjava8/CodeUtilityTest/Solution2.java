package codeinterviewquestionsjava8.CodeUtilityTest;

public class Solution2 {

    // Function to check if the graph
    // constructed from given array
    // contains a cycle or not
    static boolean isCycleExists(int[] A, int[] B) {

        boolean resultA = false;
        boolean resultB = false;

        // Traverse the array
        for (int i = 1; i < A.length -1; i++) {

            // If A[i] is less than
            // A[i - 1] and A[i]
            if (A[i] < A[i - 1] && A[i] < A[i + 1]) {
                resultA = true;
            }
        }

        // Traverse the array
        for (int i = 1; i < B.length -1; i++) {

            // If A[i] is less than
            // A[i - 1] and A[i]
            if (B[i] < B[i - 1] && B[i] < B[i + 1]) {
                resultB = true;
            }
        }

        return resultA && resultB;
    }

    // Driver Code
    public static void main(String[] args)
    {

        // Given array
        int[] A = { 3,1,2};
        int[] B = { 2,3,1};

        System.out.println(isCycleExists(A, B));
    }
}
