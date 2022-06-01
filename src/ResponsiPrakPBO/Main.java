package ResponsiPrakPBO;

public class Main {
    public static void main(String[] args) {
        Connector connector = new Connector();
        TransView transView = new TransView();
        TransController transController = new TransController(connector, transView);
    }
}
