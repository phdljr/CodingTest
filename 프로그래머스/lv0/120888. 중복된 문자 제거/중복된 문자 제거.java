import java.util.*;

class Solution {
    public String solution(String my_string) {
        return Arrays.stream(my_string.split("")).distinct().reduce((a, b) -> a + b).get();
    }
}