/*
 * Este exemplo mostra como dois pedestres andando em direção contrária
 * podem "desviar" um do outro indefinidamente sem chegar a uma conclusão
 * (ou seja, existe um livelock entre eles)
 */
public class Teste44bLivelockClass {


	public static void main(String[] args) {
		
		int counter = 1;
		
		/*
		 * Este laço cria threads continuamente, simulando o "encontro" de dois
		 * pedestres na rua e a sua travessia
		 */
		while (true)
		{
			Pedestre p1 = new Pedestre("Fulano " + counter);
			Pedestre p2 = new Pedestre("Ciclano " + counter);
			p1.setOutro(p2);
			p2.setOutro(p1);
			p1.start();
			p2.start();
			/*
			 * Aguarda que os dois pedestres atuais atravessem antes de criar
			 * novos pedestres.
			 */
			while (p1.isAlive() || p2.isAlive())
			{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			counter++;
		}
		
		

	}

}
