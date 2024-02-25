import java.util.*;

class Solution {
    static int answer = 0;
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        for(int i=1;i<=numbers.length();i++)
            permutation(numbers.split(""), 0, numbers.length(), i);
        return answer;
    }
    
    public void permutation(String[] arr, int depth, int n, int r){
        if(depth == r){
            String temp = "";
            for(int i=0;i<r;i++){
                temp += arr[i];
            }
            if(isPrime(Integer.parseInt(temp))){
                set.add(Integer.parseInt(temp));
                answer++;
            }
            return;
        }

        for(int i=depth;i<n;i++){
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    public void swap(String[] arr, int depth, int i){
        String temp = arr[i];
        arr[i] = arr[depth];
        arr[depth] = temp;
    }
    
    public boolean isPrime(int num){
        if(set.contains(num)){
            return false;
        }
        
        if(num < 2){
            return false;
        }
        
        for(int i=2;i*i<=num;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}