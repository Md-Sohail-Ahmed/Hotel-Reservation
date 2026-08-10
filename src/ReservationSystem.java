import java.sql.*;
import java.util.Scanner;

public class ReservationSystem {
    static String url="jdbc:mysql://localhost:3306/hotel_db";
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
                System.out.println("3. Delete Reservation");
                System.out.println("0. Exit");
                System.out.println("What do you want to do:");
                Scanner scanner=new Scanner(System.in);
                int choice=scanner.nextInt();

                switch (choice){
                    case 1 : ReserveRoom(s, scanner);
                        break;
                    case 2 : ViewReservation(s);
                        break;
                    case 3 : DeleteReservation(s,scanner);
                        break;
                    case 0 : Exit();
                         return;
                    default:
                        System.out.print("Invlaid, choose valid operation");
                }

            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void ReserveRoom(Statement s, Scanner scanner){
        try{
            System.out.println();
            scanner.nextLine();
            System.out.println("Enter Name:");
            String name=scanner.nextLine();
            System.out.println("Enter Room No:");
            int roomNo=scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Contact No:");
            String contact=scanner.nextLine();
            s.executeUpdate("insert into reservations(guestName,roomNo,contactNo)" +
                    " values('"+name+"','"+roomNo+"','"+contact+"')");

            System.out.println("Reservation Done");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void ViewReservation(Statement s){
        try{
            System.out.println("All Reservations:");
            String query="select * from reservations;";
            ResultSet rs=s.executeQuery(query);
            while(rs.next()){
                int id=rs.getInt("reservationId");
                String name= rs.getString("guestName");
                int room=rs.getInt("roomNo");
                String contact= rs.getString("contactNo");
                String date=rs.getString("reservationDate").toString();

                System.out.println("ID : "+id+", Name : "+name+", Room No : "+room+", Contact No : "+contact+", Reservation Date : "+date);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void DeleteReservation(Statement s, Scanner scanner){
           try{
               scanner.nextLine();
               System.out.println("Enter Id which you want to delete:");
               int id=scanner.nextInt();
               scanner.nextLine();
               System.out.println("Enter Name you want to delete:");
               String name=scanner.nextLine();

               String query="delete from reservations where reservationId="+id+" and guestName='"+name+"';";
               s.executeUpdate(query);

               System.out.println("Reservation deleted");
           }catch (SQLException e){
               e.printStackTrace();
           }
    }
    public static void Exit(){
        try{
            System.out.print("Exiting");
            for(int i=0;i<5;i++){
                System.out.print(".");
                Thread.sleep(100);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
