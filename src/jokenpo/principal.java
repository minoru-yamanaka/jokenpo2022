package jokenpo;
/*importo a classe Scanner 
 * para dar entrada de dados*/
import java.util.Scanner;
/*JOGO nome do programa, 
 *colocar nome do programa em letra maiúscula*/
public class principal {  
	//Placar
	private static int placarJogador = 0;
	private static int placarComputador = 0;
	// Escolhas
	// 1 = Pedra, 2 = Papel, 3 = Tesoura
	private static int escolhaJogador;
	private static int escolhaComputador;
	// Método Principal
	public static void main(String[/*minoru*/] args) {
		// Quantidade de rodadas / jogadas
		int rodadas = 0,
			restart = 0;
		
		/*do (faça) = chave para abrir a repetição while ele garante que op mesmo irá começar a rodar*/
		do {
			/*Input -> Criou o objeto input (importar dados) para a classe scanner cuja biblioteca foi importada no início*/
			Scanner input = new Scanner(System.in);
			/*Perguntar para o jogador a quantidade de rodadas*/
			System.out.println("::: JOKENPÔ :::");
			System.out.println("INSIRA A QUANTIDADE DE RODADAS: ");
			/*.nextInt()<- importa um (numero int) para varíaveis(rodadas)*/
			rodadas = input.nextInt(); 
		
			/*Reinicia jogo - Vale 0,25*/
			for(int i = 1; i <= rodadas; ++i) 
			{
				/*Math.random()*3)+1; ->Gera números aleatórios   */
				escolhaComputador = (int) (Math.random()*3)+1;
				rotuloEscolhaJogador();
				escolhaJogador = input.nextInt();
				System.out.println("ESCOLHA DO COMPUTADOR: ");
				System.out.println(escolhaComputador);
				verificaResultado();
				exibePlacar();
				/*MÉTODO CRIADO PARA INFORMAR O VENCEDOR*/
				
				/*restart++ add +1 à 0 e ao 1 para que 
				 *possamos colocar opção 1 e 2 no restart*/
				restart++;
			}// Reinicia jogo - Vale 0,25
			/*Encaxei o método depois do (do) para não haver repetição antes de finalizar o jogo */
			exibeResultado();
			System.out.println("RESTART? [1]SIM ou [2]NÃO ");
			restart = input.nextInt();	
			/*SE RESTART FOR IGUAL à [1]SIM ELE REINICIA,
			 *SE NÃO ELE FINALIZA O JOGO COM 2 OU OUTRO NÚMEROS INT
			 *E COM QUALQUER OUTA OPÇÃO ELE DÁ ERRO*/
			}while (restart == 1);//chave que fecha o do - while faça enquanto 
			System.out.println("::: FIM DE JOGO :::");
			}
	
		/* MÉTODO PARA RESULTADO*/ 
		private static void exibeResultado() 
		{
		/*CONDIONAL*/
		/*if é se! JOGADOR > (SE MAIOR QUE) COMPUTADOR*/
		if (placarJogador > placarComputador) {
		/*IMPRIME*/
			System.out.println("!!! JOGADOR GANHOU !!!");
		/* else if é senão se! COMPUTADOR < (SE MENOR QUE) JOGADOR*/
		} else if(placarComputador > placarJogador) {
			System.out.println("!!! COMPUTADOR GANHOU !!!");
		/*else é senão! COMPUTADOR = (SE IGUAL Á) JOGADOR*/
		} else if(placarJogador == placarComputador) {
			System.out.println("::: EMPATE :::");
		}
	}

	/* Condição de vitória e derrota*/
	private static void verificaResultado() {
		/* Vale 0,25 Usar o if para verificar e comparar 
		 * as escolhas Quem ganha recebe pontos
		 * A pontuação deve ser atribuidas 
		 * nas variáveis placarJogador E placarComputador*/
		/* Operador de igualdade 
		 * ==  para comparar objetos: [ escolhaJogador ] e [ 1 ]
		 * ||  testa a relação lógica dos dois booleanos, retornando true ou false*/
		if (escolhaJogador == 1 && escolhaComputador == 2 ||
			escolhaJogador == 2 && escolhaComputador == 3 ||
			escolhaJogador == 3 && escolhaComputador == 1) {
			/* se verdadeiro add 1 int ao computador */
			placarComputador = placarComputador + 1;			
		}else if (escolhaJogador == 1 && escolhaComputador == 3 ||
				escolhaJogador == 2 && escolhaComputador == 1 || 
				escolhaJogador == 3 && escolhaComputador == 2) {
			/*  se verdadeiro add 1 int ao jogador */
			placarJogador = placarJogador + 1;
		}else if (escolhaJogador == escolhaComputador) {
			/* Empate e não add nada só imprimi */ 
			System.out.println("O COMPUTADOR ESCOLHEU O MESMO QUE VOCÊ, REPITA:");
			/*SENÃO ÚLTIMA INSTÂNCIA DO LAÇO */
		}else {
			System.out.println("!!! NÚMERO INVÁLIDO !!!");
		}
		
	}
	// Exibe o resultado do placar
	// placarJogador E placarComputador
	/* CHAMA O MÉTODO  exibePlacar()*/
	private static void exibePlacar() {
		// Vale 0,25
		// Seu código aqui
		System.out.println("::: PLACAR :::");
		/* ADD O VALOR DE placarJogador ou placarComputador à impressão*/
		System.out.println("Jogador: " + placarJogador);
		System.out.println("Computador: " + placarComputador);
	}
		private static void rotuloEscolhaJogador() {
			System.out.println("::: JOGADOR, DIGITE:");
			System.out.println("::: [1] Pedra   :::");
			System.out.println("::: [2] Papel   :::");
			System.out.println("::: [3] Tesoura :::");
			System.out.println("-------------------");
			System.out.println("Escolha sua opção: ");
		}
}
	// Explicação do código - Vale 0,25
	/* declarei os variáveis int e rodadas
	 * fiz a repetição iniciando no do para iniciar e verificando com o while 
	 * add restart++ a variável restart e assim add0 e 1 no menu restart
	 * Elaborei o verificaResultado() e add atribuir pontos com o uso do teste lógico de bolleanos (true ou false)
	 * exibeResultado();v ou d
	 * exibePlacar() foi elaborado testando o maior valor e retornando, o maior */
