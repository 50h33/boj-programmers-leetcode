import java.util.*;

class Solution {
    static int dy[] = {1, 1, 1, 1, 1, 1};
    static int dx[] = {-3, -2, -1, 1, 2, 3};
    int solution(int[][] land) {
        int n = land.length;
        
        int[][] dp = new int[n][4];
        for (int x = 0; x < 4; x++) {
            dp[0][x] = land[0][x];
        }
        
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < 4; x++) {
                for (int d = 0; d < 6; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if (ny >= n || nx < 0 || nx >= 4) continue;
                    dp[ny][nx] = Math.max(dp[ny][nx], dp[y][x] + land[ny][nx]);
                }
            }
        }
        
        int answer = 0;
        for (int x = 0; x < 4; x++) {
            answer = Math.max(answer, dp[n-1][x]);
        }

        return answer;
    }
}