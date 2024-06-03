//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
class GFG{
    static void printList(Node node) 
    { 
        while (node != null) 
        { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
        System.out.println(); 
    }
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            Node head = null;
            for(int i=0; i<n; i++)
            {
                int value = sc.nextInt();
                int indicator = sc.nextInt();

                Solution ob = new Solution();
                if(indicator == 0)
                    head = ob.insertAtBeginning(head, value);
                else
                    head = ob.insertAtEnd(head, value);
            }
            printList(head); 
            t--;
        }
    } 
} 

// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
}
*/
class Solution
{
    //Function to insert a node at the beginning of the linked list.
    Node insertAtBeginning(Node head, int x)
    {   
        int len=size(head);
        Node nn= new Node(x);
        if (len==0){
            head=nn;
        }
        else{
            
        nn.next=head;
        head=nn;
        }
        len++;
        return head;
        // code here
    }
    
    //Function to insert a node at the end of the linked list.
    Node insertAtEnd(Node head, int x)
    {
       Node nn = new Node(x);
        if (head == null) {
            return nn;  // If the list is empty, the new node becomes the head
        }
        
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;  // Traverse to the end of the list
        }
        tail.next = nn;  // Set the next of the last node to the new node
        return head;
        // code here
    }
    Node getnode(int k, Node head){
        Node temp=head;
        for(int i=0;i<k;i++){
            temp=temp.next;
        }
        return temp;
    }
    int size(Node head){
        Node temp=head;
        int count=0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        return count;
    }
}