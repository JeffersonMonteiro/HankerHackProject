package pucpralgorithms.exemplos_32_39.Teste33Finally;//Exemplo de uso de finally

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Teste33FinallyClass {

	public static void main(String[] args) {
		JFrame janela = new MyFrame();
		janela.setSize(500,300);
		janela.setTitle("Teste de finally");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
}

//Defini��o da classe de exce��o de valor inv�lido
class ValueException extends Exception
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
		JLabel l = new JLabel("Digite um n�mero N�O MAIOR QUE 100");
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
 * redefinir alguns dos m�todos que s�o utilizados na valida��o/verifica��o
 * do conte�do do objeto que utiliza este documento (no exemplo, uma caixa
 * de texto do frame).
 */
class OuvinteDeDocumento implements DocumentListener
{
		private double valor;
		private JTextField text;
		private JLabel status;
		public OuvinteDeDocumento(JTextField t, JLabel s)
		{
			text = t;
			status = s;
		}
		public void insertUpdate(DocumentEvent arg0) {
		
		
			try
			{
				//o m�todo validaNumero() pode lan�ar a exce��o
				valor = validaNumero();
				status.setText("OK");
				
				
			}
			catch (Exception e)
			{
				//O operador instanceof verifica se o objeto
				//� de determinada classe
				if (e instanceof NumberFormatException)
				{
					status.setText("N�mero n�o convers�vel");
					
				}
				else
				{
					status.setText("N�mero inv�lido (maior do que 100)!");
				}
			}
			//independente de a exce��o ocorrer ou n�o, esse c�digo sempre 
			//ser� executado
			finally
			{
				int length = text.getText().length();
				status.setText(status.getText() + " - " + length + " caracteres" );

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
					status.setText("N�mero n�o convers�vel");
					
				}
				else
				{
					status.setText("N�mero inv�lido!");
				}
			}
			//independente de a exce��o ocorrer ou n�o, esse c�digo sempre 
			//ser� executado
			finally
			{
				int length = text.getText().length();
				status.setText(status.getText() + " - " + length + " caracteres" );

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
					status.setText("N�mero n�o convers�vel");
					
				}
				else
				{
					status.setText("N�mero inv�lido!");
				}
			}
			//independente de a exce��o ocorrer ou n�o, esse c�digo sempre 
			//ser� executado
			finally
			{
				int length = text.getText().length();
				status.setText(status.getText() + " - " + length + " caracteres" );

			}
			
		}
	
		//Este m�todo anuncia que pode lan�ar a exce��o NumberFormatException
		double validaNumero() throws ValueException
		{
			double num = 0;
			System.out.println("Entrando no c�digo de valida��o...");
			try
			{
				num = Double.parseDouble(text.getText());
				if (num > 100.0)
				{
					//instancia e lan�a a exce��o
					throw new ValueException();
				}
			}
			/*
			 * independente da forma como este m�todo retornar� (por exce��o ou
			 * por retorno normal), o c�digo dentro do finally sempre ser� 
			 * executado.
			 */
			finally
			{
				System.out.println("Saindo do c�digo de valida��o...");
				
			}
			
			return num;
			
			
		}
	
}



