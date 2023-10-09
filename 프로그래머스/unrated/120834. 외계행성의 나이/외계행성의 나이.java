class Solution {
    public String solution(int age) {
        String answer = "";
        for(String str: String.valueOf(age).split("")){
            answer += (char)('a' + str.charAt(0) - '0');
        }
        return answer;
    }
}