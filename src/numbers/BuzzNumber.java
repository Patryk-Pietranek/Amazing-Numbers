package numbers;

import java.util.Scanner;

public class BuzzNumber {

    private boolean buzz;
    private boolean isDivisibleBy7;
    private boolean endsWith7;
    private long number;

    public BuzzNumber(long number) {
        this.buzz = false;
        this.isDivisibleBy7 = false;
        this.endsWith7 = false;
        this.number = number;
    }

    public void isBuzz() {
        determineBuzzNumber();
    }

    public boolean getBuzz() {
        return this.buzz;
    }

    private void determineBuzzNumber() {
        this.isDivisibleBy7 = checkDivisibility();
        this.endsWith7 = checkLastDigit();
        if (this.isDivisibleBy7 || this.endsWith7) {
            this.buzz = true;
        }
    }

    public void setNumber(long number) {
        this.number = number;
        this.buzz = false;
    }

    private boolean checkDivisibility() {
        return this.number % 7 == 0;
    }

    private boolean checkLastDigit() {
        String temp = Long.toString(this.number);
        return temp.charAt(temp.length() - 1) == '7';
    }

}
