package pucpralgorithms.exemplos_32_39.Teste33bMyException.src;

//Exemplo de como declarar uma exce��o customizada
//e customizar a sua mensagem
public class Teste33bMyExceptionClass {

	
	public static void main(String[] args) {
		try
		{
			exceptionLauncher();
		}
		catch(MyException e)
		{
			//A chamada a printStackTrace mostra a mensagem
			//exibida pela exce��o e toda a pilha de chamadas
			//percorrida pelo seu lan�amento
			e.printStackTrace();
		}
	}
	
	static void exceptionLauncher() throws MyException
	{
		//instancia MyException com uma mensagem customizada
		throw new MyException("exceptionLauncher");
	}

}

class MyException extends Exception
{
	public MyException(String msg)
	{
		super("Exce��o encontrada em: " + msg);
	}
	
}
