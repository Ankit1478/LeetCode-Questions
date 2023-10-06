//{ Driver Code Starts
import java.util.*;

class Partition_Arr_To_K_Subsets
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			int a[] = new int[n];
			for(int i=0;i<n;i++)
				a[i] = sc.nextInt();
			int k = sc.nextInt();
			Solution g = new Solution();
			if(g.isKPartitionPossible(a,n,k)==true)
				System.out.println(1);
			else 
				System.out.println(0);
			
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this method */

class Solution
{
    static boolean f(int idx, int a[],  int tar,int sum,int k, boolean  vis[],int n){
        if(k==0)return true;
        
        if(sum>tar)return false;
        
        if(sum == tar){
            return f(0,a,tar,0,k-1,vis,n);
        }
        
        for(int i=idx;i<n;i++){
            if(vis[i])continue;
            
            vis[i] = true;
            if(f(i+1,a,tar,sum+a[i],k,vis,n))return true;
            vis[i] = false;
        }
        return false;
    }
    public boolean isKPartitionPossible(int a[], int n, int k)
    {
	// Your code here	
         int sum = 0;
         for(int i=0;i<n;i++)
         {
             sum+=a[i];
         }
         
         if(sum%k!=0) return false;
         boolean vis[] = new boolean[n]; // to find unique subsets !!!
         Arrays.fill(vis,false);
         
         return f(0,a,sum/k,0,k,vis,n);
    }
}
