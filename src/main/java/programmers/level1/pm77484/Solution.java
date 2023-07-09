package programmers.level1.pm77484;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int li = 0, wi = 0;
        int match = 0;
        int zeroCount = 0;

        Arrays.sort(lottos);
        Arrays.sort(win_nums);

        for (int i = 0; i < lottos.length; i++) {
            if (lottos[li] == 0) {
                zeroCount++;
                li++;
            } else {
                break;
            }
        }

        while (li < lottos.length && wi < win_nums.length) {
            if (lottos[li] == win_nums[wi]) {
                match++;
                li++;
                wi++;
            } else if (lottos[li] > win_nums[wi]) {
                wi++;
            } else {
                li++;
            }
        }

        int rank = 7 - match < 7 ? 7 - match : 6;
        answer[0] = rank - zeroCount > 0 ? rank - zeroCount : 1;
        answer[1] = rank;

        return answer;
    }
}
