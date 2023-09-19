//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;

class Node {
    int data;
    Node next;
    Node(int key) {
        data = key;
        next = null;
    }
}

class Partition {
    static Node head;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.partition(head, k);
            printList(res);
            System.out.println();
        }
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
    public static Node partition(Node head, int x) {
        // Your code here
    Node smallerHead = new Node(-1);
Node smaller = smallerHead;

Node equalHead = new Node(-1);
Node equal = equalHead;

Node greaterHead = new Node(-1);
Node greater = greaterHead;

Node curr = head;
while (curr != null) {
    if (curr.data < x) {
        smaller.next = curr;
        smaller = smaller.next;
    } else if (curr.data == x) {
        equal.next = curr;
        equal = equal.next;
    } else {
        greater.next = curr;
        greater = greater.next;
    }
    curr = curr.next;
}

// Connect the three partitions
equal.next = greaterHead.next;
smaller.next = equalHead.next;
greater.next = null;

return smallerHead.next;
}
}