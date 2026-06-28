class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int com = 0;
        boolean plus = true;
        if(common[1] - common[0] == common[2] - common[1]){
            com = common[1] - common[0];
        } else{
            com = common[1]/common[0];
            plus = false;
        }
        
        return plus ? common[common.length-1] + com : common[common.length-1] * com;
    }
}