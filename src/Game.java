public class Game {
    private String identifier;
    private String title;
    private SimpleDate date;
    private int price;

    public Game(String identifier, String title, SimpleDate date, int price) {
        this.identifier = identifier;
        this.title = title;
        this.date = date;
        this.price = price;
    }

    public String toString() {
        return this.identifier + ": " + this.title + ", released " + this.date + ", price " + this.price;
    }

}
