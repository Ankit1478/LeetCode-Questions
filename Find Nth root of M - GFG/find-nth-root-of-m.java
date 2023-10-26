//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int f(int mid ,int n, int m){
        long ans =1;
        for(int i=1;i<=n;i++){
            ans = ans*mid;
            if(ans>m)return 2;
        }
        if(ans==m)return 1;
        return 0;
    }
    public int NthRoot(int n, int m)
    {
        // code here
      int low =1;
       int high = m;
       long ans=0;
       while(low<=high){
           int mid2 = (low+high)/2;
           int mid=f(mid2,n,m);
           
           if(mid==1 ){
               return mid2;
           }

           if(mid==0){
               low =mid2+1;
           }
           else{
               high = mid2-1;
           }
       }
       return -1;
    }
}