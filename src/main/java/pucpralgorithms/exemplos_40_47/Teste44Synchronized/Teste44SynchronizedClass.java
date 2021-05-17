import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

//Exemplo de uso de sincronização de objeto para evitar
//'race conditions' (condições de corrida)
public class Teste44SynchronizedClass {

	public static void main(String[] args) {
		
		MyFrame janela = new MyFrame();
		janela.setTitle("Exemplo de synchronized");
		janela.setSize(500,300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
}

class MyFrame extends JFrame
{
	JLabel t1_status, t2_status, soma_status;
	MyFrame()
	{
		getContentPane().setLayout(new GridLayout(3, 1));
		t1_status = new JLabel();
		t2_status = new JLabel();
		soma_status = new JLabel();
		getContentPane().add(t1_status);
		getContentPane().add(t2_status);
		getContentPane().add(soma_status);
		
		new ThreadControl(this);
		
	}
}




//Classe de controle das threads
class ThreadControl
{
	MyThread m1, m2;
	MyFrame ctrl_frame;
	Somador soma;
	
	
	ThreadControl(MyFrame f)
	{
			ctrl_frame = f;
			
						
			//instancia duas threads da classe MyThread
			m1 = new MyThread( this.ctrl_frame.t1_status, this.ctrl_frame.soma_status, 1);
			m2 = new MyThread( this.ctrl_frame.t2_status, this.ctrl_frame.soma_status, 2);
			
			
			
			m1.start();
			m2.start();
		
			
	}
	
	
}

class Somador
{
	private static int total = 0;
	
	public static int getTotal() { return total; }
	
	public static synchronized void adicionar(int valor)
	{
		/*Aqui é o ponto onde pode ocorrer a condição de 
		corrida (race condition) caso o método não seja sincronizado. 
		Ou seja, antes da variável
		'total' ser atualizada (com a cópia de 'auxiliar'
		é possível que a outra thread atualize 'total' e, 
		nesse caso, quando a execução retornasse para esta
		thread a atualização da outra thread seria perdida*/
		int auxiliar = total;
		auxiliar = auxiliar + valor;
		total = auxiliar;
		
	}
	
	
}

//Classe que implementa a thread
class MyThread extends Thread
{
	JLabel status;
	JLabel soma_status;
	int th_id;
	int valor = 0;
	MyThread(JLabel l, JLabel soma_s, int id)
	{
		status = l;
		th_id = id;
		soma_status = soma_s;
	}
	public void run()
	{
		while (valor < 50000)
		{
				
				int aux = (int)(10*Math.random());
				valor += aux;
				/*try {
					sleep(1);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}*/
				
				//mostra o valor acumulado para esta thread
				status.setText("Thread "+ th_id + ": " + valor);
				
				Somador.adicionar(aux);
				
				//atualiza o valor acumulado de todas as threads
				soma_status.setText("Soma: " + Somador.getTotal());
			
		}
		
		
	}
}
