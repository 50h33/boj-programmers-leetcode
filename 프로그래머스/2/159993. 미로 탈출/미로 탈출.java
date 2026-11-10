
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

class Solution {
    private static final int[] DY = {-1, 0, 1, 0};
    private static final int[] DX = {0, 1, 0, -1};

    public int solution(String[] maps) {
        int toLever = bfs(maps, 'S', 'L');
        if (toLever == -1) return -1;

        int toExit = bfs(maps, 'L', 'E');
        if (toExit == -1) return -1;

        return toLever + toExit;
    }

    private int bfs(String[] maps, char start, char target) {
        int n = maps.length;
        int m = maps[0].length();

        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (maps[y].charAt(x) == start) {
                    dist[y][x] = 0;
                    queue.offer(new int[]{y, x});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            if (maps[y].charAt(x) == target) {
                return dist[y][x];
            }

            for (int d = 0; d < 4; d++) {
                int ny = y + DY[d];
                int nx = x + DX[d];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }
                if (maps[ny].charAt(nx) == 'X'
                        || dist[ny][nx] != -1) {
                    continue;
                }

                dist[ny][nx] = dist[y][x] + 1;
                queue.offer(new int[]{ny, nx});
            }
        }

        return -1;
    }
}