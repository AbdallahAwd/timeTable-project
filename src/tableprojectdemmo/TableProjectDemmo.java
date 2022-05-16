/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tableprojectdemmo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;






public class TableProjectDemmo{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/timetable?user=root&password=2 33 444 5555");
            statement = connection.createStatement();
            // add to database
//            connection.prepareStatement("insert into user(name,password) values('Ahmed','0258')").executeUpdate();
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the name");
            String namey = in.nextLine();
            System.out.println("Enter the password");
            String passwordy = in.nextLine();

            String name = "";

            //read from database
            resultSet = statement.executeQuery("select * from user where name= '"+namey+"' AND password = '"+passwordy+"'");
            while (resultSet.next()) {
               String id= resultSet.getString("id");
               name = resultSet.getString("name");
               String password= resultSet.getString("password");
                System.out.println("id "+id +" name "+name+" password "+password);
                
            }
            if(name.equals("")){
                System.out.println("Error user is not found");
            }else {
                System.out.println(namey+" Correct user found");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }
    
}
