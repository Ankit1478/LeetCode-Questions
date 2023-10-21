//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine().trim());
            
            Solution ob = new Solution();
            System.out.println(ob.arrangeTiles(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static long arrangeTiles(int N){
        // code here
         if(N<4)
        return 1;
        else if(N==4)
        return 2;
        else{
        long res[]=new long[N+1];
        res[0]=0;
        res[1]=1;
        res[2]=1;
        res[3]=1;
        res[4]=2;
        int j=1;
        for(int i=5;i<res.length;i++){
            res[i]=res[i-1]+res[j];
            j++;
        }
        return res[N];
}
    }
}