package programmers.study.permutation;

public class PermutationSequence {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        boolean[] visited = new boolean[arr.length];
        int n = arr.length;
        int[] output = new int[arr.length];

        permutation(arr, output, visited, 0, n, 3);
    }

    public static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(output[i]);
            }
            System.out.println();
            return;
        }

        for (int i = depth; i < n; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
