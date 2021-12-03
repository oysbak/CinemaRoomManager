package cinema;

public class Seat {
    private final int row;
    private final int seat;
    private final int price;
    private char mark;

    Seat(int row, int seat, int price) {
        this.row = row;
        this.seat = seat;
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

    public int book() {
        this.setMark('B');
        return price;
    }

    private void setMark(char b) {
        this.mark = b;
    }
}
