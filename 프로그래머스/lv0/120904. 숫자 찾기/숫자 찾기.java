class Solution {
    public int solution(int num, int k) {
        if(("" + num).contains(""+k)){
            return ("" + num).indexOf(""+k) + 1;
        }
        return -1;
    }
}