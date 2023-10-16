class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String pre = "";
        for(String str: s.split(" ")){
            if(str.equals("Z")){
                answer -= Integer.parseInt(pre);
            } else{
                answer += Integer.parseInt(str);
            }
            pre = str;
        }
        return answer;
    }
}