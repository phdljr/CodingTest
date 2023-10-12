class Solution {
    public int solution(int order) {
        int len1 = String.valueOf(order).length();
        int len2 = String.valueOf(order).replaceAll("[369]", "").length();
        return len1 - len2;
    }
}