package programmers.level1.pm1845;

import java.time.LocalDate;
import java.util.*;

public class Solution {
    public int solution(int[] nums) {
        int select = nums.length / 2;

        HashSet<Integer> set = new HashSet<>();
        for(int n: nums){
            set.add(n);
        }

        return Math.min(set.size(), select);
    }
}
