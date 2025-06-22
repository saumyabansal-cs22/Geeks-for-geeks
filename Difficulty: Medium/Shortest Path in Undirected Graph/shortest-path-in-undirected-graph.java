class Solution {
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, (int) 1e9);

        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()) {
            int r = q.poll();
            for (int neighbor : adj.get(r)) {
                if (dist[r] + 1 < dist[neighbor]) {
                    dist[neighbor] = dist[r] + 1;
                    q.add(neighbor);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
