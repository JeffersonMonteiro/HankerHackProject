import javax.swing.*;
import java.awt.event.*;
public class ExInterface
{
	public static void main (String [] args)
	{
		JFrame janela = new JFrame("Título");
		janela.setSize(500, 300);
		
		JButton botao = new JButton("Clique aqui");
		janela.getContentPane().setLayout(null);
		janela.getContentPane().add(botao);
		botao.setBounds(100, 100, 100, 50);
		
		//cadastro de alguém que implementa ActionListener (objeto da
		//classe Controle) para ser ouvinte dos eventos de botão
		botao.addActionListener(new Controle());
		
		janela.setVisible(true);
		
	
	}


}

//Alguém que implementa ActionListener e, portanto, tem a OBRIGAÇÃO
//de implementar os métodos definidos na interface (no caso, o actionPerformed)
class Controle implements ActionListener
{
	public void acaoBotao()
	{
		System.out.println("Mensagem de console: alguém clicou no botão");	
	}	
	
	public void  actionPerformed(ActionEvent e)
	{
		//chama a lógica de tratamento do evento
		acaoBotao();
	}
	
}

