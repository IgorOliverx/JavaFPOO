package POOAgenda.Agenda;

public class Agendamento {
   //atributos
   String data;
   String hora;
   String dataHora;
   int ano; // nao vou usar pq claramente é 2023 rsrssr


   public String getData() {
      return data;
   }
   public void setData(String data) {
      this.data = data;
   }
   public String getHora() {
      return hora;
   }
   public void setHora(String hora) {
      this.hora = hora;
   }
   public String getDataHora() {
      dataHora = data+hora;
      return dataHora;
   }
   public void setDataHora(String dataHora) {
      this.dataHora = dataHora;
   }

   //métodos
   
  

   
}
