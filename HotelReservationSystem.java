package Mini_Projects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class HotelReservationSystem {

	public static final String url = "jdbc:mysql://localhost:3306/Hotel_DB";
	public static final String user = "root";
	public static final String password = "root12345";

	static Scanner sc = new Scanner(System.in);
	static Connection connection = null;

	static {
		try {
			System.out.println(
					"+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n--------------------> HOTEL MANAGEMENT SYSTEM <--------------------\n+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");

			Class.forName("com.mysql.cj.jdbc.Driver");

			connection = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		ChooseOption();

	}

	private static void ChooseOption() {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("1. Reserve a Room");
			System.out.print("\t2. View Reservations");
			System.out.println("\t3. Get Room Number");
			System.out.print("4. Update Reservation");
			System.out.print("\t5. Delete Reservation");
			System.out.print("\t0. Exit ");

			System.out.print("\n\nChoose Option : ");

			int option = sc.nextInt();
			System.out.println();

			switch (option) {
			case 1: {
				ReserveaRoom();
				break;
			}
			case 2: {
				ViewReservations();
				break;
			}
			case 3: {
				GetRoomNumber();
				break;
			}
			case 4: {
				UpdateReservation();
				break;
			}
			case 5: {
				DeleteReservation();
				break;
			}
			case 0: {
				ExitApp();
				break;
			}
			default:
				System.out.println("Wrong Option...");

			}
		}

	}

	private static void ExitApp() {
		System.out.print("Exiting the App");
		int i = 1;
		while (i <= 3) {
			try {
				System.out.print(".");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
		System.out.println("\nThanku Have a Nice Day....");
	}

	private static void DeleteReservation() {

		System.out.print("Enter Guest id : ");
		int id = sc.nextInt();

		try {
			Statement statement = connection.createStatement();

			String DeleteQuery = "delete from Reservation where reservation_id=" + id;
			int update = statement.executeUpdate(DeleteQuery);

			if (update == 0) {
				System.out.println("Not Deleted...");
			} else {
				System.out.println("Deleted Successfully");
			}

			System.out.println();
			ChooseOption();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void UpdateReservation() {
		System.out.print("Enter id which you want to uodata data : ");
		int id = sc.nextInt();

		System.out.print("Enter New Guest name : ");
		String name = sc.next();
		name = "'" + name + "'";

		System.out.print("Enter New Room Number : ");
		int roomNo = sc.nextInt();

		System.out.print("Enter New Phone Number : ");
		String no = sc.next();
		no = "'" + no + "'";
		try {
			Statement statement = connection.createStatement();

			String UpdateQuery = "UPDATE Reservation SET guest_Name = " + name + ", Room_Number = " + roomNo
					+ ", contact_Number =" + no + " WHERE reservation_id = " + id;
			int update = statement.executeUpdate(UpdateQuery);

			if (update == 0) {
				System.out.println("Not Updated...");
			} else {
				System.out.println("Updated Successfully");
			}

			System.out.println();
			ChooseOption();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void GetRoomNumber() {
		System.out.print("Enter Guest id : ");
		int id = sc.nextInt();

		System.out.print("Enter Guest Name : ");
		String name = sc.next();

		try {
			Statement statement = connection.createStatement();

			String SelectQuery = "SELECT Room_Number FROM Reservation WHERE reservation_id = " + id
					+ " AND guest_Name = '" + name + "'";
			ResultSet resultSet = statement.executeQuery(SelectQuery);

			if (resultSet.next()) {
				System.out.println(name + " Room Number is : " + resultSet.getByte("Room_Number"));
			}
			System.out.println();
			ChooseOption();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void ViewReservations() {

		try {
			Statement statement = connection.createStatement();

			String SelectQuery = "select * from Reservation";
			ResultSet resultSet = statement.executeQuery(SelectQuery);

			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.printf("%-5s %-20s %-15s %-15s %-20s\n", "Id", "Guest_Name", "Room_Number", "Phone_Number",
					"Time");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String guestName = resultSet.getString(2);
				int roomNumber = resultSet.getInt(3);
				String phoneNumber = resultSet.getString(4);
				java.sql.Timestamp time = resultSet.getTimestamp(5);

				System.out.printf("%-5d %-20s %-15d %-15s %-20s", id, guestName, roomNumber, phoneNumber, time);
				System.out.println();

			}
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println();
			ChooseOption();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void ReserveaRoom() {

		System.out.print("Enter Guest name : ");
		String name = sc.next();
		name = "'" + name + "'";

		System.out.print("Enter Room Number : ");
		int roomNo = sc.nextInt();

		System.out.print("Enter Phone Number : ");
		String no = sc.next();
		no = "'" + no + "'";

		try {
			String InsertQuery = "Insert into reservation(guest_Name,room_Number,contact_Number) values(" + name + ","
					+ roomNo + "," + no + ")";

			Statement statement = connection.createStatement();

			int rowCount = statement.executeUpdate(InsertQuery);

			if (rowCount == 0) {
				System.out.println("\nNot Inserted...");
				ChooseOption();
			} else {
				System.out.println("\nSuccefully Inserted...");
				ChooseOption();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
}