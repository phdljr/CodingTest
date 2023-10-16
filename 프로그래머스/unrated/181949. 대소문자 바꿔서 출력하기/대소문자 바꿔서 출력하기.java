import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        for(char ch: a.toCharArray()){
            if('a' <= ch && ch <= 'z'){
                ch -= 32;
            } else{
                ch += 32;
            }
            answer += ch;
        }
        System.out.print(answer);
    }
}