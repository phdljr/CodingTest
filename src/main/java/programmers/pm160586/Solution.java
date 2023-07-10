package programmers.pm160586;

public class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for(int i=0;i<targets.length;i++){
            for(int j=0;j<targets[i].length();j++){
                // 타겟 단어 하나씩 검사
                String alpha = targets[i].substring(j,j+1);
                int count = 0;
                for(int k=0;k<keymap.length;k++){
                    if(keymap[k].indexOf(alpha) == -1){
                        count++;
                    }
                }
                if(count == keymap.length){
                    answer[i] = -1;
                    break;
                }
            }

            for(int j=0;j<targets[i].length();j++){
                String alpha = targets[i].substring(j, j+1);

                int index = 10000;
                for(int k=0;k<keymap.length;k++){
                    if(keymap[k].indexOf(alpha) == -1){
                        continue;
                    }

                    if(keymap[k].indexOf(alpha) + 1 < index){
                        index = keymap[k].indexOf(alpha) + 1;
                    }
                }
                if(answer[i] == -1)
                    continue;
                answer[i] += index;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] a1 = {"ABACD", "BCEFD"};
        String[] a2 = {"ABCD","AABB"};
        new Solution().solution(a1,a2);
    }
}