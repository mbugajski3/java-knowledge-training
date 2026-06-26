public class Money {
    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }

    // Returns money value formatted, example 'euros.cents euro', if cents < 10, returns 'euros.0cents euro'
    @Override
    public String toString() {
        if (this.cents < 10) {
            return this.euros + "." + "0" + this.cents + " euro";
        }
        return this.euros + "." + this.cents + " euro";
    }

    // Returns new Money object with declared amount added to this object.
    // This object stays unchanged.
    public Money plus(Money addition) {
        int totalEuros = this.euros + addition.euros;
        int totalCents = this.cents + addition.cents;

        while (totalCents > 100) {
            totalEuros++;
            totalCents = totalCents - 100;

        }
        return new Money(totalEuros, totalCents);
    }

    // Returns new Money object with declared amount subtracted from this object.
    // This object stays unchanged.
    public Money minus(Money addition) {
        int thisTotalCents = (this.euros * 100) - this.cents;
        int additionTotalCents = (addition.euros * 100) - addition.cents;

        int difference = thisTotalCents - additionTotalCents;

        if (difference < 0) {
            difference = 0;
        }

        int newEuros = difference / 100;
        int newCents = difference % 100;

        return new Money(newEuros, newCents);
    }

    // Returns this euros.
    public int getEuros() {
        return this.euros;
    }

    // Returns this cents.
    public int getCents() {
        return this.cents;
    }
}
