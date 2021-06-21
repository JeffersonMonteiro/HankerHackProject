package pucpralgorithms.exemplos_40_47.Teste41Runnable;

//Exemplo de cria��o de thread atrav�s de objeto que
//implementa a interface Runnable
public class Teste41RunnableClass {

	public static void main(String[] args) {
		
		//Neste caso deve-se instanciar um objeto da classe Thread
		//e passar o objeto que implementa Runnable como par�metro
		Thread t1 = new Thread(new Counter(1));
		Thread t2 = new Thread(new Counter(2));
		
		t1.start();
		t2.start();
		
		
	}
}

class Counter implements Runnable
{

	int counter = 0;
	int thread_id;
	
	Counter (int id)
	{
		thread_id = id;
	}
	public void run() {
		
		while (counter < 1000)
		{
			//Em qualquer ponto a thread pode ser preemptada
			//para execu��o de outra thread ativa
			counter++;
			System.out.println("Thread " + thread_id + " com valor " + counter);
		}
		
	}
	
	
}
