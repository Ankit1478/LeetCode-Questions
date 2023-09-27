//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java


class Solution
{ 
    boolean knows(int M[][], int a , int b, int n){
        if(M[a][b]==1)return true;
        return false;
    }
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Stack<Integer>s = new Stack<>();
    	
    	for(int i=0;i<n;i++){
    	    s.push(i);
    	}
    	    
    	   while(s.size()!=1){
    	        int A = s.pop();
    	        int B = s.pop();
    	        
    	        if(knows(M,A,B,n))s.push(B);
    	        else s.push(A);
    	    }
    	    int candidate = s.pop();
    	    int countzero=0;
    	    int countone =0;
    	    boolean iszero =false;
    	    boolean isone = false;
    	    
    	    
    	    for(int i=0;i<n;i++){
    	        if(M[candidate][i]==0){
    	            countzero++;
    	        }
    	        if(countzero == n) iszero =true;
    	    }
    	    
    	    for(int i=0;i<n;i++){
    	        if(M[i][candidate]==1){
    	            countone++;
    	        }
    	        if(countone == n-1) isone =true;
    	}
    	
    	if(iszero  &&  isone ){
    	       return candidate;
    	   }
    	   else return -1;
    }
}