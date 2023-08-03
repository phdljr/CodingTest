package thisisct.chap11.pm4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        List<Integer> list = new ArrayList<>();
        String[] str = in.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(str[i]));
        }

        list.sort(Integer::compareTo);

        int target = 1; // 1부터 target까지 모든 금액을 만들 수 있는 상태
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            if (target < num) {
                break;
            } else {
                target += num; // 만약, target이 5이고 num이 4라면 9까진 만들 수 있다는 상태로 업데이트  
            }
        }

        System.out.println(target);
    }
}
