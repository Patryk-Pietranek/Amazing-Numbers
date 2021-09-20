package numbers;

public class SadNumber {

    private boolean sad;
    private HappyNumber happyNumber;

    public SadNumber(long number) {
        happyNumber = new HappyNumber(number);
        sad = false;
    }

    public void isSad() {
        happyNumber.isHappy();
        boolean temp = happyNumber.getHappy();
        if (temp) {
            sad = false;
        } else {
            sad = true;
        }
    }

    public void setNumber(long number) {
        happyNumber.setNumber(number);
        this.sad = false;
    }

    public boolean getSad() {
        return this.sad;
    }


}
