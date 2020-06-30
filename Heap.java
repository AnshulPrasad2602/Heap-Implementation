/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxheaps;



/**
 *
 * @author ANSHUL
 */
public class Heap 
{
    private int[] heap;
    private int size;
    
    public Heap(int capacity)
    {
        heap = new int[capacity];
    }
    
    public void insert(int value)
    {
        if (isFull())
        {
            throw new IndexOutOfBoundsException("Heap is full");
        }
        
        heap[size] = value;
        
        this.fixHeapAbove(size);
        
        size++;
    }
    
    public int peek()
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Heap is Empty");
        }
        
        return heap[0];
    }
    
    public int delete(int index)
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Heap is Empty");
        }
        
        int parent = this.getParent(index);
        int deletedValue = heap[index];
        
        heap[index] = heap[size - 1];
        
        if (index == 0 || heap[index] < heap[parent])
        {
            this.fixHeapBelow(index, size - 1);
        }
        else
        {
            this.fixHeapAbove(index);
        }
        
        size--;
        
        return deletedValue;
    }
    
    public void heapSort()
    {
        if (isEmpty())
        {
            throw new IndexOutOfBoundsException("Heap is Empty");
        }
        
        for (int i = size - 1; i > 0; i--)
        {
            swap(heap, 0, i);
            this.fixHeapBelow(0, i - 1);
        }
    }
    
    private void fixHeapAbove(int index)
    {
        while (index > 0 && heap[index] > heap[getParent(index)])
        {
            swap(heap, index, getParent(index));
            index = getParent(index);
        }
    }
    
    private void fixHeapBelow(int index, int lastHeapIndex)
    {
        int childToSwap;
        
        while (index <= lastHeapIndex)
        {
            int rightChild = this.getRightChild(index);
            int leftChild = this.getLeftChild(index);
            
            if (leftChild <= lastHeapIndex)
            {
                if (rightChild > lastHeapIndex)
                {
                    childToSwap = leftChild;
                }
                else
                {
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }
                
                if (heap[index] < heap[childToSwap])
                {
                    swap(heap, index, childToSwap);
//                    int tmp = heap[index];
//                    heap[index] = heap[childToSwap];
//                    heap[childToSwap] = tmp;
                }
                else
                {
                    break;
                }
                
                index = childToSwap;
            }
            else
            {
                break;
            }
        }
        
//        while (index <= lastHeapIndex)
//        {
//            int rightChild = this.getRightChild(index);
//            int leftChild = this.getLeftChild(index);
//            
//            
//        }
    }
    
    private void swap(int[] heap, int a, int b)
    {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    
    public void printHeap()
    {
        for (int i = 0; i < size; i++)
        {
            System.out.print("" + heap[i] + ", ");
        }
        System.out.println("");
    }
    
    public boolean isFull()
    {
        return size == heap.length;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public int getParent (int index)
    {
        return (index - 1) / 2;
    }
    
    public int getChild(int index, boolean left)
    {
        return 2 * index + (left ? 1 : 2);
    }
    
    public int getLeftChild(int index)
    {
        return 2 * index + 1;
    }
    
    public int getRightChild(int index)
    {
        return 2 * index + 2;
    }
    
    
}
