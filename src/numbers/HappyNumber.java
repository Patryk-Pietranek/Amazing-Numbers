package numbers;

public class HappyNumber {

    private long number;
    private boolean happy;

    public HappyNumber(long number) {
        this.number = number;
        this.happy = false;
    }

    public void isHappy() {
        String temp = Long.toString(number);
        long powSum = 0;
        int counter = 0;
        while (true) {
            for (int i = 0; i < temp.length(); i++) {
                powSum += Math.pow(Character.getNumericValue(temp.charAt(i)), 2);
            }
            temp = Long.toString(powSum);
            if (powSum == 1) {
                happy = true;
                break;
            } else if (powSum == number) {
                happy = false;
                break;
            } else {
                powSum = 0;
            }
            counter++;
            if (counter == 100) {
                break;
            }
        }
    }

    public void setNumber(long number) {
        this.number = number;
        this.happy = false;
    }

    public boolean getHappy() {
        return this.happy;
    }

}
