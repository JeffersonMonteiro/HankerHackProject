public class ExThread2
{
	public static void main (String [] args)
	{
		//criar uma thread a partir da classe MinhaThread2
		Thread mt2 = new Thread(new MinhaThread2());
		
		//aqui habilita a thread para começar a executar
		mt2.start();
		
		for (int i = 0; i < 30; i++)
		{
			System.out.println("No main: " + i);	
			
		}
		
		System.out.println("Terminou o main...");
	
	}


}
class MinhaThread2 implements Runnable
{
	//Este método é obrigatório porque define o ponto de entrada da thread
	public void run()
	{		
		for (int i = 0; i < 300; i++)
		{
			System.out.println("" + i);	
			
			
		}
	}//se chegar aqui a thread é finalizada

}