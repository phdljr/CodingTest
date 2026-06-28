class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int d = 1;
        int count = 0;
        while(true)
        {
            if(n/(d*3) <= 0) break;
            d*=3; count++;
        }
        
        String thr = "";
        for(int i=count;i >= 0;i--)
        {
            thr += Integer.toString((int)(n/Math.pow(3,i)));
            n-=Math.pow(3,i) * (int)(n/Math.pow(3,i));
        }
        
        StringBuffer sb = new StringBuffer(thr);
        thr = sb.reverse().toString();

        answer+=Integer.parseInt(thr, 3);
        
        return answer;
    }
}