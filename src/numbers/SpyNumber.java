package numbers;

public class SpyNumber {

    private long number;
    private boolean spy;

    public SpyNumber(long number) {
        this.number = number;
        this.spy = false;
    }

    public void isSpy() {
        String numberString = Long.toString(this.number);
        long sum = 0;
        long product = 1;
        for (int i = 0; i < numberString.length(); i++) {
            sum += Character.getNumericValue(numberString.charAt(i));
            product *= Character.getNumericValue(numberString.charAt(i));
        }
        if (sum == product) {
            this.spy = true;
        } else {
            this.spy = false;
        }

    }

    public void setNumber(long number) {
        this.number = number;
        this.spy = false;
    }

    public boolean getSpy() {
        return this.spy;
    }

}
