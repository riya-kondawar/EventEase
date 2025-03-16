package dao;
import model.User;

public class UserDao {
public static void save(User user) {
    System.out.println("Inside save() method");  // Debugging print
    String query = "INSERT INTO user(name, email, contact, address, password, securityQuestion, answer, status) VALUES ('"
            + user.getName() + "', '" + user.getEmail() + "', '" + user.getContact() + "', '" + user.getAddress()
            + "', '" + user.getPassword() + "', '" + user.getSecurityQuestion() + "', '" + user.getAnswer()
            + "', 'false')";

    System.out.println("Executing Query: " + query);  // Print query for debugging
    DbOperations.setDataOrDelete(query, "Registered Successfully! Wait for Admin Approval");
  }
}
