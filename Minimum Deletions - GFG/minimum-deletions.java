//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumNumberOfDeletions(String s) {
        int n =s.length();
        int k=reverse(s);
        return n-k;
    }
    public static int lcs(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int prev[]=new int [m+1];
        
        for(int i=1;i<=n;i++){
            int curr[]=new int[m+1];
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j]=1+prev[j-1];
                }else{
                    curr[j]=Math.max(prev[j],curr[j-1]);
                }
            }
          
             prev = curr;
        }
        return prev[m];
    }
    public static int reverse(String s){
        String t=s;
        String sb = new StringBuilder(s).reverse().toString();
        return lcs(sb,t);
    }
}