class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<food.length;i++){
            int d = food[i] / 2;
            for(int j=0;j<d;j++)
                sb.append(i);
        }
        answer = sb.toString() + "0" + sb.reverse().toString();
        return answer;
    }
}