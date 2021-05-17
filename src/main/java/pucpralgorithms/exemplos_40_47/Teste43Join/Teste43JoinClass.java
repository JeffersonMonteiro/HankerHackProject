import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

//Exemplo de uso de join para sincronizar threads
public class Teste43JoinClass {

	public static void main(String[] args) {
		
		MyFrame janela = new MyFrame();
		janela.setTitle("Exemplo de join");
		janela.setSize(500,300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
}

class MyFrame extends JFrame
{
	
	JLabel t1_status;
	JLabel t2_status;
	JLabel t3_status;
	
	MyFrame()
	{
		getContentPane().setLayout(new GridLayout(3, 1));
		t1_status = new JLabel();
		t2_status = new JLabel();
		t3_status = new JLabel();
		getContentPane().add(t1_status);
		getContentPane().add(t2_status);
		getContentPane().add(t3_status);
		
		new ThreadControl(this);
	
		
	}
	
	
}

//Classe de controle das threads
class ThreadControl
{
	MyThread m1, m2, m3;
	MyFrame ctrl_frame;
	
	
	ThreadControl(MyFrame f)
	{
			ctrl_frame = f;
			m1 = new MyThread(this, this.ctrl_frame.t1_status, 1);
			m2 = new MyThread(this, this.ctrl_frame.t2_status, 2);
			m3 = new MyThread(this, this.ctrl_frame.t3_status, 3);
			
			m1.start();
			m2.start();
			m3.start();
			
	}
	
	
}


//Classe que implementa a thread
class MyThread extends Thread
{
	JLabel status;
	ThreadControl th_ctrl;
	int th_id;
	int counter = 0;
	MyThread(ThreadControl tc, JLabel l, int id)
	{
		status = l;
		th_id = id;
		th_ctrl = tc;
	}
	public void run()
	{
		while (counter < 500)
		{
			counter++;
			try {
				
				//Taxa de atualização do contador é inversamente
				//proporcional ao 'id' da thread
				sleep(th_id*20);
				status.setText("Thread "+ th_id + ": " + counter);
				
				
			} catch (InterruptedException e) {
				return;
			}
			
		}
		
		//A thread 2 espera pelo término da thread 3, embora
		//a thread 2 termine a sua contagem antes
		if (th_id == 2)
		{
			try {
				status.setText("Aguardando...");
				th_ctrl.m3.join();
			} catch (InterruptedException e) {
				return;
			}
		}
		
		status.setText("Completada!");
	}
}
