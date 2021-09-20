package numbers;

public class JumpingNumber {

    private long number;
    private boolean jumping;

    public JumpingNumber(long number) {
        this.number = number;
        this.jumping = false;
    }

    public void isJumping() {
        String temp = Long.toString(number);
        if (temp.length() == 1) {
            this.jumping = true;
        } else {
            for (int i = 0; i < temp.length() - 1; i++) {
                StringBuilder firstString = new StringBuilder();
                StringBuilder secondString = new StringBuilder();
                firstString.append(temp.charAt(i));
                secondString.append(temp.charAt(i + 1));
                int first = Integer.parseInt(firstString.toString());
                int second = Integer.parseInt(secondString.toString());
                if (first - second == 1 || first - second == -1) {
                    this.jumping = true;
                } else {
                    this.jumping = false;
                    break;
                }
            }
        }
    }

    public void setNumber(long number) {
        this.number = number;
        this.jumping = false;
    }

    public boolean getJumping() {
        return this.jumping;
    }
}
