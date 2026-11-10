import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        int n = numbers.length;
        int total = 0;
        int answer = 0;
        
        answer += go(0, total, numbers, target);
        
        return answer;
    }
    
    private int go(int idx, int total, int[] numbers, int target) {
        int n = numbers.length;
        if (idx == n && total == target) return 1;
        if (idx >= n) return 0;
        return go(idx+1, total+numbers[idx], numbers, target)
            + go(idx+1, total-numbers[idx], numbers, target);
    }
}