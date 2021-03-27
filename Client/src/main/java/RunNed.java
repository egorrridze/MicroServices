import my.dataframecourse.servicenew.*;

public class RunNed {

    public static void main(String[] args) {
        System.out.println("Digli-dagli!");

        MySoapServiceService ms = new MySoapServiceService();
        MySoapService client = ms.getMySoapServicePort();
        System.out.println(client.hello("Homer"));
    }
}
