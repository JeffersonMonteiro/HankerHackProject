import java.util.concurrent.*;


public class Teste47cThreadPoolClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int counter = 0;
		ExecutorService pool;
		//cria um pool com 5 threads
		pool = Executors.newFixedThreadPool(5);
		
		int i = 0;
		while (i < 20)
		{
			try
			{
				//alocar uma thread livre para executar
				//uma nova tarefa
				pool.execute(new Testador(counter));
				//(new Thread(new Testador(counter))).start();
				System.out.println("Thread criada " + counter);
				counter++;
				
				Thread.sleep((int)(Math.random()*10));
				
				i++;
				
			}
			catch(RejectedExecutionException e)
			{
				System.out.println("Erro ao criar outras threads");
			}
			catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			
			
		}
		
		//finaliza o pool (antes termina todas as threads que foram criadas)
		pool.shutdown();

	}

}

class Testador implements Runnable
{
	private int numero;
	public Testador(int numero)
	{
		this.numero = numero;
	}
	public void run() {
		System.out.println("Thread ativada " + numero);
		try {
			Thread.sleep((int)(Math.random()*6000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread finalizada " + numero);
		
	}
	
	
}
