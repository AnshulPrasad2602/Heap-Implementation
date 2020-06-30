/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package priorityqueuejdk;

import java.util.PriorityQueue;

/**
 *
 * @author ANSHUL
 */
public class PriorityQueueJDK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);
        
        System.out.println("Peek -> " + pq.peek()); //min heap so lower the no higher the priority
        
        System.out.println("Remove -> " + pq.remove());
        System.out.println("Peek -> " + pq.peek());
        System.out.println("Poll -> " + pq.poll()); //poll and remove are same thing removes highest proiority element
        System.out.println("Remove -> " + pq.remove(54));
        
        pq.add(-99);
        System.out.println("Peek -> " + pq.peek());
        
        Object[] ints = pq.toArray();
        for (Object num: ints) 
        {
            System.out.println(num);
        }
    }
    
}
