class Solution {
    public int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();

        // 북, 동, 남, 서
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};

        int y = 0;
        int x = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (park[row].charAt(col) == 'S') {
                    y = row;
                    x = col;
                }
            }
        }

        for (String route : routes) {
            String[] parts = route.split(" ");
            int direction = "NESW".indexOf(parts[0]);
            int distance = Integer.parseInt(parts[1]);

            int ny = y;
            int nx = x;
            boolean valid = true;

            for (int step = 0; step < distance; step++) {
                ny += dy[direction];
                nx += dx[direction];

                if (ny < 0 || ny >= height
                        || nx < 0 || nx >= width) {
                    valid = false;
                    break;
                }

                if (park[ny].charAt(nx) == 'X') {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                y = ny;
                x = nx;
            }
        }

        return new int[]{y, x};
    }
}