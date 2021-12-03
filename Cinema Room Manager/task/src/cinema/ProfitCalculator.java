package cinema;

public class ProfitCalculator {
    public static int calculate(int totalRows, int seatsPrRow) {
        int seatsTotal = totalRows * seatsPrRow;
        if (seatsTotal > 60) {
            int expensiveRows = totalRows / 2;
            int cheapRows = totalRows - expensiveRows;
            return expensiveRows * seatsPrRow * 10 + cheapRows * seatsPrRow * 8;
        } else {
            return 10 * seatsTotal;
        }
    }
}
