public class ExThread1
{
	public static void main (String [] args)
	{
		//criar uma thread a partir da classe MinhaThread1
		MinhaThread1 mt1 = new MinhaThread1();
		
		//aqui habilita a thread para come�ar a executar
		mt1.start();
		
		for (int i = 0; i < 30; i++)
		{
			System.out.println("No main: " + i);	
			
		}
		
		System.out.println("Terminou o main...");
	
	}


}
class MinhaThread1 extends Thread
{
	//Este m�todo � obrigat�rio porque define o ponto de entrada da thread
	public void run()
	{		
		for (int i = 0; i < 300; i++)
		{
			System.out.println("" + i);	
			
		}
	}//se chegar aqui a thread � finalizada

}