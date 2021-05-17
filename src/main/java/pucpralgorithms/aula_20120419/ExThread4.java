public class ExThread4
{
	public static void main (String [] args)
	{
		//criar uma thread a partir da classe MinhaThread3
		MinhaThread4 mt4 = new MinhaThread4();
		
		//aqui habilita a thread para começar a executar
		mt4.start();
		
		for (int i = 0; i < 500; i++)
		{
			System.out.println("No main: " + i);	
			if (i % 10 == 0)
			{
				try
				{
					//dorme por 50 ms
					Thread.sleep(50);
				}
				catch (InterruptedException e)
				{
					//aqui implementaria o código que é executado caso esta thread seja interrompida enquanto está em "timed waiting" (dormindo)
				}
			}
			
		}
		
		System.out.println("Terminou o main...");
	
	}


}
class MinhaThread4 extends Thread
{
	//Este método é obrigatório porque define o ponto de entrada da thread
	public void run()
	{		
		for (int i = 0; i < 300; i++)
		{
			System.out.println("" + i);	
			if (i % 10 == 0)
			{
				try
				{
					//dorme por 50 ms
					sleep(50);
				}
				catch (InterruptedException e)
				{
				}
			}
			
		}
	}//se chegar aqui a thread é finalizada

}