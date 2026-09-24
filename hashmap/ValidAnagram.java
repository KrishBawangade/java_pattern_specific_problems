package hashmap;

import java.util.*;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> freq = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0)-1);
        }

        for(Map.Entry<Character, Integer> entry: freq.entrySet()){
            if(entry.getValue()!=0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s,t));
    }
}
