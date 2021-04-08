package cliente.carro;

/**
 * A classe Carro representa uma viatura autom�vel, conhecida popularmente por Carro.
 *
 *  
 * Pretende-se construir uma abstrac��o simples de um carro, 
 * na sequ�ncia da Resolu��o da Ficha 3 de POO.
 *    
 * @author antrob
 *
 */
public class Carro {
	
	static private final double CONSUMO=5.5; // litros por 100 klm
	
	private double quantidadeCombustivel;	// quantidade de combust�vel no dep�sito (unidade litros)
	private double capacidadeDeposito;		// capacidade do dep�sito em termos de combust�vel (unidade litros)
	public boolean andar = false;
	
	/*		Construtores	*/
	 
	/**
	 *  Construtor por defeito.
	 *  
	 *  O n�vel de combust�vel inicial � 0. 
	 *  A capacidade do dep�sito � constante e igual a 40 litros 
	 */
	public Carro() {
		super();
	
		quantidadeCombustivel = 0;
		capacidadeDeposito = 40.0;
	}
	
	/*		Acessores		*/ 

	/**
	 * Obter o Consumo do carro em litros por 100Klm.
	 * 
	 * O consumo corresponde a uma especifica��o de f�brica e assume-se como sendo constante na circula��o do autom�vel. 
	 * 
	 * @return retorna o n�mero de litros gastos por cada 100 Klm
	 */
	public static double getConsumo() {
		return CONSUMO;
	}

	/**
	 * Obter a Quantidade de combust�vel que est� no dep�sito. 
	 * 
	 * @return retorna o n�mero de litros de combust�vel armazenado no dep�sito  
	 */
	public double getQuantidadeCombustivel() {
		return quantidadeCombustivel;
	}

	/**
	 * Obter a Capacidade do dep�sito 
	 * 
	 * A capacidade do dep�sito n�o se altera no decorrer da vida �til do carro. 
	 * 
	 * @return
	 */
	public double getCapacidadeDeposito() {
		return capacidadeDeposito;
	}
	
	/*		M�todos			*/ 
	
	/**
	 * Meter uma determinada quantidade de combust�vel no carro
	 * 
	 * Esta � uma das hip�teses de meter combust�vel
	 * definindo a quantidade a abastecer 
	 *  
	 * @param quantidade - n�mero de litros a introduzir no dep�sito
	 */
	public double meterCombustivel( double quantidade) { 		
		
		// Devia testar se Transborda o dep�sito
		// Podia retornar os Litros Metidos 
		if(quantidadeCombustivel + quantidade > capacidadeDeposito) {
			return 0;
		}
		else 
			return quantidadeCombustivel = quantidadeCombustivel + quantidade;		
		
	}
	
	
	/**
	 * Meter combust�vel no carro de forma a atestar o dep�sito.
	 * 
	 * Atestar o dep�sito do carro � uma opera��o comum nos condutores,
	 * designadamente antes ou quando em viagem.
	 * 
	 * @return retorna a quantidade de litros metida no dep�sito
	 */
	public double meterCombustivel() {
		
		double litrosMeter = capacidadeDeposito - quantidadeCombustivel;
		
		// ou quantidadeCombustivel = capacidadeDeposito;
		meterCombustivel(litrosMeter);
		
		return litrosMeter;
	}
	
	
	/**
	 * Andar simula o ato de conduzir o ve�culo ao longo de uma certa dist�ncia.
	 * 
	 * @param distancia n�meros de klm a percorrer com o carro
	 *  
	 * @return retorna se conseguiu percorrer a distancia ou n�o
	 */
	public double andar( double distancia ) {
		
		// Verificar se tem combustivel para a distancia que se pretende andar 
		if( distancia < obterAutonomia() ) {
			andar = true;
			quantidadeCombustivel -= getConsumo() * (distancia / 100); 
			return distancia;
		}
		else {
			andar = false;
			// Aqui ou simplesmente n�o percorre qualquer distancia 
			// ou anda at� parar porque fica sem combust�vel 
			double distanciaPercorrida = obterAutonomia();
			quantidadeCombustivel = 0;
			
			return distanciaPercorrida;
		}
			
			
	}
	
	
	// kmCombustivel( )   
	/**
	 * Obter Autonomia permite saber quantos Klms podem ser feitos com o carro sem meter combust�vel.
	 * 
	 * @return retorna o n�mero de klm que podem ser percorridos com o atual n�vel do dep�sito
	 */
	public double obterAutonomia() {
		
		return ( quantidadeCombustivel / getConsumo() ) * 100;
		
	}

}
