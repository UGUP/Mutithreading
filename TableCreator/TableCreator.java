
public class TableCreator implements Runnable{
     private int input;
     private int incrementor;

     public TableCreator(int input,int incrementor){
         this.input=input;
         this.incrementor=incrementor;
     }

    @Override
    public void run() {
         System.out.println("The thread name is"+Thread.currentThread().getName()+" "
                 +input+"* "+incrementor+" ="+input*incrementor);
    }
}
