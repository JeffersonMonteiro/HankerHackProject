package pucpralgorithms.exemplos_32_39.Teste34FileStream;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Exemplo utilizando objetos FileWriter e FileReader para escrever/ler
//arquivos no modo texto 
public class Teste34FileStreamClass {

	public static void main(String[] args) {
		
		MyFrame f = new MyFrame();
		f.setTitle("Teste de fluxo de arquivo");
		f.setSize(500,300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

class MyFrame extends JFrame
{
	
	JButton bRead;
	JButton bWrite;
	JTextField tfText;
	MyFrame()
	{
		
		getContentPane().setLayout(new BorderLayout());
		JPanel p = new JPanel();
		bRead = new JButton("Ler");
		bWrite = new JButton("Escrever");
		p.add(bRead);
		p.add(bWrite);
		tfText = new JTextField();
		getContentPane().add(tfText, BorderLayout.NORTH);
		getContentPane().add(p, BorderLayout.SOUTH);
		MyListener ml = new MyListener(this);
		bRead.addActionListener(ml);
		bWrite.addActionListener(ml);
		
		
	}
	
}

class MyListener implements ActionListener
{
	MyFrame fFrame;
	MyListener(MyFrame f)
	{
		fFrame = f;
	}
	public void actionPerformed(ActionEvent arg0) {
		
		if ((JButton)arg0.getSource() == fFrame.bRead)
		{
			try {
				//cria um fluxo de leitura e associa a um arquivo
				FileReader fr = new FileReader("data.dat");
				int data;
				
				//faz a leitura do arquivo. O tipo de retorno � int
				//para permitir a verifica��o do fim de arquivo (-1)
				while ((data = fr.read()) != -1)
				{
					fFrame.tfText.setText(fFrame.tfText.getText() + (char)data);
					
				}
				
				fr.close();
				
			} catch (FileNotFoundException e) {
				
				JOptionPane.showMessageDialog(fFrame, "Arquivo n�o existe", "Erro", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(fFrame, "Arquivo n�o existe", "Erro", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if ((JButton)arg0.getSource() == fFrame.bWrite)
		{
			try {
				//cria um fluxo de escrita e o associa a um arquivo
				FileWriter fw = new FileWriter("data.dat");
				
				//para criar um fluxo Unicode...
				//OutputStreamWriter ow = new OutputStreamWriter(new FileOutputStream("data.dat"), "Unicode");
				
				fw.write(fFrame.tfText.getText());
				
				fw.close();
				
			} catch (FileNotFoundException e) {
				
				JOptionPane.showMessageDialog(fFrame, "Arquivo n�o pode ser escrito", "Erro", 
						JOptionPane.INFORMATION_MESSAGE);
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(fFrame, "Arquivo n�o pode ser escrito", "Erro", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
}
