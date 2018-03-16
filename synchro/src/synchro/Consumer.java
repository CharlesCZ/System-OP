/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchro;



public class Consumer implements Runnable {

	private static final long DEFAULT_DELAY = 50;
	private final Producer producer;
	private final String name;
	private int messageCount = 0;

        
        
        
        
	public Consumer(String nazwa, Producer producent) {
		this.producer = producent;
		this.name = nazwa;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Gnp msg = producer.getMessage();
				if (msg != null) {
                                    
                                    show_graph(msg);
					System.out.println(name + " obliczone krawedzie: " +countEdges(msg));
					messageCount++;
				} else {
					System.err.println("Failed to receive a message!");
				}
				Thread.sleep(DEFAULT_DELAY);
			} catch (InterruptedException e) {
				System.out.println(name + " interrupted!");
				return;
			}
		}
	}

	public int getMessageCount() { return messageCount; }


synchronized int countEdges(Gnp ob) {
int i,j,k=0;
 for (i=0;i<ob.n-1; i++)
	 for (j=i+1;j<ob.n;j++) 
		 if (ob.A[i][j]) k++;
 return k;
}
synchronized void show_graph(Gnp ob){
for (int i = 0; i < ob.n; i++)
	{
		System.out.println();
		for (int j = 0; j < ob.n; j++)
			System.out.print( ( ( ob.A[i][j])?1:0 )  + " ");
	}
        System.out.println();
}
}
