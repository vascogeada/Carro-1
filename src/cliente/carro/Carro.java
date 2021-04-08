package cliente.carro;

/**
 * A classe Carro representa uma viatura automóvel, conhecida popularmente por Carro.
 *
 *  
 * Pretende-se construir uma abstracção simples de um carro, 
 * na sequência da Resolução da Ficha 3 de POO.
 *    
 * @author antrob
 *
 */
public class Carro {
	
	static private final double CONSUMO=5.5; // litros por 100 klm
	
	private double quantidadeCombustivel;	// quantidade de combustível no depósito (unidade litros)
	private double capacidadeDeposito;		// capacidade do depósito em termos de combustível (unidade litros)
	public boolean andar = false;
	
	/*		Construtores	*/
	 
	/**
	 *  Construtor por defeito.
	 *  
	 *  O nível de combustível inicial é 0. 
	 *  A capacidade do depósito é constante e igual a 40 litros 
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
	 * O consumo corresponde a uma especificação de fábrica e assume-se como sendo constante na circulação do automóvel. 
	 * 
	 * @return retorna o número de litros gastos por cada 100 Klm
	 */
	public static double getConsumo() {
		return CONSUMO;
	}

	/**
	 * Obter a Quantidade de combustível que está no depósito. 
	 * 
	 * @return retorna o número de litros de combustível armazenado no depósito  
	 */
	public double getQuantidadeCombustivel() {
		return quantidadeCombustivel;
	}

	/**
	 * Obter a Capacidade do depósito 
	 * 
	 * A capacidade do depósito não se altera no decorrer da vida útil do carro. 
	 * 
	 * @return
	 */
	public double getCapacidadeDeposito() {
		return capacidadeDeposito;
	}
	
	/*		Métodos			*/ 
	
	/**
	 * Meter uma determinada quantidade de combustível no carro
	 * 
	 * Esta é uma das hipóteses de meter combustível
	 * definindo a quantidade a abastecer 
	 *  
	 * @param quantidade - número de litros a introduzir no depósito
	 */
	public double meterCombustivel( double quantidade) { 		
		
		// Devia testar se Transborda o depósito
		// Podia retornar os Litros Metidos 
		if(quantidadeCombustivel + quantidade > capacidadeDeposito) {
			return 0;
		}
		else 
			return quantidadeCombustivel = quantidadeCombustivel + quantidade;		
		
	}
	
	
	/**
	 * Meter combustível no carro de forma a atestar o depósito.
	 * 
	 * Atestar o depósito do carro é uma operação comum nos condutores,
	 * designadamente antes ou quando em viagem.
	 * 
	 * @return retorna a quantidade de litros metida no depósito
	 */
	public double meterCombustivel() {
		
		double litrosMeter = capacidadeDeposito - quantidadeCombustivel;
		
		// ou quantidadeCombustivel = capacidadeDeposito;
		meterCombustivel(litrosMeter);
		
		return litrosMeter;
	}
	
	
	/**
	 * Andar simula o ato de conduzir o veículo ao longo de uma certa distância.
	 * 
	 * @param distancia números de klm a percorrer com o carro
	 *  
	 * @return retorna se conseguiu percorrer a distancia ou não
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
			// Aqui ou simplesmente não percorre qualquer distancia 
			// ou anda até parar porque fica sem combustível 
			double distanciaPercorrida = obterAutonomia();
			quantidadeCombustivel = 0;
			
			return distanciaPercorrida;
		}
			
			
	}
	
	
	// kmCombustivel( )   
	/**
	 * Obter Autonomia permite saber quantos Klms podem ser feitos com o carro sem meter combustível.
	 * 
	 * @return retorna o número de klm que podem ser percorridos com o atual nível do depósito
	 */
	public double obterAutonomia() {
		
		return ( quantidadeCombustivel / getConsumo() ) * 100;
		
	}

}
