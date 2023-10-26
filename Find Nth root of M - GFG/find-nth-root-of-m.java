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
    public int NthRoot(int n, int m)
    {
        // code here
      int low =1;
       int high = m;
       long ans=0;
       while(low<=high){
           long mid = (low+high)/2;
           
           if((Math.pow(mid, n))==m ){
               return (int)mid;
           }

           if((Math.pow(mid, n))<m ){
               low =(int) mid+1;
           }
           else{
               high =(int) mid-1;
           }
       }
       return -1;
    }
}