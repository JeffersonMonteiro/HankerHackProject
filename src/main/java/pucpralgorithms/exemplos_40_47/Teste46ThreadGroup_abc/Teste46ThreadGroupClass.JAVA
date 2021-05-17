import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Exemplo de uso de grupos de threads
public class Teste46ThreadGroupClass {

	public static void main(String[] args) {
		
		MyFrame janela = new MyFrame();
		janela.setTitle("Exemplo de grupos de threads");
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
		getContentPane().setLayout(new GridLayout(5, 1));
		t1_status = new JLabel();
		t2_status = new JLabel();
		t3_status = new JLabel();
		soma_status = new JLabel();
		JButton b = new JButton("Interromper");
		getContentPane().add(t1_status);
		getContentPane().add(t2_status);
		getContentPane().add(t3_status);
		getContentPane().add(soma_status);
		getContentPane().add(b);
		
		b.addActionListener(new ThreadControl(this));
		
	}
}




//Classe de controle das threads
class ThreadControl implements ActionListener
{
	MyThread m1, m2, m3;
	MyFrame ctrl_frame;
	Somador soma;
	ThreadGroup tg;
	
	
	ThreadControl(MyFrame f)
	{
			ctrl_frame = f;
			
			tg = new ThreadGroup("Grupo");
			
			soma = new Somador();
			
			//adiciona todas as threads ao grupo 'tg'
			m1 = new MyThread(tg, soma, this.ctrl_frame.t1_status, this.ctrl_frame.soma_status, 1);
			m2 = new MyThread(tg, soma, this.ctrl_frame.t2_status, this.ctrl_frame.soma_status, 2);
			m3 = new MyThread(tg, soma, this.ctrl_frame.t3_status, this.ctrl_frame.soma_status, 3);
			
			
			
			m1.start();
			m2.start();
			m3.start();
		
			
	}


	
	public void actionPerformed(ActionEvent arg0) {
		
		//Interrompe todas as threads do grupo, exceto aquelas bloqueadas
		tg.interrupt();
	}
	
	
}

class Somador
{
	int total = 0;
	
	public synchronized void adicionar(int valor, MyThread tid)
		throws InterruptedException
	{
		
		//as threads só podem começar a acumular valores quando
		//o total for superior a 20000, com exceção da thread 
		//de identificador 1
		if (tid.th_id != 1)
		{
			
					//Se a thread for interrompida aqui, a exceção é
					//lançada e capturada no corpo do método run()
					if (total < 20000)
					{
						//Espera e libera o bloqueio do objeto somador
						wait();
					}
				
			
		}
		
		int auxiliar = total;
		auxiliar = auxiliar + valor;
		total = auxiliar;
		
		//Agora podemos notificar as demais threads
		//para começarem a acumular
		if (total >= 20000)
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
	MyThread(ThreadGroup tg, Somador s, JLabel l, JLabel soma_s, int id)
	{
		//Chama a construtora de Thread que a associa
		//a um grupo
		super(tg, "T"+id);
		status = l;
		th_id = id;
		soma = s;
		soma_status = soma_s;
	}
	
	
	public void run()
	{
		
			try
			{
				while (valor < 150000)
				{
					int aux = (int)(10*Math.random());
					valor += aux;
					sleep(1);
					status.setText("Thread "+ th_id + ": " + valor);
					soma.adicionar(aux, this);
					soma_status.setText("Soma: " + soma.total);
				}
			}
			catch (InterruptedException e)
			{
				status.setText("Terminada");
			}
				
			
		
		
		
		
		
	}
}
