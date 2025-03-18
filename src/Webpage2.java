import java.util.Scanner;

class InvalidDetailsException extends Exception {
    public InvalidDetailsException(String message) {
        super(message);
    }
}

class User {
    private String name, email, contact, password;

    public void register(Scanner sc) {
        System.out.println("\n--- Register Yourself ---");

        System.out.print("Enter Name: ");
        this.name = sc.nextLine();

        System.out.print("Enter Email: ");
        this.email = sc.nextLine();

        System.out.print("Enter Contact No.: ");
        this.contact = sc.nextLine();

        System.out.print("Create a Password: ");
        this.password = sc.nextLine();

        System.out.println("\nRegistration Successful!\n");
    }

    public boolean login(Scanner sc) throws InvalidDetailsException {
        System.out.println("\n--- Login ---");

        System.out.print("Enter Email: ");
        String inputEmail = sc.nextLine();

        System.out.print("Enter Password: ");
        String inputPassword = sc.nextLine();

        if (inputEmail.equals(this.email) && inputPassword.equals(this.password)) {
            System.out.println("\nLogin Successful!\n");
            return true;
        } else {
            throw new InvalidDetailsException("Incorrect email or password.");
        }
    }

    public void viewProfile(Scanner sc) {
        System.out.println("\n--- Your Profile ---");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Contact: " + contact);

        System.out.print("\nDo you want to update your information? (Y/N): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            register(sc);
            System.out.println("Info Updated Successfully!\n");
        }
    }
}

public class Webpage2 {
    public static void main(String[] args) {
        System.out.println("------- WELCOME TO THE LOGIN PAGE -------");

        Scanner sc = new Scanner(System.in); // Single Scanner instance
        User user = new User();
        user.register(sc);

        while (true) {
            try {
                if (user.login(sc)) break;
            } catch (InvalidDetailsException e) {
                System.out.println(e.getMessage() + " Please try again.");
            }
        }

        user.viewProfile(sc);
        sc.close(); // Close the scanner at the end
    }
}
