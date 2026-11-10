class Solution {
    static int dy[] = {-1, 0, 1, 0};
    static int dx[] = {0, 1, 0, -1};
    
    public int[] solution(String[] park, String[] routes) {
        int n = park.length;
        int m = park[0].length();
        char[][] graph = new char[n][m];
        
        int y = 0; int x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = park[i].charAt(j);
                if (graph[i][j] == 'S') {
                    y = i; x = j;
                }
            }
        }
        
        int ny = 0; int nx = 0;
        for (String route : routes) {
            String[] part = route.split(" ");
            int cnt = Integer.parseInt(part[1]);
            if (part[0].equals("E")) { // 동 1
                int tmp_y = y; int tmp_x = x;
                while(cnt-- > 0) {
                    ny = y + dy[1];
                    nx = x + dx[1];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || graph[ny][nx] == 'X') {
                        y = tmp_y; x = tmp_x;
                        break;
                    }
                    y = ny; x = nx;
                }
            } else if (part[0].equals("W")) { // 서 3
                int tmp_y = y; int tmp_x = x;
                while(cnt-- > 0) {
                    ny = y + dy[3];
                    nx = x + dx[3];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || graph[ny][nx] == 'X') {
                        y = tmp_y; x = tmp_x;
                        break;
                    }
                    y = ny; x = nx;
                }
            } else if (part[0].equals("S")) { // 남 2
                int tmp_y = y; int tmp_x = x;
                while(cnt-- > 0) {
                    ny = y + dy[2];
                    nx = x + dx[2];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || graph[ny][nx] == 'X') {
                        y = tmp_y; x = tmp_x;
                        break;
                    }
                    y = ny; x = nx;
                }
            } else { // 북 0
                int tmp_y = y; int tmp_x = x;
                while(cnt-- > 0) {
                    ny = y + dy[0];
                    nx = x + dx[0];
                    if (ny < 0 || ny >= n || nx < 0 || nx >= m || graph[ny][nx] == 'X') {
                        y = tmp_y; x = tmp_x;
                        break;
                    }
                    y = ny; x = nx;
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = y;
        answer[1] = x;
        return answer;
    }
}