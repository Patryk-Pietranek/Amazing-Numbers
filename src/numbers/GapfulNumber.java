package numbers;

public class GapfulNumber {

    private long number;
    private boolean gapful;

    public GapfulNumber(long number) {
        this.number = number;
        this.gapful = false;
    }

    public void isGapful() {
        String numberString = Long.toString(number);
        if (numberString.length() > 2) {
            char first = numberString.charAt(0);
            char last = numberString.charAt(numberString.length() - 1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(first);
            stringBuilder.append(last);
            String divisorString = stringBuilder.toString();
            int divisor = Integer.parseInt(divisorString);
            if (this.number % divisor == 0) {
                gapful = true;
            }
        } else {
            gapful = false;
        }
    }

    public void setNumber(long number) {
        this.number = number;
        this.gapful = false;
    }

    public boolean getGapful() {
        return gapful;
    }

}
