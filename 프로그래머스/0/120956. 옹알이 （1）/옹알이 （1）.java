class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] filterStr = {"aya", "ye", "woo", "ma"};
        for(int i=0;i<babbling.length;i++){
            for(int j=0;j<filterStr.length;j++){
                babbling[i] = babbling[i].replaceAll(filterStr[j], "-");
            }
            babbling[i] = babbling[i].replaceAll("-", "");
            if(babbling[i].equals("")){
                answer++;
            }
        }
        return answer;
    }
}