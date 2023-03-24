package application;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = sc.nextInt();
        System.out.print("Check-Int date (DD/MM/YYYY): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Check-Out date (DD/MM/YYYY): ");
        Date checkOut = sdf.parse(sc.next());

        if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation! Check-out date must be after Check-in date.");
        }
        else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Room number: ");
            number = sc.nextInt();
            System.out.print("Check-Int date (DD/MM/YYYY): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-Out date (DD/MM/YYYY): ");
            checkOut = sdf.parse(sc.next());


            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Error in reservation! Must be in the future ");
            }
            else if (!checkOut.after(checkIn)) {
                System.out.println("Error in reservation! Must be after check in date.");
            }
            else {
                reservation.updatesDates(checkIn, checkOut);
                System.out.println("Reservation: " + reservation);
            }
        }

        System.out.println();
        sc.close();
    }
}