import java.util.Base64;
import java.util.Scanner;

public class Solution {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++) {
            sc.nextLine();
            String word = sc.nextLine();
            String s = sc.nextLine();

            int cnt = 0;
            while (s.contains(word)){
                s = s.replaceFirst(word, "");
                cnt++;
            }

            System.out.printf("#%d %d\n", test_case, cnt);
        }
    }
}