package numbers;

public class PalindromicNumber {

    private long number;
    private boolean palindromic;

    public PalindromicNumber(long number) {
        this.number = number;
        this.palindromic = false;
    }

    public void isPalindromic() {
        String temp = Long.toString(this.number);
        StringBuilder sb = new StringBuilder(temp);
        sb.reverse();
        String revTemp = sb.toString();
        if(revTemp.equals(temp)){
            palindromic = true;
        } else {
            palindromic = false;
        }
    }

    public void setNumber(long number) {
        this.number = number;
        this.palindromic = false;
    }

    public boolean getPalindromic() {
        return this.palindromic;
    }

}
