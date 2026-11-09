import java.util.*;

class Solution {
    private static final int[] DY = {-1, 0, 1, 0};
    private static final int[] DX = {0, 1, 0, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = isRoomSafe(places[i]) ? 1 : 0;
        }

        return answer;
    }

    private boolean isRoomSafe(String[] room) {
        int n = room.length;
        int m = room[0].length();

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (room[y].charAt(x) == 'P'
                        && !isPersonSafe(room, y, x)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isPersonSafe(String[] room, int sy, int sx) {
        int n = room.length;
        int m = room[0].length();

        int[][] dist = new int[n][m];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        dist[sy][sx] = 0;
        queue.offer(new int[]{sy, sx});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            if (dist[y][x] == 2) {
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int ny = y + DY[d];
                int nx = x + DX[d];

                if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
                    continue;
                }

                if (dist[ny][nx] != -1 || room[ny].charAt(nx) == 'X') {
                    continue;
                }

                if (room[ny].charAt(nx) == 'P') {
                    return false;
                }

                dist[ny][nx] = dist[y][x] + 1;
                queue.offer(new int[]{ny, nx});
            }
        }

        return true;
    }
}
