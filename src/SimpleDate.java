public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return this.day + " . " + this.month + " . " + this.year;
    }

    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof SimpleDate)) {
            return false;
        }
        SimpleDate comparedDate = (SimpleDate) compared;

        return (this.day == comparedDate.day &&
                this.month == comparedDate.month &&
                this.year == comparedDate.year);
    }


}
