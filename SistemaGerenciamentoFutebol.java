import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class SistemaGerenciamentoFutebol {
    private static List<Equipe> equipes = new ArrayList<>();
    private static List<Liga> ligas = new ArrayList<>();
    private static List<Partidas> partidas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Sistema de Gerenciamento de Futebol:");
            System.out.println("1. Visualizar informações");
            System.out.println("2. Adicionar/Remover equipes, jogadores, treinadores e ligas");
            System.out.println("3. Registrar partidas e atualizar resultados");
            System.out.println("4. Gerenciar tabelas de classificação das ligas");
            System.out.println("5. Sair");
            System.out.println("6. Exibir mensagem");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    visualizarInformacoes(scanner);
                    break;
                case 2:
                    adicionarRemover(scanner);
                    break;
                case 3:
                    registrarPartidas(scanner);
                    break;
                case 4:
                    gerenciarTabelasClassificacao(scanner);
                    break;
                case 5:
                    running = false;
                    break;
                case 6;
                 exibirmensagem(scanner)
                 break;
                default:
                    System.out.println("Opção inválida, tente novamente.");

            }
        }
        scanner.close();
    }

    private static void visualizarInformacoes(Scanner scanner) {
        System.out.println("Visualizar informações:");
        System.out.println("1. Equipes");
        System.out.println("2. Jogadores");
        System.out.println("3. Treinadores");
        System.out.println("4. Ligas");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                for (Equipe equipe : equipes) {
                    System.out.println("Equipe: " + equipe.getNome() + ", País: " + equipe.getPais());
                }
                break;
            case 2:
                System.out.println("Digite o nome da equipe ou 'todos' para listar jogadores de todas as equipes:");
                String nomeEquipe = scanner.nextLine();
                if (nomeEquipe.equalsIgnoreCase("todos")) {
                    for (Equipe equipe : equipes) {
                        for (Equipe.Jogador jogador : equipe.getListaJogadores()) {
                            exibirDetalhesJogador(jogador, equipe.getNome());
                        }
                    }
                } else {
                    Equipe equipeSelecionada = null;
                    for (Equipe equipe : equipes) {
                        if (equipe.getNome().equalsIgnoreCase(nomeEquipe)) {
                            equipeSelecionada = equipe;
                            break;
                        }
                    }
                    if (equipeSelecionada != null) {
                        for (Equipe.Jogador jogador : equipeSelecionada.getListaJogadores()) {
                            exibirDetalhesJogador(jogador, equipeSelecionada.getNome());
                        }
                    } else {
                        System.out.println("Equipe não encontrada.");
                    }
                }
                break;
            case 3:
                for (Equipe equipe : equipes) {
                    Treinador treinador = equipe.getTreinador();
                    if (treinador != null) {
                        exibirDetalhesTreinador(treinador, equipe.getNome());
                    }
                }
                break;
            case 4:
                for (Liga liga : ligas) {
                    System.out.println("Liga: " + liga.getNome());
                }
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
        }
    }

    private static void exibirDetalhesJogador(Equipe.Jogador jogador, String nomeEquipe) {
        System.out.println("Equipe.Jogador: " + jogador.getNome() +
                ", Equipe: " + nomeEquipe +
                ", Número da Camisa: " + jogador.getNumeroCamisa() +
                ", Posição: " + jogador.getPosicao() +
                ", Habilidade: " + jogador.getHabilidade());

    }

    private static void exibirDetalhesTreinador(Treinador treinador, String nomeEquipe) {
        System.out.println("Treinador: " + treinador.getNome() +
                ", Equipe: " + nomeEquipe +
                ", Idade: " + treinador.getIdade() +
                ", Nacionalidade: " + treinador.getNacionalidade() +
                ", Experiência: " + treinador.getExperiencia() +
                ", Especialização: " + treinador.getEspecializacao() +
                ", Títulos: " + treinador.getTitulos());
    }

    private static void adicionarRemover(Scanner scanner) {
        System.out.println("Adicionar/Remover:");
        System.out.println("1. Equipe");
        System.out.println("2. Equipe.Jogador");
        System.out.println("3. Treinador");
        System.out.println("4. Liga");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha

        switch (opcao) {
            case 1:
                System.out.println("1. Adicionar Equipe");
                System.out.println("2. Remover Equipe");
                int opcaoEquipe = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                if (opcaoEquipe == 1) {
                    System.out.println("Nome da Equipe:");
                    String nomeEquipe = scanner.nextLine();
                    System.out.println("País da Equipe:");
                    String paisEquipe = scanner.nextLine();
                    Equipe equipe = new Equipe(nomeEquipe, paisEquipe);
                    equipes.add(equipe);
                    System.out.println("Equipe adicionada com sucesso.");
                } else if (opcaoEquipe == 2) {
                    System.out.println("Nome da Equipe a ser removida:");
                    String nomeEquipe = scanner.nextLine();
                    equipes.removeIf(equipe -> equipe.getNome().equalsIgnoreCase(nomeEquipe));
                    System.out.println("Equipe removida com sucesso.");
                } else {
                    System.out.println("Opção inválida.");
                }
                break;
            case 2:
                System.out.println("1. Adicionar Equipe.Jogador");
                System.out.println("2. Remover Equipe.Jogador");
                int opcaoJogador = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                if (opcaoJogador == 1) {
                    System.out.println("Nome do Equipe.Jogador:");
                    String nomeJogador = scanner.nextLine();
                    System.out.println("Idade do Equipe.Jogador:");
                    int idadeJogador = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.println("Nacionalidade do Equipe.Jogador:");
                    String nacionalidadeJogador = scanner.nextLine();
                    System.out.println("Equipe Atual do Equipe.Jogador:");
                    String equipeAtualJogador = scanner.nextLine();
                    System.out.println("Posição do Equipe.Jogador:");
                    String posicaoJogador = scanner.nextLine();
                    System.out.println("Número da Camisa do Equipe.Jogador:");
                    String numeroCamisaJogador = scanner.nextLine();
                    System.out.println("Habilidade do Equipe.Jogador:");
                    String habilidadeJogador = scanner.nextLine();

                    Equipe.Jogador jogador = new Equipe.Jogador(nomeJogador, idadeJogador, nacionalidadeJogador, equipeAtualJogador, posicaoJogador, numeroCamisaJogador, habilidadeJogador);

                    for (Equipe equipe : equipes) {
                        if (equipe.getNome().equalsIgnoreCase(equipeAtualJogador)) {
                            equipe.adicionarJogador(jogador);
                            System.out.println("Equipe.Jogador adicionado com sucesso.");
                            break;
                        }
                    }
                } else if (opcaoJogador == 2) {
                    System.out.println("Nome do Equipe.Jogador a ser removido:");
                    String nomeJogador = scanner.nextLine();

                    for (Equipe equipe : equipes) {
                        equipe.getListaJogadores().removeIf(jogador -> jogador.getNome().equalsIgnoreCase(nomeJogador));
                    }
                    System.out.println("Equipe.Jogador removido com sucesso.");
                } else {
                    System.out.println("Opção inválida.");
                }
                break;
            case 3:
                System.out.println("1. Adicionar Treinador");
                System.out.println("2. Remover Treinador");
                int opcaoTreinador = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                if (opcaoTreinador == 1) {
                    System.out.println("Nome do Treinador:");
                    String nomeTreinador = scanner.nextLine();
                    System.out.println("Idade do Treinador:");
                    int idadeTreinador = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    System.out.println("Nacionalidade do Treinador:");
                    String nacionalidadeTreinador = scanner.nextLine();
                    System.out.println("Equipe Atual do Treinador:");
                    String equipeAtualTreinador = scanner.nextLine();
                    System.out.println("Experiência do Treinador:");
                    int experienciaTreinador = scanner.nextInt();
                    System.out.println("Experiência do Treinador:");

                    scanner.nextLine(); // Consumir nova linha
                    System.out.println("Especialização do Treinador:");
                    String especializacaoTreinador = scanner.nextLine();
                    System.out.println("Títulos do Treinador:");
                    String titulosTreinador = scanner.nextLine();

                    Treinador treinador = new Treinador(nomeTreinador, idadeTreinador, nacionalidadeTreinador, equipeAtualTreinador, experienciaTreinador, especializacaoTreinador, titulosTreinador);

                    for (Equipe equipe : equipes) {
                        if (equipe.getNome().equalsIgnoreCase(equipeAtualTreinador)) {
                            equipe.setTreinador(treinador);
                            System.out.println("Treinador adicionado com sucesso.");
                            break;
                        }
                    }
                } else if (opcaoTreinador == 2) {
                    System.out.println("Nome do Treinador a ser removido:");
                    String nomeTreinador = scanner.nextLine();

                    for (Equipe equipe : equipes) {
                        if (equipe.getTreinador() != null && equipe.getTreinador().getNome().equalsIgnoreCase(nomeTreinador)) {
                            equipe.setTreinador(null);
                            System.out.println("Treinador removido com sucesso.");
                            break;
                        }
                    }
                } else {
                    System.out.println("Opção inválida.");
                }
                break;
            case 4:
                System.out.println("1. Adicionar Liga");
                System.out.println("2. Remover Liga");
                int opcaoLiga = scanner.nextInt();
                scanner.nextLine(); // Consumir nova linha

                if (opcaoLiga == 1) {
                    System.out.println("Nome da Liga:");
                    String nomeLiga = scanner.nextLine();
                    Liga liga = new Liga(nomeLiga);
                    ligas.add(liga);
                    System.out.println("Liga adicionada com sucesso.");
                } else if (opcaoLiga == 2) {
                    System.out.println("Nome da Liga a ser removida:");
                    String nomeLiga = scanner.nextLine();
                    ligas.removeIf(liga -> liga.getNome().equalsIgnoreCase(nomeLiga));
                    System.out.println("Liga removida com sucesso.");
                } else {
                    System.out.println("Opção inválida.");
                }
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
        }
    }

    private static void registrarPartidas(Scanner scanner) {
        System.out.println("Registrar Partida:");
        System.out.println("Equipe Casa:");
        String equipeCasaNome = scanner.nextLine();
        System.out.println("Equipe Visitante:");
        String equipeVisitanteNome = scanner.nextLine();
        System.out.println("Data e Hora (dd/MM/yyyy HH:mm):");
        String dataHoraStr = scanner.nextLine();
        System.out.println("Local da Partida:");
        String localPartida = scanner.nextLine();
        System.out.println("Resultado da Partida:");
        String resultadoPartida = scanner.nextLine();

        Equipe equipeCasa = null;
        Equipe equipeVisitante = null;

        for (Equipe equipe : equipes) {
            if (equipe.getNome().equalsIgnoreCase(equipeCasaNome)) {
                equipeCasa = equipe;
            }
            if (equipe.getNome().equalsIgnoreCase(equipeVisitanteNome)) {
                equipeVisitante = equipe;
            }
        }

        if (equipeCasa != null && equipeVisitante != null) {
            try {
                Date dataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(dataHoraStr);
                Partidas partida = new Partidas(equipeCasa, equipeVisitante, dataHora, localPartida, resultadoPartida);
                partidas.add(partida);
                System.out.println("Partida registrada com sucesso.");
            } catch (ParseException e) {
                System.out.println("Erro no formato da data/hora. Utilize dd/MM/yyyy HH:mm.");
            }
        } else {
            System.out.println("Uma ou ambas as equipes não foram encontradas.");
        }
    }

    private static void gerenciarTabelasClassificacao(Scanner scanner) {
        System.out.println("Gerenciar Tabelas de Classificação:");
        System.out.println("Nome da Liga:");
        String nomeLiga = scanner.nextLine();
        Liga ligaSelecionada = null;

        for (Liga liga : ligas) {
            if (liga.getNome().equalsIgnoreCase(nomeLiga)) {
                ligaSelecionada = liga;
                break;
            }
        }

        if (ligaSelecionada != null) {
            System.out.println("1. Adicionar Equipe à Liga");
            System.out.println("2. Remover Equipe da Liga");
            System.out.println("3. Atualizar Tabela de Classificação");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Nome da Equipe:");
                    String nomeEquipe = scanner.nextLine();
                    for (Equipe equipe : equipes) {
                        if (equipe.getNome().equalsIgnoreCase(nomeEquipe)) {
                            ligaSelecionada.adicionarEquipe(equipe);
                            System.out.println("Equipe adicionada à liga com sucesso.");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Nome da Equipe a ser removida:");
                    String nomeEquipeRemover = scanner.nextLine();
                    for (Equipe equipe : equipes) {
                        if (equipe.getNome().equalsIgnoreCase(nomeEquipeRemover)) {
                            ligaSelecionada.removerEquipe(equipe);
                            System.out.println("Equipe removida da liga com sucesso.");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Nova Tabela de Classificação:");
                    String novaTabela = scanner.nextLine();
                    ligaSelecionada.setTabelaClassificacao(novaTabela);
                    System.out.println("Tabela de classificação atualizada com sucesso.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } else {
            System.out.println("Liga não encontrada.");
        }
    }
}