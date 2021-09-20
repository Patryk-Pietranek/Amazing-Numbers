package numbers;

public class SquareNumber {

    private long number;
    private boolean square;

    public SquareNumber(long number) {
        this.number = number;
        this.square = false;
    }

    public void isSquare() {
        double temp = Math.sqrt(number);
        String tempNumber = Double.toString(temp);
        String[] arr = tempNumber.split("\\.");
        if (arr[1].equals("0")) {
            this.square = true;
        } else {
            this.square = false;
        }
    }

    public void setNumber(long number) {
        this.number = number;
        this.square = false;
    }

    public boolean getSquare() {
        return this.square;
    }

}
