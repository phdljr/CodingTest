package programmers.level1.pm160586;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for(int i=0;i<targets.length;i++){ //target 전체 반복
            for(int j=0;j<targets[i].length();j++){ // target 한 단어의 길이만큼
                String t = targets[i].substring(j, j+1); // targets[i] 의 j번째 문자

                int index = keymap[0].indexOf(t);
                for(int k=1;k<keymap.length;k++){
                    if(index > keymap[k].indexOf(t)){
                        index = keymap[k].indexOf(t);
                    }
                }

                answer[i] += index;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] a = {"AGZ", "BSSS"};
        String[] b = {"ASA", "BGZ"};
        System.out.println(new Solution().solution(a,b));
    }
}