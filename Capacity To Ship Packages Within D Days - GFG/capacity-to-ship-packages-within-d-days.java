//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findDay(int []nums,int cap){
        int days=1;
        int load =0;

        for(int i=0;i<nums.length;i++){
            if(load+nums[i]>cap){
                load = nums[i];
                days++;
            }
            else{
                load+=nums[i];
            }
        }
        return days;
    }
    static int leastWeightCapacity(int[] arr, int N, int days) {
        // code here
        int sum=0;
        int max =0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            max = Math.max(max,arr[i]);
        }

        int low = max;
        int high = sum;
        while(low<=high){
            int mid = (low+high)/2;

            if(findDay(arr,mid)<=days){
                high = mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
};