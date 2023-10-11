class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] arr = binomial.split(" ");
        int n1 = Integer.parseInt(arr[0]);
        int n2 = Integer.parseInt(arr[2]);
        switch(arr[1]){
            case "+": answer = n1 + n2; break;
            case "-": answer = n1 - n2; break;
            case "*": answer = n1 * n2; break;
        }
        return answer;
    }
}