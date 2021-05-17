package calculadorasaque;
import java.util.Scanner;

public class CalculaSaque {

	public static void main(String[] args) {

		int valor;
		int n100, n50, n20, n10, n5, n2;
		Scanner opcao;
		String opcaoEscolhida;
		int opcaoTipoCedulas;
		int valorCedulaEscolhida = 0;

		System.out.println("**********************************");
		System.out.println("*********CAIXA ELETRONICO*********");
		System.out.println("  ");
		System.out.println("***lIMITE MAXIMO PERMITIDO R$ 1000 REAIS****");
		System.out.println("**********************************");
		System.out.println("  ");

		do {
			n100 = 0;
			n50 = 0;
			n20 = 0;
			n10 = 0;
			n5 = 0;
			n2 = 0;

			System.out.println("Qual valor você deseja sacar");

			Scanner read = new Scanner(System.in);
			valor = read.nextInt();

			if (valor > 1000) {
				System.out.println("Valor acima do permitido!!");
			} else {
				while (valor != 0) {

					System.out
							.println("*******************************************************");
					System.out
							.println("******************CÉDULAS DISPONÍVEIS******************");
					System.out
							.println("********R$ 100*****R$ 50********R$ 20*********R$ 10*****");
					System.out.println("Para receber o dinheiro em cédulas de R$ 100 reais digite - 1");
					System.out.println("Para receber o dinheiro em cédulas de R$ 50 reais digite - 2");
					System.out.println("Para receber o dinheiro em cédulas de R$ 20 reais digite - 3");
					System.out.println("Para receber o dinheiro em cédulas de R$ 10 reais digite - 4");

					Scanner valorCedula = new Scanner(System.in);
					opcaoTipoCedulas = valorCedula.nextInt();

					switch (opcaoTipoCedulas) {

					case 1:
						while (valor >= 100) {
							n100 = valor / 100;
							valor = valor % 100;
							valorCedulaEscolhida = 100;
						}
						n50 = valor / 50;
						valor = valor % 50;

						n20 = valor / 20;
						valor = valor % 20;

						n10 = valor / 10;
						valor = valor % 10;

						if (valor % 2 == 0) {
							n2 = valor / 2;
							valor = valor % 2;
						} else {
							n5 = valor / 5;
							valor = valor % 5;
						}

						break;

					case 2:
						while (valor >= 50) {
							n50 = valor / 50;
							valor = valor % 50;
							valorCedulaEscolhida = 50;
						}

						n20 = valor / 20;
						valor = valor % 20;

						n10 = valor / 10;
						valor = valor % 10;

						if (valor % 2 == 0) {
							n2 = valor / 2;
							valor = valor % 2;
						} else {
							n5 = valor / 5;
							valor = valor % 5;
						}
						break;

					case 3:
						while (valor >= 20) {
							n20 = valor / 20;
							valor = valor % 20;
							valorCedulaEscolhida = 20;
						}

						n10 = valor / 10;
						valor = valor % 10;

						if (valor % 2 == 0) {
							n2 = valor / 2;
							valor = valor % 2;
						} else {
							n5 = valor / 5;
							valor = valor % 5;
						}

						break;

					case 4:
						while (valor >= 10) {
							n10 = valor / 10;
							valor = valor % 10;
							valorCedulaEscolhida = 10;
						}

						break;

					default:
						break;
					}

					if (valor % 2 != 0) {
						System.out
								.println("O valor digitado é inválido para opção de notas de R$"
										+ valorCedulaEscolhida + " reais");
						break;
					} else {
						while (valor != 0) {
							if (valor % 2 == 0) {
								n2 = valor / 2;
								valor = valor % 2;
							} else {
								n5 = valor / 5;
								valor = valor % 5;
							}
						}
					}

					System.out
							.println("*************Valor a receber****************");
					System.out.println(" ");

					System.out.println(n100 + " nota(s) de R$ 100 reais ");
					System.out.println(n50 + " nota(s) de R$ 50 reais ");
					System.out.println(n20 + " nota(s) de R$ 20 reais ");
					System.out.println(n10 + " nota(s) de R$ 10 reais ");
					System.out.println(n5 + " nota(s) de R$ 5 reais ");
					System.out.println(n2 + " nota(s) de R$ 2 reais ");
				}

			}

			System.out
					.println("___________________________________________________________________");
			System.out
					.println("Caso deseje encerrar o programa digite E ou digite S para fazer um novo saque");
			System.out
					.println("___________________________________________________________________");
			opcao = new Scanner(System.in);
			opcaoEscolhida = opcao.nextLine();

		} while (!opcaoEscolhida.equalsIgnoreCase("E"));

	}

}
