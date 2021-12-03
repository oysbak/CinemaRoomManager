package cinema;

import java.util.Scanner;

public class Cinema {
    private final Seat[][] seats;
    private final int noOfRows;
    private final int seatsPrRow;
    private final int totalSeats;
    Scanner scanner = new Scanner(System.in);

    Cinema() {
        // "Build" the Cinema
        System.out.println("Enter the number of rows: ");
        this.noOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row: ");
        this.seatsPrRow = scanner.nextInt();
        this.totalSeats = noOfRows * seatsPrRow;
        this.seats = new Seat[noOfRows][seatsPrRow];
        // Create seats and calculate price
        for (int rowNo = 0; rowNo < noOfRows; rowNo++) {
            int price = totalSeats <= 60 ? 10
                    : noOfRows / (rowNo + 1) > 1 ? 10 : 8;
            for (int seat = 0; seat < seatsPrRow; seat++) {
                seats[rowNo][seat] = new Seat(rowNo, seat, price);
            }
        }
    }

    public static void main(String[] args) {
        // Write your code here
        //debug();
        Cinema cinema = new Cinema();
        boolean doContinue = true;
        while (doContinue) {
            switch (cinema.displayMenu()) {
                case 0:
                    doContinue = false;
                    break;
                case 1:
                    cinema.drawCinema();
                    break;
                case 2:
                    cinema.drawCinema();
                    cinema.sellTicket(new Customer());
                    cinema.drawCinema();
                    break;
            }
        }
    }

    static void debug() {
        System.out.println("Debug rules!");
    }

    private int displayMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
        return scanner.nextInt();
    }

    private void calculateIncome() {
        System.out.println("Total income:");
        System.out.println("$" + ProfitCalculator.calculate(noOfRows, seatsPrRow));
    }

    private void sellTicket(Customer customer) {
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();
        System.out.println("Ticket price: $" + this.bookSeat(row, seat));
    }

    private int bookSeat(int row, int seat) {
        return seats[row - 1][seat - 1].book();
    }

    private void drawCinema() {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < seatsPrRow; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int row = 0; row < noOfRows; row++) {
            System.out.print(row + 1);
            for (int seat = 0; seat < seatsPrRow; seat++) {
                System.out.print(" " + seats[row][seat]);
            }
            System.out.println();
        }
    }
}