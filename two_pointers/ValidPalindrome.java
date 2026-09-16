package two_pointers;

public class ValidPalindrome{

    public static boolean isPalindrome(String s) {
        String normalized = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();;

        int i=0;
        int j = normalized.length()-1;

        while(i<j){
            if(normalized.charAt(i) != normalized.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args){
        String s = "race car";

        System.out.println(isPalindrome(s));
    }
}