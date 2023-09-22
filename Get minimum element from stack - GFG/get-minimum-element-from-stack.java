//{ Driver Code Starts
import java.util.*;



class Get_Min_From_Stack
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int q = sc.nextInt();
			GfG g = new GfG();
			while(q>0)
			{
				int qt = sc.nextInt();
				
				if(qt == 1)
				{
					int att = sc.nextInt();
					g.push(att);
					//System.out.println(att);
				}
				else if(qt == 2)
				{
					System.out.print(g.pop()+" ");
				}
				else if(qt == 3)
				{
					System.out.print(g.getMin()+" ");
				}
			
			q--;
			}
			System.out.println();
		T--;
		}
		
	}
}



// } Driver Code Ends


class GfG
{
    long min;
    Stack<Long> s;
    
    // Constructor    
    GfG()
	{
	    s=new Stack<>();
	    min = Long.MAX_VALUE;
	}
	
    /*returns min element from stack*/
    int getMin()
    {
	// Your code here
	if(s.isEmpty())return -1;
	return (int)min;
    }
    
    /*returns poped element from stack*/
    int pop()
    {
        if(s.isEmpty())return -1;
        long val = s.pop();
            if(val<min){
            long prevMin = min;
             min = 2 * min - val;
             return (int) prevMin;
            }
        
        return (int)val;
    }

    /*push element x into the stack*/
    void push(int x)
    {
        Long val = Long.valueOf(x);
        if(s.isEmpty()){
            s.push(val);
            min = val;
        }
        else{
            if(min > val){
                s.push(2*val - min);
                min = val;
            }else{
                s.push(val);
            }
        }
    }	
}


















