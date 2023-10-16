//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> res = obj.LargestSubset(N, arr);
            int isValidSeq = 1, sz = res.size();
            for (int i = 0; i < sz; i++) {
                for (int j = i + 1; j < sz; j++) {
                    if ((res.get(i) % res.get(j) == 0) ||
                        (res.get(j) % res.get(i) == 0))
                        continue;
                    else {
                        isValidSeq = 0;
                        break;
                    }
                }
            }
            System.out.println(isValidSeq + " " + sz);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> LargestSubset(int n, int[] arr) {
        // Code here
        Arrays.sort(arr);
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int hash [] = new int[n];
        int lastidx=0;
        int max= Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            hash[i] =i;
            for(int prev=0;prev<i;prev++){
                if(arr[i]%arr[prev]==0 && 1+dp[prev]>dp[i]){
                    dp[i] = 1+dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i]>max){
                max=dp[i];
                lastidx = i;
            }
        }
        ArrayList<Integer>ans = new ArrayList<>();
        ans.add(arr[lastidx]);
        while(hash[lastidx]!=lastidx){
            lastidx= hash[lastidx];
            ans.add(arr[lastidx]);
        }
        
        Collections.sort(ans);
        return ans;
    }
}
