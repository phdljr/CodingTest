class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        boolean flag = false;
        for(int i=0;i<A.length();i++){
            if(A.equals(B)){
                flag = true;
                break;
            }
            A = A.substring(A.length()-1, A.length()) + A.substring(0, A.length()-1);
            answer++;
        }
        return flag ? answer : -1;
    }
}