package cinema;

public class Seat {
    private final int price;
    private char mark;

    Seat(int price) {
        this.price = price;
        this.mark = 'S';
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }

    public int bookSeat() {
        mark = 'B';
        return price;
    }

    public char getMark() {
        return mark;
    }

    public boolean isSeatAvailable() {
        return 'S' == mark;
    }
}
