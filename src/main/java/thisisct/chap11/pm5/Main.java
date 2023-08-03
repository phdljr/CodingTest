package thisisct.chap11.pm5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] s = in.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[] arr = new int[11];
        s = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[Integer.parseInt(s[i])]++;
        }

        int answer = 0;
        for (int i = 1; i <= m; i++) {
            n -= arr[i]; // 무게가 i인 볼링공 개수 제외 -> A가 i 무게의 볼링공을 택했을 때
            answer += n * arr[i]; // B가 i 무게의 볼링공을 제외한 택할 수 있는 개수를 곱
        }

        System.out.println(answer);
    }
}
