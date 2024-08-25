import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GerenciarPessoa gerenciarPessoa = new GerenciarPessoa();  // Instanciando a nova classe
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Salvar uma pessoa");
            System.out.println("2. Listar todas as pessoas");
            System.out.println("3. Deletar uma pessoa pelo e-mail");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o e-mail: ");
                    String email = scanner.nextLine();
                    Pessoa pessoa = new Pessoa(nome, email);
                    gerenciarPessoa.adicionarPessoa(pessoa);  // Usando o novo nome da classe
                    break;

                case 2:
                    gerenciarPessoa.listarPessoas();  // Usando o novo nome da classe
                    break;

                case 3:
                    System.out.print("Digite o e-mail da pessoa a ser deletada: ");
                    String emailParaDeletar = scanner.nextLine();
                    gerenciarPessoa.deletarPessoa(emailParaDeletar);  // Usando o novo nome da classe
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}