package stream_api.skill_box_stream;

public class EmailAddress {
   private final String email; //электронный адрес
   private String someData; /*доп. информация для формирования письма. В примерах не используем — добавили, чтобы оправдать существование отдельного класса :)*/

   public EmailAddress(String email) {
       this.email = email;
   }

   public String getEmail() {
       return email;
   }

   public String getSomeData() {
       return someData;
   }

   public void setSomeData(String someData) {
       this.someData = someData;
   }
}