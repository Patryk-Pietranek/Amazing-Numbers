package numbers;

import java.util.ArrayList;
import java.util.List;

public class NumbersController {

    private BuzzNumber buzzNumber;
    private DuckNumber duckNumber;
    private GapfulNumber gapfulNumber;
    private PalindromicNumber palindromicNumber;
    private SpyNumber spyNumber;
    private SquareNumber squareNumber;
    private SunnyNumber sunnyNumber;
    private JumpingNumber jumpingNumber;
    private HappyNumber happyNumber;
    private SadNumber sadNumber;
    private boolean isEven;
    private boolean isOdd;
    private int consecutive;
    private long number;
    private boolean exit;
    private List<String> userProperties;

    public NumbersController() {
        this.isEven = false;
        this.isOdd = false;
        this.consecutive = 0;
        this.number = 0;
        this.exit = false;
        this.userProperties = new ArrayList<>();
    }

    public void setNumber(long number) {
        if (number == 0) {
            System.out.println("Goodbye!");
            this.exit = true;
        } else if (number < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
        } else {
            this.number = number;
            this.buzzNumber = new BuzzNumber(number);
            this.duckNumber = new DuckNumber(number);
            this.gapfulNumber = new GapfulNumber(number);
            this.palindromicNumber = new PalindromicNumber(number);
            this.spyNumber = new SpyNumber(number);
            this.squareNumber = new SquareNumber(number);
            this.sunnyNumber = new SunnyNumber(number);
            this.jumpingNumber = new JumpingNumber(number);
            this.happyNumber = new HappyNumber(number);
            this.sadNumber = new SadNumber(number);
        }
    }

    public void setUserProperties(List<String> properties) {
        for (int i = 0; i < properties.size(); i++) {
            userProperties.add(properties.get(i).toLowerCase());
        }
    }

    public boolean getExit() {
        return this.exit;
    }

    public void start() {
        determine(number);
        if (consecutive == 0) {
            System.out.println("Properties of " + number);
            System.out.println("buzz: " + buzzNumber.getBuzz());
            System.out.println("duck: " + duckNumber.getDuck());
            System.out.println("palindromic: " + palindromicNumber.getPalindromic());
            System.out.println("gapful: " + gapfulNumber.getGapful());
            System.out.println("spy: " + spyNumber.getSpy());
            System.out.println("square: " + squareNumber.getSquare());
            System.out.println("sunny: " + sunnyNumber.getSunny());
            System.out.println("jumping: " + jumpingNumber.getJumping());
            System.out.println("happy: " + happyNumber.getHappy());
            System.out.println("sad: " + sadNumber.getSad());
            System.out.println("even: " + isEven);
            System.out.println("odd: " + isOdd);
        } else if (userProperties.size() == 0) {
            for (long i = number; i < number + consecutive; i++) {
                setNumbers(i);
                determine(i);
                findNumbersWithProperties(i);
            }
        } else {
            long n = number;
            while (consecutive != 0) {
                setNumbers(n);
                determine(n);
                findNumbersWithProperties(n);
                n++;
            }
        }
    }

    private void setNumbers(long number) {
        buzzNumber.setNumber(number);
        duckNumber.setNumber(number);
        palindromicNumber.setNumber(number);
        gapfulNumber.setNumber(number);
        spyNumber.setNumber(number);
        squareNumber.setNumber(number);
        sunnyNumber.setNumber(number);
        jumpingNumber.setNumber(number);
        happyNumber.setNumber(number);
        sadNumber.setNumber(number);
    }

    private void findNumbersWithProperties(long number) {
        List<String> numberProperties = new ArrayList<>();
        String title = number + " is ";
        List<String> userMinusProperties = new ArrayList<>();
        List<String> userNormalProperties = new ArrayList<>();
        for (int i = 0; i < userProperties.size(); i++) {
            if (userProperties.get(i).contains("-")) {
                userMinusProperties.add(userProperties.get(i).substring(1));
            } else {
                userNormalProperties.add(userProperties.get(i));
            }
        }
        addNumberProperties(numberProperties);
        if (userProperties.size() == 0) {
            printList(title, numberProperties);
        } else {
            int counterNormal = userNormalProperties.size();
            int counterMinus = userMinusProperties.size();
            boolean canPrint = false;
            for (int i = 0; i < userNormalProperties.size(); i++) {
                if (numberProperties.contains(userNormalProperties.get(i))) {
                    counterNormal--;
                }
            }
            if (counterNormal == 0) {
                canPrint = true;
            }
            for (int i = 0; i < userMinusProperties.size(); i++) {
                if (!numberProperties.contains(userMinusProperties.get(i))) {
                    counterMinus--;
                } else {
                    counterMinus++;
                }
            }
            if (counterMinus != 0) {
                canPrint = false;
            }
            if (canPrint) {
                printList(title, numberProperties);
                consecutive--;
            }
        }
    }

    private void printList(String title, List<String> list) {
        System.out.print(title);
        for (int i = 0; i < list.size(); i++) {
            if (i < list.size() - 1) {
                System.out.print(list.get(i) + ", ");
            } else {
                System.out.print(list.get(i));
            }
            if (i == list.size() - 1) {
                System.out.print("\n");
            }

        }
    }

    private void determine(long number) {
        buzzNumber.isBuzz();
        duckNumber.isDuck();
        gapfulNumber.isGapful();
        palindromicNumber.isPalindromic();
        spyNumber.isSpy();
        squareNumber.isSquare();
        sunnyNumber.isSunny();
        jumpingNumber.isJumping();
        happyNumber.isHappy();
        sadNumber.isSad();
        isEven(number);
        isOdd(number);
    }

    private void addNumberProperties(List<String> numberProperties) {
        if (buzzNumber.getBuzz()) {
            numberProperties.add("buzz");
        }
        if (duckNumber.getDuck()) {
            numberProperties.add("duck");
        }
        if (palindromicNumber.getPalindromic()) {
            numberProperties.add("palindromic");
        }
        if (gapfulNumber.getGapful()) {
            numberProperties.add("gapful");
        }
        if (spyNumber.getSpy()) {
            numberProperties.add("spy");
        }
        if (squareNumber.getSquare()) {
            numberProperties.add("square");
        }
        if (sunnyNumber.getSunny()) {
            numberProperties.add("sunny");
        }
        if (jumpingNumber.getJumping()) {
            numberProperties.add("jumping");
        }
        if (happyNumber.getHappy()) {
            numberProperties.add("happy");
        }
        if (sadNumber.getSad()) {
            numberProperties.add("sad");
        }
        if (isEven) {
            numberProperties.add("even");
        }
        if (isOdd) {
            numberProperties.add("odd");
        }
    }

    public void setConsecutive(int consecutive) {
        if (consecutive > 0) {
            this.consecutive = consecutive;
        } else {
            System.out.println("The second parameter should be a natural number.");
        }
    }

    private void isEven(long number) {
        isEven = number % 2 == 0;
    }

    private void isOdd(long number) {
        isOdd = number % 2 == 1;
    }

}
