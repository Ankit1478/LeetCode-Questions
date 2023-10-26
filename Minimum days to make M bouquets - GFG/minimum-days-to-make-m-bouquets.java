//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
     static boolean f(int[] bloomDay, long day,int m, int k ){
        long count=0;
        long noOfBloom =0;

        for(int i=0;i< bloomDay.length;i++){
            if(bloomDay[i]<=(int)day){
                count++;
            }
            else{
                noOfBloom += count/k;
                count=0;
            }
        }
        noOfBloom += count/k;
         return noOfBloom >= m;
    }
    static int min(int bloomDay[]){
        int min = 0;
        for(int i=0;i<bloomDay.length;i++){
            min = Math.min(min,bloomDay[i]);
        }
        return min;
    }
    static int max(int bloomDay[]){
        int max=0;
        for(int i=0;i<bloomDay.length;i++){
            max = Math.max(max,bloomDay[i]);
        }
        return max;
    }
    public static int solve(int m, int k, int[] bloomDay) {
       if((long)m*k> bloomDay.length)return -1;
        int low = min(bloomDay);
        int high = max(bloomDay);
        long ans =0;

        while(low<=high){
            long mid = (low+high)/2;

            if(f(bloomDay, mid, m, k )){
                ans = mid;
                high =(int)mid-1;
               
            }
            else{
                 low = (int)mid+1;
            }
        }
        return (int) ans;
    }
}