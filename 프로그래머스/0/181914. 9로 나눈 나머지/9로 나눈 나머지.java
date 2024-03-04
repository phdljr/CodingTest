class Solution {
    public int solution(String number) {
        int temp = 0;
        for(String str: number.split("")){
            temp += Integer.parseInt(str);
        }
        return temp % 9;
    }
}