import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;

        // 친구 이름을 배열 인덱스로 변환
        Map<String, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(friends[i], i);
        }

        int[][] sent = new int[n][n];
        int[] giftIndex = new int[n];

        // 주고받은 횟수와 선물 지수 집계
        for (String gift : gifts) {
            String[] names = gift.split(" ");
            int from = index.get(names[0]);
            int to = index.get(names[1]);

            sent[from][to]++;
            giftIndex[from]++;
            giftIndex[to]--;
        }

        int[] nextMonth = new int[n];

        // 모든 친구 쌍을 한 번씩 비교
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = sent[i][j] - sent[j][i];

                // 주고받은 횟수가 같으면 선물 지수로 비교
                if (diff == 0) {
                    diff = giftIndex[i] - giftIndex[j];
                }

                if (diff > 0) {
                    nextMonth[i]++;
                } else if (diff < 0) {
                    nextMonth[j]++;
                }
            }
        }

        int answer = 0;
        for (int count : nextMonth) {
            answer = Math.max(answer, count);
        }

        return answer;
    }
}