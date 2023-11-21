import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        char[] cArr = in.readLine().toCharArray();

        for (int i = 0; i < cArr.length; i++) {
            if(arr[cArr[i] - 'a'] != -1)
                continue;
            arr[cArr[i] - 'a'] = i;
        }

        for (int n : arr) {
            out.write(n + " ");
        }

        out.flush();
    }
}