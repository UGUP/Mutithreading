public class Count {

    private   int value=0;

    public int getValue(){
        return value;
    }

    public synchronized void setValue(int value){
            this.value=this.value+value;
    }

}
