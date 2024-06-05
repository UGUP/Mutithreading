public class ClientMain2 {

    public static void main(String[] args) {
        for(int i=1;i<=10;i++){
            TableCreator table= new TableCreator(2,i);
            Thread thread= new Thread(table);
            thread.start();
        }

    }
}
