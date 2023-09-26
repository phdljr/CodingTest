class Solution {
    public String solution(String my_string, int num1, int num2) {
        char[] carr = my_string.toCharArray();
        char temp = carr[num2];
        carr[num2] = carr[num1];
        carr[num1] = temp;
        
        return new String(carr);
    }
}