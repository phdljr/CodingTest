package programmers.pm12981;

import java.util.ArrayList;

public class Solution {
    // n: 사람 수
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2]; // 사람, 몇 번째 단어

        ArrayList usedWords = new ArrayList();
        for(int i=0;i< words.length;i++){
            String word = words[i];
            if(usedWords.contains(word)){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }

            usedWords.add(word);

            // 앞 뒤 체크
            if(i == 0)
                continue;

            String prev = words[i-1];
            char c1 = prev.charAt(prev.length()-1);
            char c2 = word.charAt(0);
            if(c1 != c2){
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            }
        }

        return answer;
    }
}
