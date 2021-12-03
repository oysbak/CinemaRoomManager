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
            for (int seatNo = 0; seatNo < seatsPrRow; seatNo++) {
                seats[rowNo][seatNo] = new Seat(price);
            }
        }
    }

    public static void main(String[] args) {
        // Write your code here
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
                    cinema.sellTicket();
                    cinema.drawCinema();
                    break;
                case 3:
                    cinema.showStatistics();
            }
        }
    }

    private int displayMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        return scanner.nextInt();
    }

    private void showStatistics() {
        int noPurchasedTickets = 0;
        int valuePurchasedTickets = 0;
        int totalPotentialIncome = 0;
        for (int row = 0; row < noOfRows; row++) {
            for (int seat = 0; seat < seatsPrRow; seat++) {
                Seat currentSeat = seats[row][seat];
                noPurchasedTickets += currentSeat.getMark() == 'B' ? 1 : 0;
                valuePurchasedTickets += currentSeat.getMark() == 'B' ? currentSeat.getPrice() : 0;
                totalPotentialIncome += currentSeat.getPrice();
            }
        }
        System.out.println("Number of purchased tickets: " + noPurchasedTickets);
        double percentage = noPurchasedTickets / (double) totalSeats * 100;
        System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
        System.out.println("Current income: $" + valuePurchasedTickets);
        System.out.println("Total income: $" + totalPotentialIncome);
    }

    private void sellTicket() {
        boolean doContinue = true;
        do {
            System.out.println("Enter a row number:");
            int rowNo = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seatNo = scanner.nextInt();
            try {
                Seat seat = this.seats[rowNo - 1][seatNo - 1];
                if (seat.isSeatAvailable()) {
                    System.out.println("Ticket price: $" + seat.bookSeat());
                    doContinue = false;
                } else {
                    System.out.println("That ticket has already been purchased!");
                }
            } catch (Exception e) {
                System.out.println("Wrong input!");
            }
        } while (doContinue);
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