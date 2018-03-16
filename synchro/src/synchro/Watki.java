/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchro;

import java.util.Scanner;

/**
 *
 * @author Cezary
 */
public class Watki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
      /*   Scanner in=new Scanner(System.in);
         int n=in.nextInt(); //"podaj liczbe wierzcholkow";
	//"podaj prawdopodobienstwo p";
	float p;
	p=in.nextFloat();
     
	Gnp ob=new Gnp(n,p);
	
	for (int i = 0; i < n; i++)
	{
		System.out.println();
		for (int j = 0; j < n; j++)
			System.out.print( ( ( ob.A[i][j])?1:0 )  + " ");
	}
        System.out.println();*/
        
        
        
		Producer producer = new Producer();
            
		Consumer consumer1 = new Consumer("Consumer 1 ", producer);
		Consumer consumer2 = new Consumer("Consumer 2 ", producer);
               
		Thread p = new Thread(producer);
              
		Thread c1 = new Thread(consumer1);
		Thread c2 = new Thread(consumer2);
               
		p.start();            
		c1.start();
		c2.start();            
		/*Thread.sleep(3000);
		//p.interrupt();
		p.join();
		System.out.println("\nProduced " + producer.getMessageCount()
				  + " messages.");

		Thread.sleep(500);
		//c1.interrupt();
		//c2.interrupt();
		c1.join();
		c2.join();
              
		System.out.println("\nConsumed " + (consumer1.getMessageCount()
				  + consumer2.getMessageCount()) + " messages.");
                */
                    Producer producer2 = new Producer();
                 Consumer consumer3 = new Consumer("Consumer 3 ", producer2);
                   Thread p2 = new Thread(producer2);
                   Thread c3 = new Thread(consumer3);
                       p2.start();
                       c3.start();
p2.join();
c3.join();
		System.out.println("\nMain thread stopped.");
	
    
    
        
        
        
    }
    
}
