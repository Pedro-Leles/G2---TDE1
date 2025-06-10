import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Comparator;




public class Gerenciador {
	private ArrayList<Automovel> lista = new ArrayList<>();
	private String arquivo = "carros.txt";
	
	public Gerenciador() {
		carregar_arquivo();
	}
	
	public void carregar_arquivo() {
		try(BufferedReader br = new BufferedReader(new FileReader("carros.txt"))){
			String linha;
			while((linha = br.readLine()) != null) {
				Automovel i = Automovel.fromCSV(linha);
				lista.add(i);
			}
		}catch (IOException e) {
			System.out.println("Arquivo não encontrado!");
		}
	}
	
	public void inserir(Automovel auto) {
		for(Automovel a : lista) {
			if(a.get_placa().equalsIgnoreCase(auto.get_placa())) {
				System.out.println("Placa já cadastrada!");
				return;
			}
		}
		lista.add(auto);
		System.out.println("Automovel inserido com sucesso!");
	}
	
	public void remover(String placa) {
		Automovel auto = buscar_por_placa(placa);
		if (auto != null) {
			lista.remove(auto);
			System.out.println("Automovel excluido com sucesso!");
		}else {
			System.out.println("Placa não encontrada!");
		}
	}
	
	public void alterar(String placa, Automovel novo) {
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).get_placa().equalsIgnoreCase(placa)) {
				lista.set(i, novo);
				System.out.println("Alterado com sucesso!");
			}
		}
		System.out.println("Placa não encontrada!");
	}
	public Automovel buscar_por_placa(String placa) {
		for(Automovel a : lista) {
			if(a.get_placa().equalsIgnoreCase(placa)) return a;	
		}
		return null;
	}
	
	public void lista_ordenada(String criterio) {
		Comparator<Automovel> comparator;
		switch(criterio.toLowerCase()) {
		case "modelo": comparator = Comparator.comparing(Automovel::get_modelo); break;
		case "marca": comparator = Comparator.comparing(Automovel::get_marca); break;
		case "ano": comparator = Comparator.comparing(Automovel::get_ano); break;
		case "valor": comparator = Comparator.comparing(Automovel::get_valor); break;
		default:
			comparator = Comparator.comparing(Automovel::get_placa);
		}
		lista.stream().sorted(comparator).forEach(System.out::println);
	}
	public void salvar_arquivo() {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))){
			for(Automovel a : lista) {
				bw.write(a.toCSV());
				bw.newLine();
			}
			System.out.println("Dados salvos com sucesso!");
		}
		catch(IOException e){
			System.out.println("Erro ao salvar: "+e.getMessage());
		}
	}
}
