

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Exemplo de gravação e leitura de objetos através de fluxos de objetos
public class Teste38SerializeClass {

	public static void main(String[] args) {
				
		ObjectOutputStream oos;
		ObjectInputStream ois;
		Empregado [] rh_lido = null;
		
		Empregado [] rh = new Empregado[2];
		rh[0] = new Empregado();
		rh[0].setNome("Fulano");
		rh[0].setIdade(25);
		rh[0].calculaSalario(190);
		rh[1] = new Gerente();
		rh[1].setNome("Beltrano");
		rh[1].setIdade(32);
		
		try {
			//aqui cria-se o fluxo de objeto
			oos = new ObjectOutputStream(new FileOutputStream("rh.dat"));
			
			//array é passado como parâmetro, ou seja, o array inteiro
			//é escrito e por consequência os objetos da classe Empregado
			//e Gerente referenciados por ele
			oos.writeObject(rh);
			
			oos.close();
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		
		try {
			//agora vamos recuperar os objetos serializados
			ois = new ObjectInputStream(new FileInputStream("rh.dat"));
			
			//rh_lido é um array inicializado com os objetos lidos do 
			//fluxo de entrada
			rh_lido = (Empregado[])ois.readObject();
			
			
			
			
		} catch (FileNotFoundException e1) {
		
		} catch (IOException e1) {
		
		} catch (ClassNotFoundException e) {
		}
		

		//rh_lido[1].calculaSalario(200);
	
		for (int i = 0; i < 2; i++)
		{
			
			rh_lido[i].mostraDados();
		}

	}
}

//A classe Empregado deve implementar a interface Serializable
//para poder ter seus objetos serializados
class Empregado implements Serializable
{
	String nome;
	int idade;
	double salario;
	
	public double getSalario() { return salario; }
	public int getIdade() { return idade; }
	public String getNome() { return nome; }
	public void calculaSalario(int horas) 
	{ 
		if (horas > 176)
		{
			salario = 176*10 + (horas - 176)*15;
		}
		else salario = horas*10; 
	}
	public void setIdade(int i) { idade = i; }
	public void setNome(String n) { nome = n; }
	public void mostraDados()
	{
		System.out.println("Nome do empregado: " + nome);
		System.out.println("Idade: " + idade);
		System.out.println("Salário: " + salario);
		
	
	}
	public Empregado()
	{
		nome = "";
		idade = 0;
		salario = 0;

	}
	
	
}

class Gerente extends Empregado
{
	double bonus;
	void setBonus(double b) { bonus = b;}

	public void calculaSalario(int horas)
	{
		if (horas > 176)
		{
			salario = 176*20 + (horas - 176)*30;
		}
		else salario = horas*20; 
		salario += bonus;
	}
	
	//Gerente redefine o método mostraDados() já definido em Empregado
	public void mostraDados()
	{
		System.out.println("Nome do chefe: " + nome);
		System.out.println("Idade: " + idade);
		System.out.println("Salário: " + salario);
	
	}
	
}
