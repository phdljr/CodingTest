package programmers.level2.pm42747;

public class Solution {
    public int solution(int[] citations) {
        int hmax = 0;

        for(int h=0;h<=10000;h++){
            int use = 0;
            for(int j=0;j<citations.length;j++){
                if(h <= citations[j]){
                    use++;
                }
            }

            if(use >= h && citations.length - use <= h){
                if(hmax < h){
                    hmax = h;
                }
            }
        }

        return hmax;
    }
}