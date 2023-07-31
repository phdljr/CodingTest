package programmers.level2.pm132265;

public class Solution {
    public int solution(int[] topping) {
        int[] left = new int[10001];
        int[] right = new int[10001];
        int r = 0; // 오른쪽의 토핑 개수
        // 오른쪽의 토핑 개수를 먼저 세림
        for (int x : topping) {
            if (right[x] == 0) {
                r++;
            }
            right[x]++;
        }
        int ans = 0;
        int l = 0; // 왼쪽의 토핑 개수
        // 왼쪽의 토핑을 하나씩 추가하며 오른족과 개수 비교
        // 오른쪽의 토핑이 1에서 0이 되면 개수도 하나 감소
        for (int x : topping) {
            if (right[x] == 1) {
                r--;
            }

            if (left[x] == 0) {
                l++;
            }
            right[x]--;
            left[x]++;

            if (l == r) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2});
    }
}
