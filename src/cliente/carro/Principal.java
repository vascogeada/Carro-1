package cliente.carro;

public class Principal {

	public static void main(String[] args) {
		
		Carro c = new Carro();
		
		System.out.println(testarMeterCombustivelAtestar(c));
		
		c.andar(727.7777);
		
		System.out.println(testarMeterCombustivelcomQuantidade(c, 20) );

		System.out.println(testarMeterCombustivelAtestar(c));
	
		
		System.out.println(testarAndar(c, 1));
	}
	
	private static boolean testarConstrucaoCarro(Carro carro) {
		if( carro.getCapacidadeDeposito() == 40.0 && carro.getQuantidadeCombustivel() == 0)
			return true;
		else 
			return false;
	}
	
	private  static boolean testarMeterCombustivelcomQuantidade(Carro carro, double quantidade) {
		
		// Considerar 3 casos 
		
		if (carro.getQuantidadeCombustivel() + quantidade > carro.getCapacidadeDeposito())
			return false;
		else if(carro.getQuantidadeCombustivel() + quantidade == carro.getCapacidadeDeposito())
			return true;
		else 
			return true;
		
		// Dando uma quantidade que faria transbordar o dep�sito
		
		// Dando a exacta quantidade para atestar o dep�sito 
		
		// Dando uma quantidade que aumentaria o n�vel de combust�vel sem encher por completo o dep�sito
		
	}
	
	private static  boolean testarMeterCombustivelAtestar(Carro carro) {
		if (carro.meterCombustivel() > 0)
			return true;
		else 
			return false;
	}
	
	private static  boolean testarAndar(Carro carro, double distancia) {
			
			if (distancia < carro.obterAutonomia()) {
				return true;
			}
			else 
				return false;
		
		
		// Recendo uma dist�ncia dentro da autonomia do carro 
		
		// Recebendo uma dist�ncia superior � autonomia do carro 
		
		// Recebendo uma dist�ncia igual � autonomia do carro 
		
	}
	
	

}
