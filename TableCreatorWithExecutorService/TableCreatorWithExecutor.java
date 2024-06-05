public class TableCreatorWithExecutor implements Runnable {

    private int incrementor;
    private int input;

    public TableCreatorWithExecutor(int input,int incrementor){
        this.incrementor=incrementor;
        this.input=input;
    }
    @Override
    public void run() {
        System.out.println("The name of teh Thread is "+Thread.currentThread().getName()+" "+input+"* "+incrementor+"= "+input*incrementor);
    }
}
