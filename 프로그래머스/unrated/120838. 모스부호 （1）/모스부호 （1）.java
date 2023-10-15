class Solution {
    public String solution(String letter) {
        String answer = "";
        String[] arr = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        for(String str: letter.split(" ")){
            for(int i=0;i<arr.length;i++){
                if(str.equals(arr[i])){
                    answer += (char)('a' + i);
                }
            }
        }
        return answer;
    }
}