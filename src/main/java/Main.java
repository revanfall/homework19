public  class Main{
    public static void main(String[] args) throws InterruptedException {
    ThreadOne one=new ThreadOne(50);
    ThreadTwo two=new ThreadTwo(20);
    ATM.setAmount(300);
    one.start();
    two.start();

    for(int i=0;i<5;i++){
            Thread.sleep(i*1000);
            one.anotherRole();
            Thread.sleep(1000);
            two.anotherRole();
    }
    two.interrupt();
    Thread.sleep(1000);
    one.interrupt();
    }

}