package beakjoon.pm1759;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        int l = Integer.parseInt(str[0]); // 답의 길이
        int c = Integer.parseInt(str[1]); // 주어진 알파뱃 개수
        char[] cArr = sc.nextLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(cArr);

        go(l, cArr, "", 0);
    }

    private static void go(int l, char[] cArr, String password, int i){
        if(password.length() == l){ // 끝까지 잘 채운 경우
            if(check(password))
                System.out.println(password);
            return;
        }

        if(i >= cArr.length) return; // 불가능한 경우

        go(l, cArr, password+cArr[i], i+1); // 문자를 사용한 경우
        go(l, cArr, password, i+1); // 문자를 사용하지 않은 경우
    }

    private static boolean check(String password) {
        boolean vowel = false;
        int consonant = 0;
        for(char c: password.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vowel = true;
            else
                consonant++;
        }
        return vowel == true && consonant >= 2;
    }


}
