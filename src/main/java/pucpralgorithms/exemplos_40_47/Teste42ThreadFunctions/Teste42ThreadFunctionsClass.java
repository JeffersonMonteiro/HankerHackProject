package pucpralgorithms.exemplos_40_47.Teste42ThreadFunctions;//Exemplo com uso de sleep para ajustar a taxa de atualiza��o
//dos contadores
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Teste42ThreadFunctionsClass {

	public static void main(String[] args) {
		
		MyFrame janela = new MyFrame();
		janela.setTitle("Teste de sleep");
		janela.setSize(500,300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
}


class MyFrame extends JFrame
{
	JLabel t1_status;
	JLabel t2_status;
	
	JLabel t1_sleep;
	JLabel t2_sleep;
	JButton t1_up;
	JButton t1_down;
	JButton t2_up;
	JButton t2_down;
	
	MyFrame()
	{
		ThreadControl tc = new ThreadControl(this);
		
		Container c = getContentPane();
		JPanel t1_panel = new JPanel();
		JPanel t2_panel = new JPanel();
		c.setLayout(new GridLayout(2,1));
		c.add(t1_panel);
		c.add(t2_panel);
		JPanel t1_status_panel = new JPanel();
		JPanel t2_status_panel = new JPanel();
		JPanel t1_op_panel = new JPanel();
		JPanel t2_op_panel = new JPanel();
		t1_panel.setLayout(new GridLayout(2,1));
		t2_panel.setLayout(new GridLayout(2,1));
		t1_panel.add(t1_status_panel);
		t1_panel.add(t1_op_panel);
		t2_panel.add(t2_status_panel);
		t2_panel.add(t2_op_panel);
		
		t1_status = new JLabel("Thread 1: ");
		t2_status = new JLabel("Thread 2: ");
		t1_status_panel.add(t1_status);
		t2_status_panel.add(t2_status);
		t1_op_panel.add(new JLabel("Sleep: "));
		t2_op_panel.add(new JLabel("Sleep: "));
		
		t1_sleep = new JLabel("10");
		t2_sleep = new JLabel("10");
		t1_op_panel.add(t1_sleep);
		t2_op_panel.add(t2_sleep);
		
		t1_up = new JButton("+");
		t1_down = new JButton("-");
		t1_op_panel.add(t1_up);
		t1_op_panel.add(t1_down);
		
		t2_up = new JButton("+");
		t2_down = new JButton("-");
		t2_op_panel.add(t2_up);
		t2_op_panel.add(t2_down);
		
		
		
		t1_up.addActionListener(tc);
		t1_down.addActionListener(tc);
		
		t2_up.addActionListener(tc);
		t2_down.addActionListener(tc);
		
		tc.start();
				
		
	}
	
	

}

//ThreadControl tem como objetivo servir de ouvinte
//dos eventos de bot�o e controle das threads envolvidas
class ThreadControl implements ActionListener
{

	MyFrame ctrl_frame;
	Counter c1;
	Counter c2;
	
	
	ThreadControl(MyFrame mf)
	{
		ctrl_frame = mf;
		
		c1 = new Counter(1, mf);
		c2 = new Counter(2, mf);
		c1.setSleepTime(10);
		c2.setSleepTime(10);
		c1.setPriority(2);
		c2.setPriority(7);
		
		
		
	}
	
	//Esse m�todo � chamado para iniciar as threads
	//de contagem
	public void start()
	{
		c1.start();
		c2.start();
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		
		
		if ((JButton)arg0.getSource() == ctrl_frame.t1_up)
		{
			c1.setSleepTime(c1.getSleepTime() + 10);
			ctrl_frame.t1_sleep.setText(Integer.toString(c1.getSleepTime()));
			
		}
		if ((JButton)arg0.getSource() == ctrl_frame.t1_down)
		{
			c1.setSleepTime(c1.getSleepTime() - 10);
			ctrl_frame.t1_sleep.setText(Integer.toString(c1.getSleepTime()));
			
		}
		if ((JButton)arg0.getSource() == ctrl_frame.t2_up)
		{
			c2.setSleepTime(c2.getSleepTime() + 10);
			ctrl_frame.t2_sleep.setText(Integer.toString(c2.getSleepTime()));
			
		}
		if ((JButton)arg0.getSource() == ctrl_frame.t2_down)
		{
			c2.setSleepTime(c2.getSleepTime() - 10);
			ctrl_frame.t2_sleep.setText(Integer.toString(c2.getSleepTime()));
			
		}
		
		if (c1.getCounterValue() > 10000)
		{
			//interrompe o funcionamento da thread
			c1.interrupt();
		
		}
		
		if (c2.getCounterValue() > 10000)
		{
			//interrompe o funcionamento da thread
			c2.interrupt();
		
		}
		
	}

	
	
	
	
}

//Classe que implementa as threads de contagem
class Counter extends Thread
{
	int counter = 0;
	int thread_id;
	int sleep_time;
	MyFrame ctrl_frame;
	
	Counter (int id, MyFrame mf)
	{
		thread_id = id;
		ctrl_frame = mf;
	}
	
//	atualiza o tempo de espera desta thread
	public  void  setSleepTime(int st)
	{
		if (st >= 0)
			sleep_time = st;
		
	}
	
	public int getCounterValue()  { return counter; }
	
	public  int getSleepTime() { return sleep_time; }
	
	//O m�todo run() � executado quando a thread � iniciada 
	public void run()
	{
		while (true)
		{
			//Em qualquer ponto a thread pode ser preemptada
			//para execu��o de outra thread ativa
			counter++;
			if (thread_id == 1)
			{
				ctrl_frame.t1_status.setText("Thread 1: " + Integer.toString(counter));
			}
			else
			{
				ctrl_frame.t2_status.setText("Thread 2: " + Integer.toString(counter));
			}
			
			try {
				
			
					sleep(sleep_time);
			} catch (InterruptedException e) {
				
				System.out.println("Interrompida: " + ((thread_id == 1)? 1: 2));
				return;
				//System.exit(0);
			}
		}
		
	
	}
	
}