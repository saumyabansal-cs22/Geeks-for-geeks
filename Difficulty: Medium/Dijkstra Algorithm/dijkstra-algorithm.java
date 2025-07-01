class Pair {
    int node;
    int distance;

    public Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] a : edges) {
            int u = a[0], v = a[1], w = a[2];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w)); // for undirected
        }

        int[] dist = new int[V];
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;

        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.distance == b.distance) return a.node - b.node;
            return a.distance - b.distance;
        });

        set.add(new Pair(src, 0));

        while (!set.isEmpty()) {
            Pair rp = set.pollFirst();  // extract min
            int u = rp.node;

            for (Pair nbr : adj.get(u)) {
                int v = nbr.node;
                int wt = nbr.distance;

                if (dist[u] + wt < dist[v]) {
                    // Remove if already present with old distance
                    set.remove(new Pair(v, dist[v]));
                    dist[v] = dist[u] + wt;
                    set.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}
