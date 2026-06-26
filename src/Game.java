public class Game {
    private String identifier;
    private String title;
    private SimpleDate date;
    private Money price;

    public Game(String identifier, String title, SimpleDate date, Money price) {
        this.identifier = identifier;
        this.title = title;
        this.date = date;
        this.price = price;
    }

    // Returns game formatted, example 'identifier: title, released, date, price'
    public String toString() {
        return this.identifier + ": " + this.title + ", released " + this.date + ", price " + this.price;
    }

    //Returns boolean if this game object is the same as compared.
    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Game)) {
            return false;
        }

        Game comparedGame = (Game) compared;

        return (this.identifier.equals(comparedGame.identifier));
    }

    // Returns this game price.
    public Money getPrice() {
        return this.price;
    }

    // Returns this game identifier.
    public String getIdentifier() {
        return this.identifier;
    }

    // Returns this game title,
    public String getTitle() {
        return this.title;
    }

    // Returns this game date.
    public SimpleDate getReleaseDate() {
        return this.date;
    }

}
