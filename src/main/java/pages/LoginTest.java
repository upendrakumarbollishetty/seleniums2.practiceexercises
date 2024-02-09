package pages;


import org.testng.annotations.Test;
import utilities.ExcelUtility;

public class LoginTest {
    @Test
    public void testLogin() {
        String[][] testData = ExcelUtility.readTestData();
        for (String[] data : testData) {
            String username = data[0];
            String password = data[1];
            String status = data[2];
            // Use username, password, and status for login test
            System.out.println("Username: " + username + ", Password: " + password + ", Status: " + status);
        }
    }
}





