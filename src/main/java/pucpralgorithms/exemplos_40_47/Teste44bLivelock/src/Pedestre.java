
enum Posicao
{
	ESQUERDA,
	DIREITA
	
}
public class Pedestre extends Thread
{
	private Posicao pos;
	private Pedestre outro;
	private String nome;
	public Pedestre(String nome)
	{
		pos = ((int)(Math.random()*2) == 0)? 
				Posicao.ESQUERDA: Posicao.DIREITA;
	
		this.nome = nome;
	}
	public void run()
	{
		while(true)
		{
			Posicao aux = outro.getPos();
			try {
				/*
				 * Este sleep simula o tempo de resposta do pedestre em relação
				 * à posição em que se encontra o outro pedestre
				 */
				sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			/*
			 * Se a posição é igual, muda de lado na rua
			 */
			if (aux == pos)
			{
				pos = (pos == Posicao.DIREITA) ? 
						Posicao.ESQUERDA: Posicao.DIREITA;
				System.out.println("" + nome + " mudou posição para " + 
						((pos == Posicao.DIREITA) ? 
								"direita":"esquerda"));
				
			}
			else 
			{
				System.out.println(nome + " atravessou");
				break;
			}
		}
	}
	public Posicao getPos() {
		return pos;
	}
	public void setOutro(Pedestre outro) {
		this.outro = outro;
	}
}
