

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        
        if(sb.length() == 1){
            if(isSmallAlphabet(sb.charAt(0))){
                sb.setCharAt(0, (char) (sb.charAt(0) - 32));
                return sb.toString();
            }
        }
        
        for(int i=0;i<sb.length()-1;i++){
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(i + 1);
            if (i == 0 && isSmallAlphabet(c1)) {
                sb.setCharAt(0, (char) (c1 - 32));
                continue;
            }
            if (c1 == ' ' && isSmallAlphabet(c2)) {
                sb.setCharAt(i + 1, (char) (c2 - 32));
            }
        }

        return sb.toString();
    }

    public static boolean isSmallAlphabet(char c){
        if(c >= 'a' && c <= 'z')
            return true;
        return false;
    }
}