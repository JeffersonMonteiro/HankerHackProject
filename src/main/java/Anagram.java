import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Anagram {

    public static void main(String[] args) {
        String test = "Code aaagmnrs, doce and anagrams";

        new Anagram().solveChallenge(test);
    }


    private boolean isAnagram(String s1, String s2) {
        char[] aChars = s1.replaceAll("\\s", "").toCharArray();
        char[] bChars = s2.replaceAll("\\s", "").toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);
        String one = String.valueOf(aChars).replaceAll("[^a-zA-Z0-9]", " ");
        String two = String.valueOf(bChars).replaceAll("[^a-zA-Z0-9]", " ");
        return one.toLowerCase().equalsIgnoreCase(two.toLowerCase());
    }
    private void solveChallenge(String input) {
        List<String> words = Arrays.asList(input.split(" "));

        for(int i=0 ;i<(words.size()-1); i++) {
            Set<String> result = new TreeSet<>();
            int j = i+1;
            int size = words.size();
            while(j < size) {
                if (isAnagram(words.get(i), words.get(j))){
                    result.add(words.get(i) + " " + words.get(j));
                    System.out.println(result);
                    size--;
                } else {
                    j++;
                }
            }
        }
    }
}
