package programmers.level1.pm134240;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 3, 1, 1, 1, 1, 1};
        for (int i : Arrays.stream(arr).distinct().sorted().toArray()) {
            System.out.println(i);
        }

    }
}
