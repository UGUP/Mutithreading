public class NewAdder implements  Runnable{

    private NewCount count;

    public NewAdder(NewCount count){
        this.count=count;
    }
    @Override
    public void run() {
        for(int i=0;i<=10000000;i++){
            count.value= count.value+i;
        }

    }
}
