import java.util.*;
import java.io.*;
class MAX_HEAP_CONSTRUCTION
{
  //First three lines are initialization of the required things.........
    private int[] MAX_HEAP; 
    private int size;
    private int MAX_SIZE;
    //Constructor required to initialize the above declared variables.......
    public MAX_HEAP_CONSTRUCTION(int MAX_SIZE)
    {
        this.MAX_SIZE=MAX_SIZE;
        this.size=0;
        MAX_HEAP=new int [this.MAX_SIZE+1];
        MAX_HEAP[0]=Integer.MAX_VALUE;
    }
    //Method used to return the index of parent node of the max heap........
    private int PARENT(int position)
    {
        return (position)/2;
    }
    //Method used to return the index of left child of the max heap..........
    private int LEFT_CHILD(int position)
    {
        return (2 * position );
    }
    //Method dused to return the index of right child of the max heap........
    private int RIGHT_CHILD(int position)
    {
        return ( (2 * position ) + 1 );
    }
    //Method that returns true or fasle depending upon whether or not the node is leaf.......
    private boolean IS_LEAF(int position)
    {
        if(position >= (size/2) && position <= size)
        {
            return true;
        }
        return false;
    }
    //Swap emthods used to swap nodes with first position and second position indexes values........
    private void SWAP(int F_POS , int S_POS)
    {
        int temp;
        temp=MAX_HEAP[F_POS];
        MAX_HEAP[F_POS]=MAX_HEAP[S_POS];
        MAX_HEAP[S_POS]=temp;
    }
    /* Methods that checks whether the tree is max heapify or not, by using the assumption 
    that the left and right subtrees are already heapified, so only fixing the root only........ 
    */
    private void MAX_HEAPIFY(int position)
    {
        if(IS_LEAF(position))
        {
            return ;
        }
        if (( MAX_HEAP[position]< MAX_HEAP[LEFT_CHILD(position)]) || (MAX_HEAP[position]< MAX_HEAP[RIGHT_CHILD(position)]))
        {
            if(MAX_HEAP[LEFT_CHILD(position)] > MAX_HEAP[RIGHT_CHILD(position)])
            {
                SWAP(position, LEFT_CHILD(position));
                MAX_HEAPIFY(LEFT_CHILD(position));
            }
            else
            {
                SWAP(position, RIGHT_CHILD(position));
                MAX_HEAPIFY(RIGHT_CHILD(position));
            }
        }
    }
    //Method to isnert elements in the max heap from bottom to up..........
    public void INSERT(int element)
    {
        MAX_HEAP[++size]=element;
        int current=size;
        while(MAX_HEAP[current]> MAX_HEAP[PARENT(current)])
        {
            SWAP(current, PARENT(current));
            current=PARENT(current);
        }
    }
    //Method to print max heap........
    public void PRINT_MAX_HEAP()
    {
        for(int i=1 ; i < size/2 ; i++)
        {
            System.out.print("PARENT : "+MAX_HEAP[i] + " -> LEFT CHILD : "+MAX_HEAP[ 2 * i]+ " -> RIGHT CHILD : "+MAX_HEAP[2 * i + 1] );
        System.out.println();
        }
    }
    //Method to remove an element from map heap........
    public int EXTRACT_MAX()
    {
        int pop=MAX_HEAP[1];
        MAX_HEAP[1]=MAX_HEAP[size--];
        MAX_HEAPIFY(1);
        return pop;
    }
    public static void main(String [] args)
    {
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        MAX_HEAP_CONSTRUCTION max=new MAX_HEAP_CONSTRUCTION(20);
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            max.INSERT(arr[i]);
        }
        System.out.println("The Max Heap is ");
        max.PRINT_MAX_HEAP();
        System.out.println("MAX VALUE IS : "+max.EXTRACT_MAX());

    }
}