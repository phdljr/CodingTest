class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        while(true){
            int count = 0;
            for(int i=0;i<arr.length;i++){
                int temp = arr[i];
                if(arr[i] >= 50 && arr[i] % 2 == 0){
                    arr[i] /= 2;
                } else if(arr[i] < 50 && arr[i] % 2 == 1){
                    arr[i] = arr[i] * 2 + 1;
                }
                if(temp == arr[i]){
                    count++;
                }
            }
            if(count == arr.length){
                break;
            }
            answer++;
            count = 0;
        }
        return answer;
    }
}