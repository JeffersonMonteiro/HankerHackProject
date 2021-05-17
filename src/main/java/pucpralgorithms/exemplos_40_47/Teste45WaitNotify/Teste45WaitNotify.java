import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

//Exemplo de desbloqueio de objeto utilizando wait
public class Teste45WaitNotify {

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
	JLabel t1_status, t2_status, t3_status, soma_status;
	MyFrame()
	{
		getContentPane().setLayout(new GridLayout(4, 1));
		t1_status = new JLabel();
		t2_status = new JLabel();
		t3_status = new JLabel();
		soma_status = new JLabel();
		getContentPane().add(t1_status);
		getContentPane().add(t2_status);
		getContentPane().add(t3_status);
		getContentPane().add(soma_status);
		
		new ThreadControl(this);
		
	}
}




//Classe de controle das threads
class ThreadControl
{
	MyThread m1, m2, m3;
	MyFrame ctrl_frame;
	Somador soma;
	
	
	ThreadControl(MyFrame f)
	{
			ctrl_frame = f;
			
			soma = new Somador();
			m1 = new MyThread(soma, this.ctrl_frame.t1_status, this.ctrl_frame.soma_status, 1);
			m2 = new MyThread(soma, this.ctrl_frame.t2_status, this.ctrl_frame.soma_status, 2);
			m3 = new MyThread(soma, this.ctrl_frame.t3_status, this.ctrl_frame.soma_status, 3);
			
			
			
			m1.start();
			m2.start();
			m3.start();
		
			
	}
	
	
}

class Somador
{
	int total = 0;
	
	public synchronized void adicionar(int valor, MyThread tid)
	{
		
		//as threads só podem começar a acumular valores quando
		//o total for superior a 120000, com exceção da thread 
		//de identificador 1
		if (tid.th_id != 1)
		{
			
				try {
					if (total < 50000)
					{
						//Espera e libera o bloqueio do objeto somador
						wait();
					}
				} catch (InterruptedException e) {
					
				}
			
		}
		
		int auxiliar = total;
		auxiliar = auxiliar + valor;
		total = auxiliar;
		
		//Agora podemos notificar as demais threads
		//para começarem a acumular
		if (total >= 50000)
		{
			notifyAll();
			
		}
		
	}
	
	
}

//Classe que implementa a thread
class MyThread extends Thread
{
	JLabel status;
	JLabel soma_status;
	Somador soma;
	int th_id;
	int valor = 0;
	MyThread(Somador s, JLabel l, JLabel soma_s, int id)
	{
		status = l;
		th_id = id;
		soma = s;
		soma_status = soma_s;
	}
	
	
	public void run()
	{
		while (valor < 150000)
		{
				
				int aux = (int)(10*Math.random());
				valor += aux;
				try {
					sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				status.setText("Thread "+ th_id + ": " + valor);
				
				soma.adicionar(aux, this);
				
				soma_status.setText("Soma: " + soma.total);
			
		}
		
		
	}
}
