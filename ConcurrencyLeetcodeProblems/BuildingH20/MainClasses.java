public class MainClasses {

    public static void main(String[] args) {

        Molecule molecule= new Molecule();
        Thread t1= new Thread(molecule);
        t1.start();

    }
}
