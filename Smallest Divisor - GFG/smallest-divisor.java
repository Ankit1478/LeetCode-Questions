//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
     static int f(int nums[],int mid ){
        int n = nums.length;
        int num=0;
        for(int i=0;i<n;i++){
            num += Math.ceil((double)(nums[i]) / (double)(mid));
           
        }
        return num;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        if(n > threshold) return -1;
        int min = 0;
        int max=0;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
        }
        
        int ans =0;
        int low = 1;
        int high = max;

        while(low<=high){
            int mid = (low+high)/2;

            if(f(nums,mid)<=threshold){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}