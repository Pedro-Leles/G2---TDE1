import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Gerenciador ger = new Gerenciador();
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Incluir automóvel");
            System.out.println("2 - Remover automóvel");
            System.out.println("3 - Alterar dados de automóvel");
            System.out.println("4 - Consultar automóvel por placa");
            System.out.println("5 - Listar automóveis (ordenado)");
            System.out.println("6 - Salvar e sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine(); 
                    ger.inserir(new Automovel(placa, modelo, marca, ano, valor));
                    break;

                case 2:
                    System.out.print("Informe a placa: ");
                    ger.remover(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Placa do veículo a alterar: ");
                    String p = sc.nextLine();
                    System.out.print("Novo modelo: ");
                    modelo = sc.nextLine();
                    System.out.print("Nova marca: ");
                    marca = sc.nextLine();
                    System.out.print("Novo ano: ");
                    ano = sc.nextInt();
                    System.out.print("Novo valor: ");
                    valor = sc.nextDouble();
                    sc.nextLine();
                    ger.alterar(p, new Automovel(p, modelo, marca, ano, valor));
                    break;

                case 4:
                    System.out.print("Placa para consulta: ");
                    Automovel a = ger.buscar_por_placa(sc.nextLine());
                    System.out.println(a != null ? a : "Automóvel não encontrado.");
                    break;

                case 5:
                    System.out.print("Ordenar por (placa/modelo/marca): ");
                    ger.lista_ordenada(sc.nextLine());
                    break;

                case 6:
                    ger.salvar_arquivo();
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 6);

        sc.close();


	}

}
