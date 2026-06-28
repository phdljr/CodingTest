
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int k = 0;
    static int count = 0;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        int a = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);

        if(k > count)
            result = -1;

        bw.write(result + "");
        bw.flush();
    }

    private static void mergeSort(int[] arr, int from, int to, int[] temp) {
        if(from < to){
            int mid = (from + to) / 2;
            mergeSort(arr, from, mid, temp);
            mergeSort(arr, mid+1, to, temp);
            merge(arr, from, mid, to, temp);
        }
    }

    private static void merge(int[] arr, int p, int q, int r, int[] temp) {
        int index = 0;
        int i = p;
        int j = q + 1;
        while(i <= q && j <= r){
            if(arr[i] < arr[j]){
                temp[index++] = arr[i++];
            } else{
                temp[index++] = arr[j++];
            }
        }

        while(i <= q){
            temp[index++] = arr[i++];
        }
        while(j <= r){
            temp[index++] = arr[j++];
        }

        i = p;
        index = 0;
        while(i <= r){
            arr[i++] = temp[index++];
            count++;
            if(k == count)
                result = arr[i-1];
        }
    }
}

