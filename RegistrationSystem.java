import java.util.Scanner;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.io.BufferedReader;
import java.io.FileReader;

public class RegistrationSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== AUTH SYSTEM =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter username: ");
                String user = sc.nextLine();
                System.out.print("Enter password: ");
                String pass = sc.nextLine();
                register(user, pass);
            } else if (choice == 2) {
                System.out.print("Enter username: ");
                String user = sc.nextLine();
                System.out.print("Enter password: ");
                String pass = sc.nextLine();
                login(user, pass);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());

            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                String s = Integer.toHexString(0xff & b);
                if (s.length() == 1)
                    hex.append('0');
                hex.append(s);
            }
            return hex.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public static void register(String username, String password) {
        // 🔴 Check first
        if (userExists(username)) {
            System.out.println("Username already exists ❌");
            return;
        }
        String hashed = hashPassword(password);
        try {
            FileWriter fw = new FileWriter("users.txt", true);
            fw.write(username + "," + hashed + "\n");
            fw.close();
            System.out.println("User Registered ✅");
        } catch (Exception e) {
            System.out.println("Error saving user");
        }
    }

    public static void login(String username, String password) {
        String hashedInput = hashPassword(password);
        try {
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String fileUser = parts[0];
                String filePass = parts[1];
                if (fileUser.equals(username) && filePass.equals(hashedInput)) {
                    System.out.println("Login Successful ✅");
                    br.close();
                    return;
                }
            }
            br.close();
            System.out.println("Invalid Username or Password ❌");
        } catch (Exception e) {
            System.out.println("Error reading file");
        }
    }

    public static boolean userExists(String username) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("users.txt"));

            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                if (parts[0].equals(username)) {
                    br.close();
                    return true; // user mil gaya
                }
            }

            br.close();
        } catch (Exception e) {
            // file first time empty ho sakti hai
        }

        return false; // user nahi mila
    }
}