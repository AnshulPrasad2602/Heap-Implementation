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
public class MaxHeaps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();
        
        System.out.println("Peek - > " + heap.peek());

        heap.delete(0);
        heap.printHeap();
        
        System.out.println("Peek - > " + heap.peek());
        
        heap.heapSort();
        
        heap.printHeap();

    }
    
}
