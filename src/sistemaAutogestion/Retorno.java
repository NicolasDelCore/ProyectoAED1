package sistemaAutogestion;



public class Retorno {
	public enum Resultado {
		OK,ERROR_1,ERROR_2,ERROR_3,ERROR_4,ERROR_5,ERROR_6,NO_IMPLEMENTADA
	};
	int valorEntero;
	String valorString;
        boolean valorbooleano;
	public Resultado resultado;

    public Retorno(Resultado resultado) {
        this.resultado = resultado;
    }
        
        
        
}
