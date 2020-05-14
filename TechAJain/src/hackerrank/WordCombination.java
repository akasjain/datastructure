package hackerrank;

import java.util.*;

public class WordCombination {
    /*
    You are given a (potentially large) List of words. Some of these are compounds, where all parts are also in the List.

    Example List: [rockstar, rock, star, rocks, tar, star, rockstars, super, highway, high, way, superhighway]

    The task is to identify all combinations where one word is a composite of two or more words from the same list and print or return them.

    Example: rockstar -> rock + star superhighway -> super + highway superhighway -> super + high + way

    If returning, the output would be a list of lists, e.g.

    [[rock, star], [super, highway], [super, high, way],...]

    */

    public static List<List<String>> findCombinations(String[] words) {

        int len = words.length;
        Map<String, Boolean> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String word: words) {
            map.put(word, false);
        } // O(n)

        for(int i=0; i<len; i++) {  //O(n2)
            String word = words[i];
            for(Map.Entry<String, Boolean> entry : map.entrySet()) {
                if(entry.getKey().contains(word) && !entry.getKey().equals(word)) {
                    map.put(word, true);
                    int index = entry.getKey().indexOf(word);

                    String remainingWord = index == 0 ?
                            entry.getKey().substring(word.length()) : entry.getKey().substring(0, index);
                    if(map.containsKey(remainingWord) && map.get(remainingWord)) {        // found a combination
                        result.add(Arrays.asList(word, remainingWord));
                    }
                }
            }

        }

        return result;
    }

    public static List<List<String>> getCompoundWords(List<String> inputList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> hashSet = new HashSet<>();
        for(int i = 0; i < inputList.size(); i++) {
            hashSet.add(inputList.get(i));
        }

        for(int i = 0; i < inputList.size(); i++) {
            String word = inputList.get(i);

            for(int j = 0; j < word.length(); j++) {
                String subStringFirst = word.substring(0, j+1);
                String subStringLast = word.substring(j+1);

                List<String> internal = new ArrayList<>();
                if(hashSet.contains(subStringFirst) && hashSet.contains(subStringLast)) {
                    internal.add(subStringFirst);
                    internal.add(subStringLast);
                    result.add(internal);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = {"rockstar", "rock", "star", "rocks", "tar", "star", "rockstars", "super", "highway", "high", "way", "superhighway"};
        List<List<String>> result = WordCombination.findCombinations(words);
        System.out.println(result);

        result = WordCombination.getCompoundWords(Arrays.asList(words));
        System.out.println(result);
    }
}
