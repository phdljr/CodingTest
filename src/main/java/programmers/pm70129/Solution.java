package programmers.pm70129;

public class Solution {
    public static void main(String[] args) {
        int[] a = new Solution().solution("000000000000111010");
        System.out.println(a[0]);
        System.out.println(a[1]);

    }
    public int[] solution(String s) {
        int[] answer = {0, 0};

        do {
            while(true) {
                if (s.contains("0")) {
                    s = s.replaceFirst("0", "");
                    answer[1]++;
                    continue;
                }
                break;
            }

            int len = s.length();
            if(len == 0)
                break;

            s = Integer.toString(len, 2); // 길이를 2진수로 표현
            answer[0]++;
        } while (!s.equals("1"));

        return answer;
    }
}
