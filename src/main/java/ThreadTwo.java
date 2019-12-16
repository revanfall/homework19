public class ThreadTwo extends Thread {
    private int amount;
    private boolean isGetting=false;

    public ThreadTwo(int amount){
        this.amount=amount;
    }
    void anotherRole(){
        isGetting=true;
    }
    @Override
    public void run() {
        do{
            if(!Thread.interrupted()){
                synchronized(ATM.class){
                    if(isGetting) {
                        ATM.setAmount(ATM.getAmount() - amount);
                        System.out.println("Second thread-add money-amount: " + ATM.getAmount());
                    }
                    else
                        ATM.setAmount(ATM.getAmount()+amount);
                    System.out.println("Second thread-withdraw money-amount: "+ATM.getAmount());
                }
            }else return;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        } while (true);
    }
}
