package numbers;

public class DuckNumber {

    private long number;
    private boolean duck;

    public DuckNumber(long number) {
        this.number = number;
        this.duck = false;
    }

    public void isDuck() {
        String temp = Long.toString(this.number);
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == '0' && i != 0) {
                this.duck = true;
                break;
            } else {
                this.duck = false;
            }
        }
    }

    public void setNumber(long number) {
        this.number = number;
        this.duck = false;
    }

    public boolean getDuck() {
        return this.duck;
    }

}
