import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class GerenciarPessoa {  // Renomeando a classe
    private Set<Pessoa> pessoas;
    private final String arquivo = "pessoas.bin";

    @SuppressWarnings("unchecked")
    public GerenciarPessoa() {  // Renomeando o construtor
        pessoas = new HashSet<>();
        carregarDados();
    }

    private void carregarDados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            pessoas = (Set<Pessoa>) ois.readObject();
        } catch (FileNotFoundException e) {
            pessoas = new HashSet<>();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void salvarDados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            oos.writeObject(pessoas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adicionarPessoa(Pessoa pessoa) {
        if (pessoas.add(pessoa)) {
            System.out.println("Pessoa adicionada com sucesso!");
        } else {
            System.out.println("Já existe uma pessoa com esse e-mail.");
        }
        salvarDados();
    }

    public void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada.");
        } else {
            pessoas.forEach(System.out::println);
        }
    }

    public void deletarPessoa(String email) {
        Pessoa pessoaParaRemover = null;
        for (Pessoa p : pessoas) {
            if (p.getEmail().equals(email)) {
                pessoaParaRemover = p;
                break;
            }
        }
        if (pessoaParaRemover != null) {
            pessoas.remove(pessoaParaRemover);
            System.out.println("Pessoa removida com sucesso.");
            salvarDados();
        } else {
            System.out.println("Pessoa não encontrada.");
        }
    }
}
