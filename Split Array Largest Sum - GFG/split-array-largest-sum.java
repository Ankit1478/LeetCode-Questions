//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int f(int arr[] , int mid,int k){
        int sum=0;
        int cnt=1;
        
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]<=mid){
                sum+=arr[i];
            }else{
                cnt++;
                sum= arr[i];
            }
        }
       return cnt;
    }
    static int splitArray(int[] arr , int n, int k) {
        // code here
        int sum=0;
        int max = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            max = Math.max(max,arr[i]);
        }
        int low= max;
        int high= sum;
        
        while(low<=high){
            int mid = (low+high)/2;
            if(f(arr,mid,k)>k){
                low = mid+1;
            }
            else{
                high= mid-1;
            }
        }
        return low;
    }
};














