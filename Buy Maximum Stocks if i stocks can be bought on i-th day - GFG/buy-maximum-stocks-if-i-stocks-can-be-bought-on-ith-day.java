//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    static class Pair{
        int first, second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
         ArrayList<Pair> v = new ArrayList<>();

        // Adding price and index pairs to ArrayList
        for (int i = 0; i < n; ++i)
            v.add(new Pair(price[i], i + 1));   
     
        // Sorting the ArrayList in ascending order based on price
      Collections.sort(v, (a, b) -> a.first - b.first);

        // Collections.sort(v, new Comparator<Pair>(){
        //     @Override
        //     public int compare(Pair p1, Pair p2){
        //         return p1.first - p2.first;
        //     }
        // });
        
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            // Calculate maximum number of products that can be bought for the current price
            int quantity = Math.min(v.get(i).second, k / v.get(i).first);
            // Increase the total products bought by the quantity
            ans += quantity;
            // Decrease the budget by the total cost of the products bought
            k -= v.get(i).first * quantity;
        }
    
        // Return the total products bought
        return ans;
    }
}
        
