//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int id[] = new int[V];
        for(int i=0;i<V;i++){
            for(int it:adj.get(i)){
                id[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<V;i++){
            if (id[i]==0){
                q.add(i);
            }
        }
        
        int cnt=0;
        while(!q.isEmpty()){
            int node= q.peek();
            q.remove();
            cnt++;
            
            for(int nbrs: adj.get(node)){
                id[nbrs]--;
                if (id[nbrs]==0){
                    q.add(nbrs);
                }
            }
            
        }
        if (cnt==V){
            return false;
        }
        return true;
    }
}