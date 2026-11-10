import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = new int[privacies.length];
        Map<String, Integer> mp = new HashMap<>();
        
        for (String term : terms) {
            String[] part = term.split(" ");
            String key = part[0];
            int value = Integer.parseInt(part[1]);
            mp.put(key, value);
        }
        
        int idx_a = 0; int idx_p = 1;
        for (String privacy : privacies) {
            String[] part = privacy.split(" ");
            if(diff(today, part[0], mp.get(part[1]))) {
                answer[idx_a] = idx_p; idx_a++;
            }
            idx_p++;
        }
        
        
        return Arrays.copyOf(answer, idx_a);
    }
    
    private boolean diff(String today, String past, int term) {
        if (calDate(today) - calDate(past) >= term * 28) return true;
        return false;
    }
    
    private int calDate(String date) {
        String[] part = date.split("\\.");
        int y = Integer.parseInt(part[0]) - 2000;
        int m = Integer.parseInt(part[1]);
        int d = Integer.parseInt(part[2]);
        return (y-1) * 28 * 12 + (m-1) * 28 + d;
    }
}