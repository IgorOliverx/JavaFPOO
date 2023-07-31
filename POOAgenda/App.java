package POOAgenda;

import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import POOAgenda.Agenda.Agendamento;
import POOAgenda.Cadastro.Animais;
import POOAgenda.Cadastro.Gato;
import POOAgenda.Cadastro.Animais;
import POOAgenda.Cadastro.Cachorro;
import POOAgenda.Cadastro.Outros;
import POOAgenda.Agenda.Agendamento;

public class App {
    public static void main(String[] args) {
        // o vetor servirá para armazenar todos os objetos - VETOR DE OBJETOS
        Gato gatos[] = new Gato[20];
        Cachorro dogs[] = new Cachorro[20];
        Outros outros[] = new Outros[20];
        Agendamento[] agenda = new Agendamento[100];

        // criando um contador para percorrer as infos do vertor que foi criado
        int contDog = 0;
        int contCat = 0;
        int contOutros = 0;
        int contAgenda = 0;

        // criando um vetor de verificação de dados com o show confirm dialog
        Gato vGatos[] = new Gato[20];
        Cachorro vDogs[] = new Cachorro[20];
        Outros vOutros[] = new Outros[20];

        // criando um contador para percorrer os vetores de verificação
        int contVeDog = 0;
        int contVeCat = 0;
        int contVeOutros = 0;
        String conta;

        // Criar o cadastro
        boolean ligar = true;

        JOptionPane.showMessageDialog(null, "Bem-Vindo ao consultório do Dr. Igor");
        // if(LocalDateTime)

        while (ligar) {
            int acao = Integer
                    .parseInt(JOptionPane.showInputDialog("1 - Cadastrar PET\n 2 - Agendar Consulta \n 3- Sair "));

            if (acao == 1) {
                int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1 - Gato\n 2 - Cachorro \n 3 - Outro "));
                if (acao2 == 1) {
                    // Criar o objeto
                    gatos[contCat] = new Gato();
                    // Cadastro do Gato e preenchimento dos atributos
                    gatos[contCat].setProprietario(JOptionPane.showInputDialog("Informe o nome do tutor"));
                    gatos[contCat].setPorte(JOptionPane.showInputDialog("Informe o porte do seu gato"));
                    gatos[contCat].setGenero(JOptionPane.showInputDialog("Informe o gênero do seu gato"));
                    gatos[contCat].setPeso(Double
                            .parseDouble(JOptionPane.showInputDialog("Informe o peso do seu gato - Somente números ")));
                    gatos[contCat].setRaca(JOptionPane.showInputDialog("Informe a raça do seu gato")); // while(ligar){
                    JOptionPane.showMessageDialog(null, "Seu cadastro foi realizado com sucesso!");
                    JOptionPane.showMessageDialog(null, "Infos: "
                            + "\n Proprietário: " + gatos[contCat].getProprietario()
                            + "\n Porte: " + gatos[contCat].getPorte()
                            + "\n Gênero: " + gatos[contCat].getGenero()
                            + "\n Peso: " + gatos[contCat].getPeso() + "KG"
                            + "\n Raça: " + gatos[contCat].getRaca());
                    contCat++;

                    JOptionPane.showConfirmDialog(null, "Seus dados estão corretos?");
                    // }

                } else if (acao2 == 2) {
                    // Criar o objeto
                    dogs[contDog] = new Cachorro();
                    // Cadastro do cachorro e preenchimento dos atributos
                    dogs[contDog].setProprietario(JOptionPane.showInputDialog("Informe o nome do tutor"));
                    dogs[contDog].setPorte(JOptionPane.showInputDialog("Informe o porte do seu cachorro"));
                    dogs[contDog].setGenero(JOptionPane.showInputDialog("Informe o gênero do seu cachorro"));
                    dogs[contDog].setPeso(Double.parseDouble(
                            JOptionPane.showInputDialog("Informe o peso do seu cachorro - Somente números")));
                    dogs[contDog].setRaca(JOptionPane.showInputDialog("Informe a raça do seu cachorro"));
                    JOptionPane.showMessageDialog(null, "Seu cadastro foi realizado com sucesso!");
                    JOptionPane.showMessageDialog(null, "Infos: "
                            + "\n Proprietário: " + dogs[contDog].getProprietario()
                            + "\n Porte: " + dogs[contDog].getPorte()
                            + "\n Gênero: " + dogs[contDog].getGenero()
                            + "\n Peso: " + dogs[contDog].getPeso() + "KG"
                            + "\n Raça: " + dogs[contDog].getRaca());
                    contDog++;

                } else if (acao2 == 3) {
                    // Criar o objeto
                    outros[contOutros] = new Outros();
                    // Cadastro de outro pet e preenchimento dos atributos
                    outros[contOutros].setProprietario(JOptionPane.showInputDialog("Informe o nome do tutor"));
                    outros[contOutros].setPorte(JOptionPane.showInputDialog("Informe o porte do seu PET"));
                    outros[contOutros].setGenero(JOptionPane.showInputDialog("Informe o gênero do seu PET"));
                    outros[contOutros].setPeso(Double
                            .parseDouble(JOptionPane.showInputDialog("Informe o peso do seu PET - Somente números")));
                    outros[contOutros].setEspecie(JOptionPane.showInputDialog("Informe a espécie do seu pet"));
                    JOptionPane.showMessageDialog(null, "Seu cadastro foi realizado com sucesso!");
                    JOptionPane.showMessageDialog(null, "Infos: "
                            + "\n Proprietário: " + outros[contOutros].getProprietario()
                            + "\n Porte: " + outros[contOutros].getPorte()
                            + "\n Gênero: " + outros[contOutros].getGenero()
                            + "\n Peso: " + outros[contOutros].getPeso() + "KG"
                            + "\n Espécie: " + outros[contOutros].getEspecie());
                    contOutros++;

                }

            } else if (acao == 2) {
                // agendamento
                // Verificar se já existe o cadastro
                boolean cadastroOk = false;
                String proprietarioAgenda = JOptionPane.showInputDialog("Informe o Nome do Dono do PET");
                //
                for (int i = 0; i < contCat; i++) {
                    if (gatos[i].getProprietario().equals(proprietarioAgenda)) {
                        JOptionPane.showMessageDialog(null, "Cadastro Encontrado");
                        cadastroOk = true;
                        break;
                    }
                }
                for (int i = 0; i < contDog; i++) {
                    if (dogs[i].getProprietario().equals(proprietarioAgenda)) {
                        JOptionPane.showMessageDialog(null, "Cadastro Encontrado");
                        cadastroOk = true;
                        break;
                    }
                }
                for (int i = 0; i < contOutros; i++) {
                    if (outros[i].getProprietario().equals(proprietarioAgenda)) {
                        JOptionPane.showMessageDialog(null, "Cadastro Encontrado");
                        cadastroOk = true;
                        break;
                    }
                }
                // 1º verificação ok - cadastro realizado
                // 2º verificação
                boolean agendaOk = true;
                do {
                    String dataAgenda = JOptionPane.showInputDialog("Informe a data do Agendamento");
                    String horaAgenda = JOptionPane.showInputDialog("Informe a hora do Agendamento");
                    for (int i = 0; i <= contAgenda; i++) {
                        if (agenda[i].getDataHora().equals(dataAgenda + horaAgenda)) {
                            JOptionPane.showMessageDialog(null, "Horario já Agendado, Escolha outro");
                        } else {
                            agendaOk = false;      
                        }
                    }
                    JOptionPane.showMessageDialog(null,"agendamento Realizado");
                            agenda[contAgenda] = new Agendamento();
                            agenda[contAgenda].setData(dataAgenda);
                            agenda[contAgenda].setHora(horaAgenda);
                            contAgenda++;
                }while (agendaOk);

            } else if (acao == 3) {
                return;
            }

        }

    }
}