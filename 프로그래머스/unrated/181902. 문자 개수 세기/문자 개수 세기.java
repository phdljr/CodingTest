class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        for(char ch: my_string.toCharArray()){
            if('A' <= ch && ch <= 'Z')
                answer[(int)(ch - 'A')]++;
            else
                answer[(int)(ch - 'a') + 26]++;
        }
        return answer;
    }
}