class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i=0;i<numbers.length;i++){
            answer[i] = f(numbers[i]);
        }
        return answer;
    }
    
    public long f(long num){
        if(num % 2 == 0){
            return num+1;
        } else{
            String bin = "0" + Long.toString(num, 2);
            String[] binArr = bin.split("");
            // 1. 오른쪽에서 최초의 0을 1로 바꾸기
            // 2. 0의 바로 오른족에있는 1을 0으로 변경
            for(int i=binArr.length-1;i>=0;i--){
                if(binArr[i].equals("0")){
                    binArr[i] = "1";
                    binArr[i+1] = "0";
                    break;
                }
            }
            
            Long result = 0L;
            int count = 0;
            for(int i=binArr.length-1; i>=0;i--){
                result += Long.valueOf(binArr[i]) * (long)Math.pow(2, count++);
            }
            
            return result;
        }
    }
}