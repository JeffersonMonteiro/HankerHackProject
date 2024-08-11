package codeinterviewquestionsjava8.findEntriesWithMaximalOccurrences;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

//https://www.baeldung.com/java-string-find-most-frequent-characters

public class findTheEntriesWithMaximalOccurrences {

    public static void main(String[] args) {
        byMap("aaavvvvvzzzzzzzzzzzzzzzzzzzzbb");
    }

    static void byMap(String input) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : input.toCharArray()) {
            map.compute(c, (character, count) -> count == null ? 1 : ++count);
        }

        int maxCount = map.values()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();

        Set<Character> returnedCharacter = map.keySet()
                .stream()
                .filter(c -> map.get(c) == maxCount)
                .collect(toSet());

        if(maxCount %2 == 0){
            System.out.println("The character is "+ returnedCharacter+ " appeared "+ maxCount +" times is even");
        }else{
            System.out.println("The character is "+ returnedCharacter+ " appeared "+ maxCount + " times is odd");
        }


    }

}
