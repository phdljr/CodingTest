
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        for (char[] chars : arr) {
            Arrays.fill(chars, '*');
        }

        makeWhole(arr, n / 3, n / 3, n / 3);

        StringBuilder result = new StringBuilder();
        for (char[] chars : arr) {
            result.append(String.valueOf(chars)).append("\n");
        }

        bw.write(result.toString().trim());
        bw.flush();
    }

    public static void makeWhole(char[][] arr, int fr, int fc, int size) {
        if (size < 1) {
            return;
        }

        for (int i = fr; i < fr + size; i++) {
            for (int j = fc; j < fc + size; j++) {
                arr[i][j] = ' ';
            }
        }

        if (size / 3 < 1) {
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                makeWhole(arr, (fr - size * 2 / 3) + (size * i),
                    (fc - size * 2 / 3) + (size * j), size / 3);
            }
        }
    }
}
