import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestAnangram {

    public static void main(String[] args) {
        String test = "Code? aaagmnrs, doce and anagrams";

        getAnagrams(test);
    }


    public static void getAnagrams(String text) {
        String[] words = text.split(" ");
        Map<Map<Integer, Long>, List<String>> characters = new HashMap<>();

        for (String word : words) {
            //here I'm using a stream, but you can build the occurences map manually
            Map<Integer, Long> occurences = word.replaceAll("\\s+", "") //remove spaces
                    .chars().boxed()
                    .collect(Collectors.groupingBy(i -> i, Collectors.counting()));

            if (characters.containsKey(occurences)) { //anagram found !
                characters.get(occurences).add(word); //add the word to the list

            } else { //no anagram found, create the list, with only one item
                List<String> list = new ArrayList<>();
                list.add(word);
                characters.put(occurences, list);
            }
        }

        //you may want to sort the lists here
        characters.values().forEach(System.out::println);
        //return list;
    }
}

