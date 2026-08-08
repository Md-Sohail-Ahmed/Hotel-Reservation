import java.sql.*;
import java.util.Scanner;

public class ReservationSystem {
    static String url="jdbc:mysql://localhost:3306/hotel_bd";
    static String name="root";
    static String password="sohail@25017";

    public static void main(String[] args) {
        try(Connection connection= DriverManager.getConnection(url,name,password);
            Statement s=connection.createStatement()){

            while(true){
                System.out.println();
                System.out.println("Reservation System");
                System.out.println("1. Reserve Room");
                System.out.println("2. View Reservations");
                System.out.println("3. Update Reservations");
                System.out.println("4. Delete Reservation");
                System.out.println("0. Exit");
                System.out.println("What do you want to do");
                Scanner scanner=new Scanner(System.in);
                int choice=scanner.nextInt();

                switch (choice){
                    case 1 : ReserveRoom();
                        break;
                    case 2 : ViewReservation();
                        break;
                    case 3 : UpdateReservation();
                        break;
                    case 4 : DeleteReservation();
                        break;
                    case 0 : Exit();
                         return;
                    default:
                        System.out.println("Invlaid, choose valid operation");
                }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void ReserveRoom(){

    }
    public static void ViewReservation(){

    }
    public static void UpdateReservation(){

    }
    public static void DeleteReservation(){

    }
    public static boolean Exit(){
       return true;
    }

}
