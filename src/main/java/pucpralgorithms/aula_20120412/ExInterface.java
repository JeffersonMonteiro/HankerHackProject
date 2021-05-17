import javax.swing.*;
import java.awt.event.*;
public class ExInterface
{
	public static void main (String [] args)
	{
		JFrame janela = new JFrame("T�tulo");
		janela.setSize(500, 300);
		
		JButton botao = new JButton("Clique aqui");
		janela.getContentPane().setLayout(null);
		janela.getContentPane().add(botao);
		botao.setBounds(100, 100, 100, 50);
		
		//cadastro de algu�m que implementa ActionListener (objeto da
		//classe Controle) para ser ouvinte dos eventos de bot�o
		botao.addActionListener(new Controle());
		
		janela.setVisible(true);
		
	
	}


}

//Algu�m que implementa ActionListener e, portanto, tem a OBRIGA��O
//de implementar os m�todos definidos na interface (no caso, o actionPerformed)
class Controle implements ActionListener
{
	public void acaoBotao()
	{
		System.out.println("Mensagem de console: algu�m clicou no bot�o");	
	}	
	
	public void  actionPerformed(ActionEvent e)
	{
		//chama a l�gica de tratamento do evento
		acaoBotao();
	}
	
}

