
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        for(int i=0;i<n;i++){
            count = 0;
            char[] charArray = br.readLine().toCharArray();
            if(isPalindrome(charArray)){
                result.append(1 + " ").append(count);
            } else{
                result.append(0 + " ").append(count);
            }
            result.append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }

    public static boolean recursion(char[] s, int l, int r){
        count++;
        if(l >= r) return true;
        else if(s[l] != s[r]) return false;
        else return recursion(s, l+1, r-1);
    }

    public static boolean isPalindrome(char[] s){
        return recursion(s, 0, s.length-1);
    }
}







