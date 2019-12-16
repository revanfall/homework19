public class ATM {
  static   int amount;

    public static int getAmount() {
        return amount;
    }

    public ATM(int amount) {
        this.amount = amount;
    }

    public static void setAmount(int amount) {
        ATM.amount = amount;
    }
}
