public class ClientMain {
    public static void main(String[] args) {
        System.out.println("I am the main class");
        Adder adder= new Adder();
        Subtracter sub= new Subtracter();
        Thread thread1= new Thread(adder);
        thread1.start();
        Thread thread2= new Thread(sub);
        thread2.start();
    }
}
