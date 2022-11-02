package programmers.pm12953;

public class Solution {
    public static void main(String[] args) {
        int[] arr = {5,100,120};
        Solution s = new Solution();
        System.out.println(s.gcdArr(arr));
        System.out.println(s.lcmArr(arr, 5));

        System.out.println(s.solution(arr));
    }

    public int solution(int[] arr) {
        int answer = 0;

        int[] temp = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            temp[i] = arr[i];
        }

        int gcd = gcdArr(temp);
        answer = lcmArr(arr, gcd);

        return answer;
    }

    public int gcdArr(int[] arr){
        for(int i=1;i<arr.length;i++){
            arr[0] = gcd(arr[0], arr[i]);
        }
        return arr[0];
    }

    public int gcd(int x, int y){
        if(y == 0)
            return x;
        return gcd(y, x%y);
    }

    public int lcm(int x, int y){
        return x*y / gcd(x, y);
    }

    public int lcmArr(int[] arr, int gcd){
        for(int i=1;i<arr.length;i++){
            arr[0] = lcm(arr[0], arr[i]);
        }
        return arr[0];
    }
}
