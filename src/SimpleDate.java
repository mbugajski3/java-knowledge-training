import java.util.Scanner;

public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Returns the date formated, example 'day.month.year'.
    @Override
    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    // Returns boolean if the compared object date is the same.
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

    // Returns a new SimpleDate object advanced by the given number of days.
    // The original date object is unchanged.
    // Each month is assumed to have 30 days.
    // In the future method will be updated to represent real month lengths.
    public SimpleDate afterNumberOfDays(int days) {
        SimpleDate newDate = new SimpleDate(this.day, this.month, this.year);

        newDate.day = newDate.day + days;

        while (newDate.day > 30) {
            newDate.day = newDate.day - 30;
            newDate.month++;
        }

        while (newDate.month > 12) {
            newDate.month = newDate.month - 12;
            newDate.year++;
        }

        return newDate;
    }
}
