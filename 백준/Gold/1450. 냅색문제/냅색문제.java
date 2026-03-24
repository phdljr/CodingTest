
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int c = Integer.parseInt(str[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();

        dfs(0, n/2, 0, left, arr); // 왼쪽 리스트에서의 부분합 집합
        dfs(n/2, n, 0, right, arr); // 오른족 리스트에서의 부분합 집합

        Collections.sort(right);

        long result = 0;
        for(long li: left){
            if(li > c)
                continue;

            long remain = c - li;

            long count = upperBound(right, remain);
            result += count; // 왼쪽 리스트의 특정 원소에 대해 오른쪽 리스트의 집합 원소 개수
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int upperBound(List<Long> rightList, long remain) {
        int left = 0;
        int right = rightList.size();

        while(left < right){
            int mid =  left + (right - left)/2;

            if(rightList.get(mid) <= remain){
                left = mid + 1;
            } else{
                right = mid;
            }
        }

        return left;
    }

    static void dfs(int start, int end, long sum, List<Long> list, int[] arr) {
        if (start == end) {
            list.add(sum);
            return;
        }

        dfs(start + 1, end, sum, list, arr);
        dfs(start + 1, end, sum + arr[start], list, arr);
    }
}


