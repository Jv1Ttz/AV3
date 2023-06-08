import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

class Funcionario {
    private String nome;
    private String cargo;
    private int idade;
    private double salario;
    private String departamento;
    private int id;

    public Funcionario(String nome, String cargo, int idade, double salario, String departamento, int id) {
        this.nome = nome;
        this.cargo = cargo;
        this.idade = idade;
        this.salario = salario;
        this.departamento = departamento;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }
}

class Terceirizado extends Funcionario {

    private String empresa;
    private String tipo_trabalho;

    public Terceirizado (String empresa, String tipo_trabalho, String nome, String cargo, int idade, double salario, String departamento, int id) {
        super (nome, cargo, idade, salario, departamento, id);
        this.empresa = empresa;
        this.tipo_trabalho = tipo_trabalho;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getTipo_trabalho() {
        return tipo_trabalho;
    }

    public void setTipo_trabalho(String tipo_trabalho) {
        this.tipo_trabalho = tipo_trabalho;
    }
}

public class programa {
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Terceirizado> terceirizados = new ArrayList<>();
    
    public static void main(String[] args) {
        cadastrarFuncionariosAutomaticamente();
        cadastrarFuncionariosAutomaticamente2();

        int opcao = -1;
        Scanner scanner = new Scanner(System.in);

        while (opcao != 7) {
            exibirMenu();
            try {
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        cadastrarFuncionario();
                        break;
                    case 2:
                        listarFuncionarios();
                        break;
                    case 3:
                        listarFuncionariosTerceirizados();
                        break;
                    case 4:
                        buscarFuncionario();
                        break;
                    case 5:
                        editarFuncionario();
                        break;
                    case 6:
                        excluirFuncionario();
                        break;
                    case 7:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida. Tente novamente.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    
    private static void exibirMenu() {
        System.out.println("\n==== MENU ====");
        System.out.println("1. Cadastrar funcionário");
        System.out.println("2. Listar funcionários");
        System.out.println("3. Listar funcionários Terceirizados");
        System.out.println("4. Buscar funcionário");
        System.out.println("5. Editar funcionário");
        System.out.println("6. Excluir funcionario");
        System.out.println("7. Sair");
        System.out.print("   Escolha uma opção: ");
        

    }

    private static void cadastrarFuncionariosAutomaticamente() {
        funcionarios.add(new Funcionario("Joao", "Analista", 30, 5000.0, "TI", gerarIDAutomatico()));
        funcionarios.add(new Funcionario("Maria", "Gerente", 35, 8000.0, "Administração", gerarIDAutomatico()));
        funcionarios.add(new Funcionario("Pedro", "Programador", 28, 4000.0, "TI", gerarIDAutomatico()));
        funcionarios.add(new Funcionario("Ana", "Assistente", 25, 3000.0, "Recursos Humanos", gerarIDAutomatico()));
        funcionarios.add(new Funcionario("Carlos", "Estagiário", 20, 1500.0, "TI", gerarIDAutomatico()));
        funcionarios.add(new Funcionario("Mariana", "Analista", 32, 5500.0, "Financeiro", gerarIDAutomatico()));
        funcionarios.add(new Funcionario("Lucas", "Programador", 27, 4500.0, "TI", gerarIDAutomatico()));
        
    }

    private static void cadastrarFuncionariosAutomaticamente2() {
    terceirizados.add(new Terceirizado("Empresa X", "remoto", "Sergio", "Analista", 30, 1000.0, "TI", gerarIDAutomatico()));
    terceirizados.add(new Terceirizado("Empresa Y", "presencial", "Robson", "Desenvolvedor", 25, 2000.0, "Marketing", gerarIDAutomatico()));
}

   
    private static void cadastrarFuncionario() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("\nDigite o nome do funcionário: ");
        String nome = scanner.nextLine();
    
        System.out.print("Digite o cargo do funcionário: ");
        String cargo = scanner.nextLine();
    
        int idade;
        do {
            System.out.print("Digite a idade do funcionário: ");
    
            while (!scanner.hasNextInt()) {
                System.out.println("Idade inválida. Digite um valor numérico.");
                scanner.next(); 
            }
            idade = scanner.nextInt();
            scanner.nextLine(); 
    
            if (idade < 0) {
                System.out.println("Idade não pode ser negativa. Digite novamente.");
            }
        } while (idade < 0);
    
        double salario;
        do {
            System.out.print("Digite o salário do funcionário: ");
    
        
            while (!scanner.hasNextDouble()) {
                System.out.println("Salário inválido. Digite um valor numérico.");
                scanner.next(); 
            }
            salario = scanner.nextDouble();
            scanner.nextLine(); 
    
            if (salario < 0) {
                System.out.println("Salário não pode ser negativo. Digite novamente.");
            }
        } while (salario < 0);
    
        System.out.print("Digite o departamento do funcionário: ");
        String departamento = scanner.nextLine();
    
        int id = gerarIDAutomatico();

        System.out.print("O funcionário é terceirizado? (S/N): ");
    String terceirizadoStr = scanner.nextLine();
    boolean terceirizado = terceirizadoStr.equalsIgnoreCase("S");

    if (terceirizado) {
        System.out.print("Digite o nome da empresa: ");
        String empresa = scanner.nextLine();

        System.out.print("Digite o tipo de trabalho: ");
        String tipoTrabalho = scanner.nextLine();

        Terceirizado novoTerceirizado = new Terceirizado(empresa, tipoTrabalho, nome, cargo, idade, salario, departamento, id);
        terceirizados.add(novoTerceirizado);
    } else {
        Funcionario novoFuncionario = new Funcionario(nome, cargo, idade, salario, departamento, id);
        funcionarios.add(novoFuncionario);
    }
    
        System.out.println("Funcionário cadastrado com sucesso!\n");
    }

    private static int gerarIDAutomatico() {
        if (funcionarios.isEmpty()) {
            return 1;
        } else {
            Funcionario ultimoFuncionario = funcionarios.get(funcionarios.size() - 1);
            return ultimoFuncionario.getID() + 1;
        }
    }
    
    
    private static void listarFuncionarios() {
        System.out.println("\n==== LISTA DE FUNCIONÁRIOS ====");
        System.out.printf("%-15s %-15s %-15s\n", "Nome", "Cargo", "Idade");
        for (Funcionario funcionario : funcionarios) {
            System.out.printf("%-15s %-15s %-15s\n", funcionario.getNome(), funcionario.getCargo(), funcionario.getIdade());
        }
        System.out.println();
    }
    private static void listarFuncionariosTerceirizados() {
        System.out.println("\n==== LISTA DE FUNCIONÁRIOS TERCEIRIZADOS ====");
        System.out.printf("%-15s %-15s %-15s\n", "Nome", "Cargo", "Idade");
        for (Terceirizado terceirizado : terceirizados) {
            System.out.printf("%-15s %-15s %-15s\n", terceirizado.getNome(), terceirizado.getCargo(), terceirizado.getIdade());
        }
        System.out.println();
    }

    private static void buscarFuncionario() {
        Scanner scanner = new Scanner(System.in);
   
        System.out.print("\nBuscar funcionario por (nome, cargo, idade, salário, departamento): ");
        String atributo = scanner.nextLine();
   
        System.out.print("Digite o atributo: ");
        String valor = scanner.nextLine();
   
        System.out.println("\n==== RESULTADO DA BUSCA ====");
        boolean encontrouFuncionarios = false; 
   
        for (Funcionario funcionario : funcionarios) {
            if (atributo.equalsIgnoreCase("nome") && funcionario.getNome().equalsIgnoreCase(valor)) {
                exibirDetalhesFuncionario(funcionario);
                encontrouFuncionarios = true;
            } else if (atributo.equalsIgnoreCase("cargo") && funcionario.getCargo().equalsIgnoreCase(valor)) {
                exibirDetalhesFuncionario(funcionario);
                encontrouFuncionarios = true;
            } else if (atributo.equalsIgnoreCase("idade") && String.valueOf(funcionario.getIdade()).equalsIgnoreCase(valor)) {
                exibirDetalhesFuncionario(funcionario);
                encontrouFuncionarios = true;
            } else if (atributo.equalsIgnoreCase("salário") && String.valueOf(funcionario.getSalario()).equalsIgnoreCase(valor)) {
                exibirDetalhesFuncionario(funcionario);
                encontrouFuncionarios = true;
            } else if (atributo.equalsIgnoreCase("departamento") && funcionario.getDepartamento().equalsIgnoreCase(valor)) {
                exibirDetalhesFuncionario(funcionario);
                encontrouFuncionarios = true;
            } else if (atributo.equalsIgnoreCase("id") && String.valueOf(funcionario.getID()).equalsIgnoreCase(valor)){
                exibirDetalhesFuncionario(funcionario);
                encontrouFuncionarios = true;
            }
        }
        for (Terceirizado terceirizado : terceirizados) {
            if (atributo.equalsIgnoreCase("nome") && terceirizado.getNome().equalsIgnoreCase(valor)) {
                exibirDetalhesFuncionario(terceirizado);
                encontrouFuncionarios = true;
            } else if (atributo.equalsIgnoreCase("cargo") && terceirizado.getCargo().equalsIgnoreCase(valor)) {
                exibirDetalhesFuncionario(terceirizado);
                encontrouFuncionarios = true;
            } else if (atributo.equalsIgnoreCase("idade") && String.valueOf(terceirizado.getIdade()).equalsIgnoreCase(valor)) {
                exibirDetalhesFuncionario(terceirizado);
                encontrouFuncionarios = true;
            } else if (atributo.equalsIgnoreCase("salário") && String.valueOf(terceirizado.getSalario()).equalsIgnoreCase(valor)) {
                exibirDetalhesFuncionario(terceirizado);
                encontrouFuncionarios = true;
            } else if (atributo.equalsIgnoreCase("departamento") && terceirizado.getDepartamento().equalsIgnoreCase(valor)) {
                exibirDetalhesFuncionario(terceirizado);
                encontrouFuncionarios = true;
            } else if (atributo.equalsIgnoreCase("id") && String.valueOf(terceirizado.getID()).equalsIgnoreCase(valor)){
                exibirDetalhesFuncionario(terceirizado);
                encontrouFuncionarios = true;
            }
        }
   
        if (!encontrouFuncionarios) {
            System.out.println("Nenhum funcionário encontrado com o valor especificado.\n");
        }
         
    }
    private static void editarFuncionario() {
        Scanner scanner = new Scanner(System.in);
    
        int id;
        do {
            System.out.print("\nDigite o ID do funcionário que deseja editar (apenas números positivos): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine(); 
            }
            id = scanner.nextInt();
            scanner.nextLine(); 
        } while (id <= 0);
    
        boolean funcionarioEncontrado = false;
    
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getID() == id) {
                System.out.println("Funcionário encontrado! Digite as novas informações:");
    
                System.out.print("Digite o novo cargo do funcionário: ");
                String novoCargo = scanner.nextLine();
                funcionario.setCargo(novoCargo);
    
                int novaIdade;
                do {
                    System.out.print("Digite a nova idade do funcionário (apenas números positivos): ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Entrada inválida. A idade deve ser um número inteiro. Tente novamente.");
                        scanner.nextLine(); 
                    }
                    novaIdade = scanner.nextInt();
                    scanner.nextLine(); 
                } while (novaIdade <= 0);
                funcionario.setIdade(novaIdade);
    
                double novoSalario;
                do {
                    System.out.print("Digite o novo salário do funcionário (apenas números positivos): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Entrada inválida. O salário deve ser um número decimal. Tente novamente.");
                        scanner.nextLine(); 
                    }
                    novoSalario = scanner.nextDouble();
                    scanner.nextLine(); 
                } while (novoSalario <= 0);
                funcionario.setSalario(novoSalario);
    
                System.out.print("Digite o novo departamento do funcionário: ");
                String novoDepartamento = scanner.nextLine();
                funcionario.setDepartamento(novoDepartamento);
    
                System.out.println("Informações do funcionário atualizadas com sucesso!\n");
                funcionarioEncontrado = true;
                break;
            }
        }

        for (Terceirizado terceirizado : terceirizados) {
            if (terceirizado.getID() == id) {
                System.out.println("Funcionário terceirizado encontrado! Digite as novas informações:");
    
                System.out.print("Digite o novo cargo do funcionário terceirizado: ");
                String novoCargo = scanner.nextLine();
                terceirizado.setCargo(novoCargo);
    
                int novaIdade;
                do {
                    System.out.print("Digite a nova idade do funcionário terceirizado (apenas números positivos): ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Entrada inválida. A idade deve ser um número inteiro. Tente novamente.");
                        scanner.nextLine(); 
                    }
                    novaIdade = scanner.nextInt();
                    scanner.nextLine(); 
                } while (novaIdade <= 0);
                terceirizado.setIdade(novaIdade);
    
                double novoSalario;
                do {
                    System.out.print("Digite o novo salário do funcionário terceirizado (apenas números positivos): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Entrada inválida. O salário deve ser um número decimal. Tente novamente.");
                        scanner.nextLine(); 
                    }
                    novoSalario = scanner.nextDouble();
                    scanner.nextLine(); 
                } while (novoSalario <= 0);
                terceirizado.setSalario(novoSalario);

                System.out.print("Digite o novo departamento do funcionário: ");
                String novoDepartamento = scanner.nextLine();
                terceirizado.setDepartamento(novoDepartamento);

                System.out.print("Digite a novo tipo de trabalho do funcionário terceirizado: ");
                String novoTipo_trabalho = scanner.nextLine();
                terceirizado.setEmpresa(novoTipo_trabalho);
    
                System.out.print("Digite a nova empresa do funcionário terceirizado: ");
                String novaEmpresa = scanner.nextLine();
                terceirizado.setEmpresa(novaEmpresa);
    
                System.out.println("Informações do funcionário terceirizado atualizadas com sucesso!\n");
                funcionarioEncontrado = true;
                break;
            }
        }
    
        if (!funcionarioEncontrado) {
            System.out.println("Nenhum funcionário encontrado com o ID especificado.\n");
        }
    }
    
    private static void excluirFuncionario() {
        Scanner scanner = new Scanner(System.in);
    
        int id;
        do {
            System.out.print("\nDigite o ID do funcionário que deseja excluir (apenas números positivos): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. O ID deve ser um número inteiro. Tente novamente.");
                scanner.nextLine();
            }
            id = scanner.nextInt();
            scanner.nextLine();
        } while (id <= 0);
    
        boolean funcionarioEncontrado = false;
        Funcionario funcionarioRemovido = null;
    
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getID() == id) {
                funcionarioRemovido = funcionario;
                funcionarioEncontrado = true;
                break;
            }
        }
    
        for (Terceirizado terceirizado : terceirizados) {
            if (terceirizado.getID() == id) {
                funcionarioEncontrado = true;
                System.out.print("Deseja realmente remover o funcionário (S/N)? ");
                String confirmacao = scanner.nextLine();
                if (confirmacao.equalsIgnoreCase("S")) {
                    terceirizados.remove(terceirizado);
                    System.out.println("Funcionário removido com sucesso!\n");
                } else {
                    System.out.println("Remoção cancelada.\n");
                }
                break;
            }
        }
    
        if (funcionarioEncontrado && funcionarioRemovido != null) {
            System.out.print("Deseja realmente remover o funcionário (S/N)? ");
            String confirmacao = scanner.nextLine();
            if (confirmacao.equalsIgnoreCase("S")) {
                funcionarios.remove(funcionarioRemovido);
    
                for (int i = 0; i < funcionarios.size(); i++) {
                    Funcionario funcionario = funcionarios.get(i);
                    funcionario.setID(i + 1);
                }
    
                System.out.println("Funcionário removido com sucesso!\n");
            } else {
                System.out.println("Remoção cancelada.\n");
            }
        } else {
            System.out.println("Nenhum funcionário encontrado com o ID especificado.\n");
        }
    }
    
    
   
    private static void exibirDetalhesFuncionario(Funcionario funcionario) {
        if (funcionario instanceof Terceirizado) {
            Terceirizado terceirizado = (Terceirizado) funcionario;
            System.out.println("\n*FUNCIONARIO TERCEIRIZADO*" );
            System.out.println("ID: " + terceirizado.getID());
            System.out.println("Nome: " + terceirizado.getNome());
            System.out.println("Cargo: " + terceirizado.getCargo());
            System.out.println("Idade: " + terceirizado.getIdade());
            System.out.println("Salário: " + terceirizado.getSalario());
            System.out.println("Departamento: " + terceirizado.getDepartamento());
            System.out.println("Tipo de Trabalho: " + terceirizado.getTipo_trabalho());
            System.out.println("Empresa: " + terceirizado.getEmpresa() + "\n");
        } else {
            System.out.println("ID: " + funcionario.getID());
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Cargo: " + funcionario.getCargo());
            System.out.println("Idade: " + funcionario.getIdade());
            System.out.println("Salário: " + funcionario.getSalario());
            System.out.println("Departamento: " + funcionario.getDepartamento() + "\n");
        }
    }
}
    
