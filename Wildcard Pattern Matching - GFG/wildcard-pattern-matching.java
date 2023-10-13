//{ Driver Code Starts
import java.util.*;

class WildcardPattern
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String pat = sc.nextLine();
			String text = sc.nextLine();
			Solution g = new Solution();
			System.out.println(g.wildCard(pat,text));
			t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int wildCard(String s, String t)
    {
        // Your code goes here
        int n = s.length();
        int m = t.length();
        boolean dp[][] = new boolean[n+1][m+1];
       
       //base case 
       //1. iand j==0 true
       dp[0][0] = true;
       
       //2. i=0 and j>0 
       for(int j=1;j<=m;j++){
           dp[0][j]= false;
       }
       
       //3. i>1 and j==0
       for(int i=1;i<=n;i++){
           boolean flag = true;
          for(int k=1;k<=i;k++){
                if(s.charAt(k-1)!='*') flag=false;;
            }
             dp[i][0] = flag;
       }
       
       for(int i=1;i<=n;i++){
           for(int j=1;j<=m;j++){
               if(s.charAt(i-1) == t.charAt(j-1) || s.charAt(i-1)=='?'){
            dp[i][j] = dp[i-1][j-1];
        }
        else{
            if(s.charAt(i-1)=='*'){
                dp[i][j] = dp[i-1][j] || dp[i][j-1];
            }
        }
           }
       }
       int ans = dp[n][m]==true ?1:0;
       return ans;
      
    }
    static boolean f(int i,int j,String s, String t,boolean dp[][]){
        
        if(i==0 && j==0)return true;
        if(i==0 && j>0)return false;
        if(j==0 && i>0){
            for(int k=1;k<=i;k++){
                if(s.charAt(k-1)!='*')return false;
            }
            return true;
        }
        
        if(dp[i][j]!=false)return dp[i][j];
        
        if(s.charAt(i-1) == t.charAt(j-1) || s.charAt(i-1)=='?'){
            dp[i][j] = f(i-1,j-1,s,t,dp);
        }
        else{
            if(s.charAt(i-1)=='*'){
                dp[i][j] = f(i-1,j,s,t,dp) || f(i,j-1,s,t,dp);
            }
        }
        return dp[i][j];
    }
}
