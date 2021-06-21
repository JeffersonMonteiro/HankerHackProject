package pucpralgorithms.exemplos_40_47.Teste47Timer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JLabel;

//Exemplo mostrando o funcionamento de um Timer (definido 
//em javax.swing.Timer)
public class Teste47TimerClass {

	public static void main(String[] args) {
		
		MyFrame janela = new MyFrame();
		janela.setTitle("Exemplo de timer");
		janela.setSize(500,300);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
}


class MyFrame extends JFrame implements ActionListener
{
	JLabel time;
	int time_value = 0;
	MyFrame()
	{
		time = new JLabel("Tempo: " + time_value);
		getContentPane().add(time);
		
		//programa o timer para gerar evento a cada 1000 ms
		Timer t = new Timer(10, this);
		
		t.start();
	}

	
	public void actionPerformed(ActionEvent arg0) {
		
		//incrementa a contagem de tempo (1 s)
		time_value++;
		time.setText("Tempo: " + Integer.toString(time_value/100));
	}
}
