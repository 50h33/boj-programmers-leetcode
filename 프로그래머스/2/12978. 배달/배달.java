import java.util.*;

class Solution {
    static final long INF = Long.MAX_VALUE / 4;
    
    public int solution(int n, int[][] roads, int k) {
        int answer = 0;
        List<int[]>[] graph = new ArrayList[n+1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }
        
        long[] dist = new long[n+1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[]{0, 1});
        
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            
            if (d != dist[u]) continue;
            
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                
                long nd = d + w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new long[]{nd, v});
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= k) answer++;
        }
        return answer;
    }
}