package codeinterviewquestionsjava8.ReturnsSmallestPositiveIntegerGreaterThan0ThatDoesNotOccurInA;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int solution(int[] A) {

        int N = A.length;
        int valueReturned = 0;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            if (a > 0) {
                set.add(a);
            }
        }
        for (int i = 1; i <= N + 1; i++) {
            if (!set.contains(i)) {
                valueReturned = i;
                break;
            }
        }

        return valueReturned;
    }

}
