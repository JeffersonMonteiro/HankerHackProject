/*
 * Este exemplo mostra um conjunto de threads competindo por uma trava (lock)
 */
import java.util.concurrent.locks.ReentrantLock;


public class Teste47bLockClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ReentrantLock lock = new ReentrantLock();
		Testador [] pool = new Testador[10];
		for (int i = 0; i < 10; i++)
		{
			pool[i] = new Testador(lock, i);
			pool[i].start();
		}

	}

}

class Testador extends Thread
{
	private java.util.concurrent.locks.ReentrantLock lock;
	private int numero;
	public Testador(ReentrantLock lock, int numero)
	{
		this.lock = lock;
		this.numero = numero;
	}
	public void run()
	{
		while (true)
		{
			if (lock.tryLock())
			{
				System.out.println("Thread " + numero + " adquiriu a trava");
				try {
					sleep((int)(Math.random()*3000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				System.out.println("Thread " + numero + 
						" prestes a bloquear");
				lock.lock();
				System.out.println("Thread " + numero + 
						" acordou com a trava");
			}
			
			System.out.println("Número de threads bloqueadas é " + 
					lock.getQueueLength());
			//verifica se essa thread é a dona da trava
			if (lock.isHeldByCurrentThread())
			{
				System.out.println("Thread " + numero + " liberando a trava...");
				lock.unlock();
				try {
					sleep((int)(Math.random()*1000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
