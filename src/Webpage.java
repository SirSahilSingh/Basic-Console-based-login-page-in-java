import java.util.Scanner;

class InvalidDetails extends Exception {
    public InvalidDetails(String message) {
        super(message);
    }
}

class Register {
    String Name,Email,Contact,Password;

     public void putData(){
       System.out.println(" Let's Register Yourself First");

       Scanner sc = new Scanner(System.in);

       System.out.println("Name: ");
       Name = sc.nextLine();
       System.out.println("Email: ");
       Email = sc.nextLine();
       System.out.println("Contact No.: ");
       Contact = sc.nextLine();
       System.out.println("Create a Password: ");
       Password = sc.nextLine();

       System.out.println("Congrats!!! You have Registered Yourself Successfully.");
       System.out.println();
       System.out.println("Login Yourself to move Ahead");
   }
}

class  Login extends Register{
    String Email2,Pw;

    public void setData() throws InvalidDetails{
       Scanner sc = new Scanner(System.in);
        System.out.println("Email: ");
        Email2 = sc.nextLine();
        System.out.println("Password: ");
        Pw = sc.nextLine();

        if(Email2.equals(Email) && Pw.equals(Password)){
            System.out.println("You Have Logged IN Successfully");
        }
        else{
            throw new InvalidDetails("Incorrect Details.Try Again");
        }
    }
}
class Profile extends Register{
    String x;
    public void myData(){
        System.out.println("-----YOUR PROFILE-----");
        System.out.println("Name: "+Name);
        System.out.println("Email: "+Email);
        System.out.println("Contact: "+Contact);
       // System.out.println(String.format("Name: %s, Email: %s, Contact: %s", Name, Email, Contact));
        System.out.println("Do you want to Update the Info ?(Y/N)");
        Scanner sc = new Scanner(System.in);
        x = sc.nextLine();
    }
}
public class Webpage    {
    public static void main(String[] args) {
        System.out.println("-------WELCOME TO THE LOGIN PAGE-------");
        Login obj = new Login();
        Profile obj2 = new Profile();
        obj.putData();
        try{
            obj.setData();
        }
        catch(InvalidDetails e){
            System.out.println("Incorrect Details entered. Try again :(");
        }
        obj2.myData();
        if(obj2.x.equalsIgnoreCase("Y")){
            obj.putData();
            System.out.println("Info Updated Successfully");
        }
    }
}
