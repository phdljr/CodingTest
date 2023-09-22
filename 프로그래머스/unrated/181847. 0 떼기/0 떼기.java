class Solution {
    public String solution(String n_str) {
        String answer = "";
        int i = 0;
        while(true){
            if(n_str.charAt(i) == '0'){
                i++;
                continue;
            } else{
                break;
            }
        }
        return n_str.substring(i);
    }
}