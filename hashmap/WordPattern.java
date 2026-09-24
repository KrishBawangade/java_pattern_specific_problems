package hashmap;

import java.util.*;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");

        HashMap<Character, String> patternMap = new HashMap<>();
        HashMap<String, Character> wordMap = new HashMap<>();

        if(pattern.length() != words.length){
            return false;
        }

        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = words[i];

            if(patternMap.containsKey(ch)){
                if(!patternMap.get(ch).equals(word)){
                    return false;
                }
            }else{
                patternMap.put(ch, word);
            }

            if(wordMap.containsKey(word)){
                if(wordMap.get(word) != ch){
                    return false;
                }
            }else{
                wordMap.put(word, ch);
            }
        }

        return true;
    }

    public static void main(String[] args){
        String pattern = "abba";
        String s = "dog cat cat dog";

        System.out.println(wordPattern(pattern, s));
    }
}
