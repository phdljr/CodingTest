class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[arr1.length];
        int[] arr = new int[arr1.length];
        
        for(int i=0;i<arr.length;i++)
        {
            answer[i] = "";
            arr[i] = arr1[i]|arr2[i];
        }
        
        int k=(int)Math.pow(2,arr.length-1);
        for(int i=0;i<arr.length;i++)
        {
            while(k!=0)
            {
                if((arr[i]&k) == k) answer[i]+='#';
                else answer[i]+=' ';
                k/=2;
            }
            k=(int)Math.pow(2,arr.length-1);
        }
        
        return answer;
    }
}