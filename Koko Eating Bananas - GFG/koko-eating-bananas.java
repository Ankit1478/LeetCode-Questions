//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
     public static int max(int piles[]){
        int max =0;
        for(int i=0;i<piles.length;i++){
            max = Math.max(max,piles[i]);
        }
        return max;
    }
    public static int fun(int piles[],int mid){
        int totalHour =0;
        for(int i=0;i<piles.length;i++){
            totalHour+= Math.ceil((double)piles[i]/(double)mid);
        }
        return totalHour;
    }
    public static int Solve(int N, int[] piles, int h) {
       
        int low =1;
        int high = max(piles);
        int ans = Integer.MAX_VALUE;

        while(low<=high){
            int mid = (low+high)/2;
            int hour = fun(piles,mid);

            if(hour <= h){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
        
