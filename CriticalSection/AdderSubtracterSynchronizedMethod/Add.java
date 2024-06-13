public class Add implements Runnable{
    private Count count;

    public Add(Count count){
        this.count=count;
    }
    @Override
    public void run() {
      for(int i=0;i<=100000;i++){
         count.setValue(i);
          System.out.println("The name of thread "+Thread.currentThread().getName()+" count is  "+count.getValue());
      }
    }
}
