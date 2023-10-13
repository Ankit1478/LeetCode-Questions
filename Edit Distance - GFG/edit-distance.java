//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String word1, String word2) {
        // Code here
        
        int n=word1.length();
        int m =word2.length();
        int dp[][]=new int[n+1][m+1];

        // if(j==0) return i;
        for(int i=0;i<=n;i++){
            dp[i][0]=i;
        }
        //if (i==0) return j;
        for(int j=0;j<=m;j++){
            dp[0][j]=j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=0+dp[i-1][j-1];
                }else{
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[n][m];
    //     int n = s.length();
    //     int m = t.length();
    //     int dp[][] = new int[n+1][m+1];
    //     for(int row[]:dp)Arrays.fill(row,-1);
        
    //     return f(n,m,s,t,dp);
    // }
    // static int f(int i ,int j, String s, String t,int dp[][]){
        
    //     if(i==0)return j+1;
    //     if(j==0)return i+1;
        
    //     if(dp[i][j]!=-1)return dp[i][j];
        
    //     if(s.charAt(i-1)==t.charAt(j-1)){
    //         dp[i][j] = f(i-1,j-1,s,t,dp);
    //     }
    //     else{
    //         dp[i][j] = 1+Math.min(f(i-1,j,s,t,dp),Math.min(f(i,j-1,s,t,dp),f(i-1,j-1,s,t,dp)));
    //     }
    //     return dp[i][j];
    }
}