// Storage.java
class Storage<T> {
    T x;
    public void setValue(T value) {
        x = value;
    }
    public T getValue() {
        return x;
    }
}
// BankAccount.java
class BankAccount {
    private float saldo;
    public void deposit(float amount) {
        this.saldo += amount;
    }
    public float showSaldo() {
        return this.saldo;
    }
    BankAccount() {
        saldo = 100;
    }
}
// Main.java
public class Main {
    public static void main(String[] args) {
        Storage<BankAccount> aStorage = new Storage<BankAccount>();
        Storage<String> sStorage = new Storage<String>();

        Class<BankAccount> baCls = BankAccount.class;
        try {
            BankAccount myAccount = (BankAccount) baCls.newInstance();
            aStorage.setValue( myAccount );
            // Deposit
            myAccount.deposit( 15 );
        }
        catch ( InstantiationException e ) {}
        catch ( IllegalAccessException e ) {}

        //Do a simple output
        System.out.println( aStorage.getValue().showSaldo() );
        // Now try to compare
        if( aStorage.getClass() == sStorage.getClass() ) {
            System.out.println( "EQUAL" );
        } else {
            System.out.println( "NOT EQUAL" );
        }
    }
}
