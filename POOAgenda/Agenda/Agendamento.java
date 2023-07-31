package POOAgenda.Agenda;

public class Agendamento {
   //atributos
   int agenda;
   int dia;
   int mes;
   int ano; // nao vou usar pq claramente é 2023 rsrssr
   String cliente;
   int horario;

   
   //métodos
   public int getAgenda() {
      agenda = dia+mes+horario;
      return agenda;
   }
   public void setAgenda(int agendamento) {
      this.agenda = agenda;
   }
   public int getDia() {
      return dia;
   }
   public void setDia(int dia) {
      this.dia = dia;
   }
   public int getMes() {
      return mes;
   }
   public void setMes(int mes) {
      this.mes = mes;
   }
   public String getCliente() {
      return cliente;
   }
   public void setCliente(String cliente) {
      this.cliente = cliente;
   }

   
}
