import java.util.*;

class Solution {
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[][] graph = new int[n][m];
        
        int start_y = 0; int start_x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = maps[i].charAt(j);
                if (graph[i][j] == 'S') {
                    start_y = i; start_x = j;
                }
            }
        }
        
        int[][] dist = new int[n][m];
        for (int row[] : dist) {
            Arrays.fill(row, -1);
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start_y, start_x});
        dist[start_y][start_x] = 0;
        
        int answer = -1;
        boolean lever = false;
        int le_dist = 0; int lever_y = 0; int lever_x = 0;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int y = cur[0];
            int x = cur[1];
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (graph[ny][nx] == 'X' || dist[ny][nx] != -1) continue;
                dist[ny][nx] = dist[y][x] + 1;
                q.offer(new int[]{ny, nx});
                if (graph[ny][nx] == 'L') {
                    lever = true; le_dist = dist[ny][nx];
                    lever_y = ny; lever_x = nx;
                    break;
                }
            }
            if (lever) break;
        }
        
        if (!lever) return -1;
        
        while (!q.isEmpty()) {
            q.poll();
        }
        
        for (int row[] : dist) {
            Arrays.fill(row, -1);
        }
        
        q.offer(new int[]{lever_y, lever_x});
        dist[lever_y][lever_x] = 0;
        while (!q.isEmpty()) {
            int cur[] = q.poll();
            int y = cur[0];
            int x = cur[1];
            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];
                if (ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if (graph[ny][nx] == 'X' || dist[ny][nx] != -1) continue;
                dist[ny][nx] = dist[y][x] + 1;
                q.offer(new int[]{ny, nx});
                if (graph[ny][nx] == 'E') {
                    answer = le_dist + dist[ny][nx]; return answer;
                }
            }
        }
        
        return answer;
    }
}