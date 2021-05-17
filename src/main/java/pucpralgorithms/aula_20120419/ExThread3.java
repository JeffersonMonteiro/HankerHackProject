public class ExThread3
{
	public static void main (String [] args)
	{
		//criar uma thread a partir da classe MinhaThread3
		MinhaThread3 mt3 = new MinhaThread3();
		
		//aqui habilita a thread para começar a executar
		mt3.start();
		
		for (int i = 0; i < 500; i++)
		{
			System.out.println("No main: " + i);	
			if (i % 10 == 0)
			{
				//libera o processador
				Thread.yield();	
			}
			
		}
		
		System.out.println("Terminou o main...");
	
	}


}
class MinhaThread3 extends Thread
{
	//Este método é obrigatório porque define o ponto de entrada da thread
	public void run()
	{		
		for (int i = 0; i < 300; i++)
		{
			System.out.println("" + i);	
			if (i % 10 == 0)
			{
				//libera o processador
				yield();	
			}
			
		}
	}//se chegar aqui a thread é finalizada

}