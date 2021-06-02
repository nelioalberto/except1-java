package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		// teste
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy) : ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy) : ");
		Date checkOut = sdf.parse(sc.next());
		if (!checkOut.after(checkIn)) {
			System.out.print("Error reservation: Check-out date must be after Check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.print("Reservation: " + reservation.toString());

			System.out.println();
			System.out.println("Enter data to update reservation: ");

			System.out.print("Check-in date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) : ");
			checkOut = sdf.parse(sc.next());

     		String error = reservation.updateDates(checkIn, checkOut);
     		if (error != null) {
     			System.out.print("Error in reservation: " + error);
     		}
     		else {
     			System.out.print("Reservation: " + reservation.toString());
			}

		}

		sc.close();

	}

}
