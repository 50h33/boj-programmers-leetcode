import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        // A친구, B친구, 준 횟수
        Map<String, Map<String, Integer>> one = new HashMap<>();
        // A친구, 모든 친구에게 준 횟수
        Map<String, Integer> give = new HashMap<>();
        // A친구, 모든 친구에게 받은 횟수
        Map<String, Integer> given = new HashMap<>();
        // A친구, 다음 달 받을 선물 개수
        Map<String, Integer> nxt = new HashMap<>();
        
        for (String gift : gifts) {
            String[] part = gift.split(" ");
            String from = part[0];
            String to = part[1];
            if (!one.containsKey(from)) {
                one.put(from, new HashMap<>());
            }
            one.get(from).merge(to, 1, Integer::sum);
            give.merge(from, 1, Integer::sum);
            given.merge(to, 1, Integer::sum);
        }
        
        for (int i = 0; i < friends.length; i++) {
            for (int j = i+1; j < friends.length; j++) {
                int a = 0; int b = 0;
                if (one.containsKey(friends[i])) {
                    a = one.get(friends[i]).getOrDefault(friends[j], 0);
                }
                if (one.containsKey(friends[j])) {
                    b = one.get(friends[j]).getOrDefault(friends[i], 0);
                }

                if (a > b) {
                    nxt.merge(friends[i], 1, Integer::sum);
                } else if (b > a) {
                    nxt.merge(friends[j], 1, Integer::sum);
                } else {
                    int x = give.getOrDefault(friends[i], 0) - given.getOrDefault(friends[i], 0);
                    int y = give.getOrDefault(friends[j], 0) - given.getOrDefault(friends[j], 0);
                    if (x > y) {
                        nxt.merge(friends[i], 1, Integer::sum);
                    } else if (y > x) {
                        nxt.merge(friends[j], 1, Integer::sum);
                    }
                }
            }
        }
        
        int answer = 0;
        for (Map.Entry<String, Integer> entry : nxt.entrySet()) {
            int k = entry.getValue();
            answer = Math.max(answer, k);
        }
        
        return answer;
    }
}