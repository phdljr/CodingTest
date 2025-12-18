
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    static int[] numbers;
    static int[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        calc(1, numbers[0]);

        bw.write(max + "\n" + min);
        bw.flush();
    }

    private static void calc(int index, int result) {
        if(index == numbers.length) {
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        if(operators[0] > 0){
            operators[0]--;
            calc(index + 1, result + numbers[index]);
            operators[0]++;
        }

        if(operators[1] > 0){
            operators[1]--;
            calc(index + 1, result - numbers[index]);
            operators[1]++;
        }

        if(operators[2] > 0){
            operators[2]--;
            calc(index + 1, result * numbers[index]);
            operators[2]++;
        }

        if(operators[3] > 0){
            operators[3]--;
            if(result > 0){
                calc(index + 1, result / numbers[index]);
            } else{
                calc(index + 1, -(-result / numbers[index]));
            }
            operators[3]++;
        }
    }
}

