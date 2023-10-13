//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.findMinInsertions(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    int findMinInsertions(String s){
        // code here
        return s.length()-longestPalinSubseq(s);
    }
    public static int lcs(String str1, String str2) {
        
    int n=str1.length();
    int m=str2.length();
    int prev[]=new int[m+1];
    
    for(int i=0;i<=n;i++){
        prev[0] = 0;
    }
    for(int i=0;i<=m;i++){
        prev[i] = 0;
    }
    
    for(int ind1=1;ind1<=n;ind1++){
        int curr[]=new int[m+1];
        for(int ind2=1;ind2<=m;ind2++){
            if(str1.charAt(ind1-1)==str2.charAt(ind2-1))
                curr[ind2] = 1 + prev[ind2-1];
            else
                curr[ind2] = 0 + Math.max(prev[ind2],curr[ind2-1]);
        }
        prev = curr;
    }
    return prev[m];
    }
    public int longestPalinSubseq(String S)
    {
        //code here
        String t = S;
        String sb = new StringBuilder(t).reverse().toString();
        return lcs(sb,t);
    }
}