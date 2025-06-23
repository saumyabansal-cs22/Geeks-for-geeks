// User function Template for Java
class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public static void topo(int node, ArrayList<ArrayList<Pair>> ll, int[] vis, Stack<Integer> st){
        vis[node]=1;
        for(int i=0;i<ll.get(node).size();i++){
            int v= ll.get(node).get(i).first;
            if (vis[v]==0){
                topo(v,ll,vis,st);
            }
        }
        st.add(node);
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> ll= new ArrayList<>();
        for(int i=0;i<V;i++){
            ArrayList<Pair> pp= new ArrayList<>();
            ll.add(pp);
        }
        for(int i=0;i<E;i++){
            int u= edges[i][0];
            int v= edges[i][1];
            int w=edges[i][2];
            ll.get(u).add(new Pair(v,w));
        }
        int vis[]=new int[V];
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<V;i++){
            if (vis[i]==0){
                topo(i,ll,vis,st);
            }
        }
        int[] dist= new int[V];
        for(int i=0;i<V;i++){
            dist[i]=(int)1e9;
        }
        dist[0]=0;
        while(!st.isEmpty()){
            int node= st.pop();
            // st.remove();
            for(Pair nbrs: ll.get(node)){
                int v=nbrs.first;
                int w=nbrs.second;
                if (dist[node]+w<dist[v]){
                    dist[v]= dist[node]+w;
                }
                
            }
        }
        for(int i=0;i<V;i++){
            if (dist[i]==1e9){
                dist[i]=-1;
            }
        }
        return dist;
        
        
    }
}