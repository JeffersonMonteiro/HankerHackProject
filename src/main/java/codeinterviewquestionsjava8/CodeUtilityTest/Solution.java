package codeinterviewquestionsjava8.CodeUtilityTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    char[] LowerCaseAlphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public String solution(int N) {

        int count =0;
        StringBuilder resultString = new StringBuilder();

            for (int j=0;  j< N+1; j++){
                while(count < 3  && resultString.length() < N){
                    resultString.append(LowerCaseAlphabet[j]);
                    count++;
                }
                count=0;
            }
        return resultString.toString();
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.solution(4));
    }


}
