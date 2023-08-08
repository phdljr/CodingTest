package programmers;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int n = arr.length;

        permutation(arr, 0, n, 3);
    }

    public static void permutation(int[] arr, int depth, int n, int r){
        if(depth == r){
            for(int i=0;i<r;i++){
                System.out.print(arr[i]);
            }
            System.out.println();
            return;
        }

        for(int i=depth;i<n;i++){
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    public static void swap(int[] arr, int depth, int i){
        int temp = arr[i];
        arr[i] = arr[depth];
        arr[depth] = temp;
    }
}
