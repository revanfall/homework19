import com.sun.deploy.security.SelectableSecurityManager;

public class ThreadOne extends Thread {
   private int amount;
    private boolean isGetting=true;

    public ThreadOne(int amount){
        this.amount=amount;
    }
    void anotherRole(){
        isGetting=false;
    }
    @Override
    public void run() {
        do{
            if(!Thread.interrupted()){
                synchronized(ATM.class){
                    if(isGetting) {
                        ATM.setAmount(ATM.getAmount() - amount);
                        System.out.println("First thread-add money-amount: " + ATM.getAmount());
                    }
                    else
                        ATM.setAmount(ATM.getAmount()+amount);
                        System.out.println("First thread-withdraw money-amount: "+ATM.getAmount());
                    }
                } else return;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return;
            }
        } while (true);
        }
    }

