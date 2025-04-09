//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalElements(arr);
            System.out.println(ans);

            System.out.println("~");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int totalElements(Integer[] arr) {
        // code here
        int k=2;
        int r=0;
        int l=0;
        int n=arr.length;
        int len=0; int maxlen=0;
        HashMap <Integer, Integer> mpp= new HashMap<>();
        while(r<n){
            mpp.put(arr[r], mpp.getOrDefault(arr[r], 0) + 1);
            if (mpp.size()>k){
                 mpp.put(arr[l], mpp.get(arr[l]) - 1);
                if (mpp.get(arr[l]) == 0){
                    mpp.remove(arr[l]);
                }
                l++;
            }
            if (mpp.size()<=k){
                len=r-l+1;
                maxlen=Math.max(maxlen,len);
            }
            
            r++;
        }
        return maxlen;
        
    }
}