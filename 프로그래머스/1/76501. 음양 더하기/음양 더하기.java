class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int res = 0;
        for(int i=0;i<absolutes.length;i++){
            res += signs[i] == true ? absolutes[i] : -absolutes[i];
        }
        return res;
    }
}