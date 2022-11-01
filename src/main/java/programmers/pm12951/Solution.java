package programmers.pm12951;

class Solution {
    public static void main(String[] args) {
        String[] temp = "a  b".split(" ");
    }
    // A65  a97
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAnswer = new StringBuilder();
        String[] words = s.split(" ");

        for(String word: words){
            if(word.length() == 0){
                continue;
            }
            sb.append(word.toLowerCase()); // 소문자
            if(sb.length() > 0 && isSmallAlphabet(sb.charAt(0))){
                sb.replace(0, 1, String.valueOf((char)(sb.charAt(0) - 32)));
            }
            sbAnswer.append(sb.toString() + " ");
            sb.delete(0, sb.length());
        }
        return sbAnswer.toString().trim();
    }

    public static boolean isSmallAlphabet(char c){
        if(c >= 'a' && c <= 'z')
            return true;
        return false;
    }
}