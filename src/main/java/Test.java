import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,9,6,2};
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length;

        System.out.println(binarySearch(arr, 8, start, end));
        permutation(arr, new boolean[arr.length], new int[3], 0, arr.length, 2);
    }

    public static void permutation(int[] arr, boolean[] visited, int[] output, int depth, int n, int r){
        if(depth == r){
            for(int i=0;i<r;i++)
                System.out.print(output[i] + " ");
            System.out.println();
            return;
        }

        for(int i=depth;i<n;i++){
            if(visited[i] == false){
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, visited, output, depth+1, n, r);
                visited[i] = false;
            }
        }
    }

    public static int binarySearch(int[] arr, int target, int start, int end){
        while (start<=end){
            int mid = (start + end) / 2;
            if(arr[mid] == target){
                return mid;
            } else if(arr[mid] > target){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
