//Exemplo de uso de exceções para validar um campo numérico

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;


public class Teste32ExceptionsClass {

	public static void main(String[] args) {
		
		JFrame janela = new MyFrame();
		janela.setSize(500,300);
		janela.setTitle("Teste de exceção");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
}

class MyException extends Exception
{

}


class MyFrame extends JFrame
{
	
	JTextField tf;
	JLabel status;
	MyFrame()
	{
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(1,2));
		 tf = new JTextField("");
		JLabel l = new JLabel("Digite um número NÃO MAIOR QUE 100");
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(p, BorderLayout.NORTH);
		p.add(l);
		p.add(tf);
		status = new JLabel("...");
		getContentPane().add(status, BorderLayout.SOUTH);
		tf.getDocument().addDocumentListener(new OuvinteDeDocumento(tf, status));
		
	}

	
	
	
	
}

/*
 * Implementar a interface DocumentListener permite a esta classe
 * redefinir alguns dos métodos que são utilizados na validação/verificação
 * do conteúdo do objeto que utiliza este documento (no exemplo, uma caixa
 * de texto do frame).
 */
class OuvinteDeDocumento implements DocumentListener
{
		private double valor;
		private JTextField text;
		private JLabel status;
		public OuvinteDeDocumento(JTextField t, JLabel s)
		{
			status = s;
			text = t;
		}
		public void insertUpdate(DocumentEvent arg0) {
		
		
			try
			{
				//o método validaNumero() pode lançar a exceção
				valor = validaNumero();
				status.setText("OK");
				
				
			}
			catch (Exception e)
			{
				//O operador instanceof verifica se o objeto
				//é de determinada classe
				if (e instanceof NumberFormatException)
				{
					status.setText("Número não conversível");
					
				}
				else
				{
					status.setText("Número inválido (maior do que 100)!");
				}
			}
		
		
		}
		public void removeUpdate(DocumentEvent arg0) {
		
			try
			{
				valor = validaNumero();
				status.setText("OK");
				
				
			}
			catch (Exception e)
			{
				if (e instanceof NumberFormatException)
				{
					status.setText("Número não conversível");
					
				}
				else
				{
					status.setText("Número inválido!");
				}
			}
		
		}

		public void changedUpdate(DocumentEvent arg0) {
			
			try
			{
				valor = validaNumero();
				status.setText("OK");
				
				
			}
			catch (Exception e)
			{
				if (e instanceof NumberFormatException)
				{
					status.setText("Número não conversível");
					
				}
				else
				{
					status.setText("Número inválido!");
				}
			}
			
		}
	
		//Este método anuncia que pode lançar a exceção NumberFormatException
		double validaNumero() throws MyException
		{
			double num = Double.parseDouble(text.getText());
			
			if (num > 100.0)
			{
				//instancia e lança a exceção
				throw new MyException();
			}
			
			return num;
			
			
		}
	
}
