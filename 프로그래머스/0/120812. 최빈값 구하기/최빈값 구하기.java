class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] d = new int[1000];
        
        for(int i=0;i<array.length;i++)
            d[array[i]]++;
        
        int max = 0;
        boolean flag = false;
        for(int i=0;i<d.length;i++){
            if(max == d[i]){
                flag = true;
            }else if(max < d[i]){
                flag = false;
                max = d[i];
                answer = i;
            }
        }
            
        return flag ? -1 : answer;
    }
}