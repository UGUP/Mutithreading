public class Add1 implements Runnable{
    private Count1 count;

    public Add1(Count1 count){
        this.count=count;
    }
    @Override
    public void run() {
        for(int i=0;i<=10000000;i++){
         //   synchronized (count){
                count.value= count.value+i;
         //   }
        }
    }
}
