package instapay.Bank;

public class AlexBank extends Bank{
    @Override
    public Boolean verifySerial(String serial) {
        return true;
    }

    @Override
    public Double getUserBalance(String serial) {
        return 100000.0;
    }
}
