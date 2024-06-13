public class MainClass {

    public static void main(String[] args) {
        Foo foo= new Foo();
        Thread t1= new Thread(foo);
        t1.start();

    }


}
