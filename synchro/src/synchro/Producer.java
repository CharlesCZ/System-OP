/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package synchro;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Cezary
 */
public class Producer implements Runnable {

	private static final int MAX_QUEUE = 5;
	private static final long DEFAULT_DELAY = 10;
	private final Queue<Gnp> messages = new LinkedList<>();
	private int messageCount = 0;
	
	@Override
	public void run() {
		while (true) {
			try {
				putMessage();
				messageCount++;
				Thread.sleep(DEFAULT_DELAY);
			} catch (InterruptedException e) {
				System.out.println("Producer interrupted!");
				return;
			}
		}
	}

	public int getMessageCount() { return messageCount; }

	private synchronized void putMessage() throws InterruptedException {
		while (messages.size() >= MAX_QUEUE) {
                    wait();
			
		}
                
		messages.add(new Gnp(4,0.6f));
                notify();
	}

	public synchronized Gnp getMessage() throws InterruptedException {
		// FIXME: non thread-safe method
		while (messages.isEmpty()) {
                    wait();
			
		}
                notify();
		return messages.poll();
                
	}
}
