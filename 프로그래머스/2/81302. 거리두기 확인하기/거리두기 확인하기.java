import java.util.*;

class Solution {
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    public int[] solution(String[][] places) {
        int n = places[0].length;
        int m = places[0][0].length();
        int[] answer = new int[places.length];
        int idx = 0;
        for (String[] place : places) {
            char[][] graph = new char[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    graph[i][j] = place[i].charAt(j);
                }
            }
            boolean flag = false;
            Queue<int[]> q = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 'P') {
                        int[][] dist = new int[n][m];
                        for (int[] row : dist) {
                            Arrays.fill(row, -1);
                        }
                        q.offer(new int[]{i, j});
                        dist[i][j] = 0;
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            int y = cur[0];
                            int x = cur[1];
                            if (dist[y][x] > 2) continue;
                            if (dist[y][x] >= 1 && graph[y][x] == 'P') {
                                flag = true; break;
                            }
                            for (int d = 0; d < 4; d++) {
                                int ny = y + dy[d];
                                int nx = x + dx[d];
                                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                                if (dist[ny][nx] != -1 || graph[ny][nx] == 'X' || dist[i][j] > 2) continue;
                                dist[ny][nx] = dist[y][x] + 1;
                                q.offer(new int[]{ny, nx});
                                
                            }
                        }
                        if (flag) break;
                    }
                    if (flag) break;
                }
            }
            if (!flag) {
                answer[idx++]++;
            } else {
                idx++;
            }
        }
        
        return answer;
    }
}