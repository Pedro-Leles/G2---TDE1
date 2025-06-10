public class Automovel {
	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	private double valor;
	
	public Automovel(String placa, String modelo, String marca, int ano, double valor){
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.valor = valor;
	}
	
	public String toCSV() {
		return placa+ "," +modelo+ "," +marca+ "," +ano+ "," +valor;
	}
	
	public static Automovel fromCSV(String linha) {
		String[] partes = linha.split(",");
		return new Automovel(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]), Double.parseDouble(partes[4]));
	}
	
	@Override
	public String toString() {
		return "Placa: "+placa+ ", Modelo: "+modelo+ ", Marca: "+marca+ ", Ano: "+ano+ ", Valor: "+valor;
	}
	
	public String get_placa() {return placa;}
	public String get_modelo() {return modelo;}
	public String get_marca() {return marca;}
	public int get_ano() {return ano;}
	public double get_valor() {return valor;}
}
