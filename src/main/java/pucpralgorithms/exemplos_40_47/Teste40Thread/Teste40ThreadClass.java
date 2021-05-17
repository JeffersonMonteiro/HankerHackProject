//Exemplo de criação e execução de threads em Java
public class Teste40ThreadClass {

	public static void main(String[] args) {
		
		//Aqui instancia-se e inicia-se duas threads a partir de objetos da
		//classe Counter, que estende a classe java.lang.Thread
		(new Counter(1)).start();
		(new Counter(2)).start();
	}
}


class Counter extends Thread
{
	int counter = 0;
	int thread_id;
	
	Counter (int id)
	{
		thread_id = id;
		//this.setPriority((id == 1)? MAX_PRIORITY: NORM_PRIORITY);
	}
	
	//O método run() é executado quando a thread é iniciada 
	public void run()
	{
		while (counter < 100)
		{
			//Em qualquer ponto a thread pode ser preemptada
			//para execução de outra thread ativa
			counter++;
			System.out.println("Thread " + thread_id + " com valor " + counter);
			//yield();
			try {
				sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	
	}
	
	
}
