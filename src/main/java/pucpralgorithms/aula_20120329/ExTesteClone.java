class Teste 
{
	private int valor;
	private String texto;
	public void setValor(int v) { valor = v; }
	public int getValor() { return valor; }
	
	public void setTexto(String t) { texto = t; }
	public String getTexto() { return texto; }

	
	public Teste clone()
	{	
// 		Teste c = new Teste();
// 		c.valor = valor;
// 		c.texto = new String(texto);			
// 		return c;
		Teste c = null;
		
		try
		{
			//aqui chama o clone() da classe Object
			 c = (Teste)super.clone();
		}
		
		catch (CloneNotSupportedException e)
		{
			return null;	
		}
		//agora temos que resolver o problema da String
		c.texto = new String(texto);			
		return c;
		
	}

}

public class ExTesteClone
{
	public static void main (String [] args)
	{
		Teste t1 = new Teste();
		t1.setValor(15);
		t1.setTexto("palavra qualquer");
		
		Teste t2 = (Teste)t1.clone();	
	
	}


}