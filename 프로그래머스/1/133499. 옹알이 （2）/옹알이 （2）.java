class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] sarr = {"aya", "ye", "woo", "ma"};
        
        for (int i=0;i<babbling.length;i++) {
            if(babbling[i].contains("ayaaya") || babbling[i].contains("yeye") || babbling[i].contains("woowoo") || babbling[i].contains("mama")) {
                continue;
            }

            for(int j=0;j<sarr.length;j++){
                babbling[i] = babbling[i].replace(sarr[j], " ");
            }
            babbling[i] = babbling[i].replace(" ", "");
            if(babbling[i].length() == 0){
                answer++;
            }
        }
        return answer;
    }
}