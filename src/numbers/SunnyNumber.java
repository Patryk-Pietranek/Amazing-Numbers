package numbers;

public class SunnyNumber {

    private long number;
    private boolean sunny;

    public SunnyNumber(long number) {
        this.number = number;
        this.sunny = false;
    }

    public void isSunny() {
        SquareNumber squareNumber = new SquareNumber(number + 1);
        squareNumber.isSquare();
        if (squareNumber.getSquare()) {
            this.sunny = true;
        } else {
            this.sunny = false;
        }
    }

    public void setNumber(long number) {
        this.number = number;
        this.sunny = false;
    }

    public boolean getSunny() {
        return this.sunny;
    }
}
