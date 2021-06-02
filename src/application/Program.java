package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptoins.DomainException;

public class Program {

	public static void main(String[] args) throws DomainException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int roomNumber = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy) : ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) : ");
			Date checkOut = sdf.parse(sc.next());
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.print("Reservation: " + reservation.toString());

			System.out.println();
			System.out.println("Enter data to update reservation: ");
			
			System.out.print("Check-in date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy) : ");
			checkOut = sdf.parse(sc.next());
			reservation.updateDates(checkIn, checkOut);
		}
		catch (ParseException e) {
			System.out.print("Invalid date format");
		}
		
//		catch (IllegalArgumentException e) {
		catch (DomainException e) {
			System.out.print("Error in reservation: " + e.getMessage());
		}
		sc.close();
	}
}
