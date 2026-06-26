public class Money {
    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }
    @Override
    public String toString() {
        if (this.cents < 10) {
            return this.euros + "." + "0" + this.cents + " euro";
        }
        return this.euros + "." + this.cents + " euro";
    }
}
