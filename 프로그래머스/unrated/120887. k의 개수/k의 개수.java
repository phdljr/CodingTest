class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(;i<=j;i++){
            for(String str: String.valueOf(i).split("")){
                if(str.equals(""+k)){
                    answer++;
                }
            }
        }
        return answer;
    }
}