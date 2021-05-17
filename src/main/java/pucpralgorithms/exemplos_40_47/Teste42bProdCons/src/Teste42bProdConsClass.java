/**
 * 
 * Este exemplo mostra como um produtor e um consumidor 
 * dessincronizados podem levar um repositório a um estado inválido
 *
 */
public class Teste42bProdConsClass {

	
	public static void main(String[] args) {
		
		Repository r = new Repository();
		Consumer c = new Consumer(r);
		Producer p = new Producer(r);
		p.start();
		c.start();
		
	}

}

class Producer extends Thread
{
	private Repository repos;
	public Producer(Repository r)
	{
		repos = r;
	}
	public void run()
	{
		while (true)
		{
			repos.produce();
			System.out.println("Quant: " + repos.getQuant());
			try {
				this.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}

class Consumer extends Thread
{
	private Repository repos;
	public Consumer(Repository r)
	{
		repos = r;
	}
	public  void run()
	{
		while (true)
		{
			repos.consume();
			System.out.println("Quant: " + repos.getQuant());
			try {
				this.sleep((int)(Math.random()*100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}

class Repository
{
	private int quant = 0;
	public int getQuant() { return quant; }
	public synchronized void produce()
	{
		
		quant++;
		/**
		 * caso a quantidade do repositório seja maior do que 0, 
		 * é hora de notificar qualquer thread consumidora que
		 * esteja aguardando
		 */
		if (quant > 0)
		{
			notifyAll();
		}
	}
	public synchronized void consume()
	{
		/**
		 * se a quantidade é igual a 0, o consumidor deve aguardar
		 * até poder consumir um item
		 */
		if (quant == 0)
			try {
				System.out.println("Dormi...");
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		quant--;
	}
	
}
