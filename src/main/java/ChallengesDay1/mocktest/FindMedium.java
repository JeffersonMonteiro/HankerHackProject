package ChallengesDay1.mocktest;

import ChallengesDay1.exercise3.TimeChallenge;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindMedium {

    public static void main(String[] args) {
        TimeChallenge t = new TimeChallenge();
        Integer[] list = new Integer[]{5, 4, 6, 2, 1, 8, 11};
        System.out.println(findMedium(Arrays.asList(list)));
    }

    public static int findMedium(List<Integer> list) {
        Collections.sort(list);

        int size = list.size();
        int result = 0;

        if(size % 2 == 0){
            result = list.get(size/2-1);
        }else{
            result = list.get(size/2);
        }

        return result;

    }
}
