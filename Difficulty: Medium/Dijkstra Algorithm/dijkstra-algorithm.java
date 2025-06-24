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
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] a : edges) {
            int n1 = a[0];
            int n2 = a[1];
            int wt = a[2];
            adj.get(n1).add(new Pair(n2, wt));
            adj.get(n2).add(new Pair(n1, wt)); // if undirected
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>((x, y) -> x.distance - y.distance);
        q.add(new Pair(src, 0));

        while (!q.isEmpty()) {
            Pair rp = q.poll();
            int nn = rp.node;
            int d = rp.distance;

            for (Pair nbr : adj.get(nn)) {
                int nextNode = nbr.node;
                int edgeWeight = nbr.distance;
                if (d + edgeWeight < dist[nextNode]) {
                    dist[nextNode] = d + edgeWeight;
                    q.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        return dist;
    }
}
