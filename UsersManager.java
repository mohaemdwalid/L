import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UsersManager {
   static User currentUser = null;
   static BooksManager BM = new BooksManager();
   

static HashMap<String,User> allUsers;
 public UsersManager(){
         allUsers = new HashMap<String, User>();

         User user = new Admin( "admin", "123");
         allUsers.put(user.ID, user);

         user = new Reader("user1","1234","male","mo","walid","3n shmis","02122","xdx@",false);
         allUsers.put(user.ID, user);

         user = new Reader("user2","1234","femle","ahmed","mazen","3n shmis","02124442","xdx@",true);
         allUsers.put(user.ID, user);

         user = new Reader("user3","1234","male","mo","walid","3n shmis","02132222","xdx@",true);
         allUsers.put(user.ID, user);

    }
    
    //  check login 
  public static User Login(String id, String password){
   // find the dictionary that have id name
   User result = allUsers.get(id);
   if(result !=null && result.password.equals(password)){
      return result;
   }
   else
      return null;
   }
   static void LoginView() {
      Scanner input = new Scanner(System.in);

      System.out.println("Enter User ID:");
      String ID = input.next();

      System.out.println("Enter User password:");
      String password = input.next();

      currentUser = Login(ID, password);
      if (currentUser == null){
          System.err.println("Please check your Id and password!");
      } else if (currentUser.getClass() == Reader.class) {
          viewReaderPage();
      } else if (currentUser.getClass() == Admin.class) {
         viewAdminPage();
      }
  }
    
   private static void viewReaderPage() {
      int choice;
        do {
            System.out.println("**********    Welcome to the Reader Profile    *************");
            System.out.println("			Select From The Following Options: ");
            System.out.println("**********************************************************************");
            System.out.println(currentUser.toString());

		    System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("Press 1 to view all available books");
            System.out.println("Press 2 to Rent a book");
            System.out.println("Press 3 to search for a book");
            System.out.println("Press 0 to Logout.");
            System.out.println("----------------------------------------------------------------------------------------------------------");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    BM.Display(BM.readerDisplay());
                    break;
                case 2:
                    BM.RentBook();
                    break;
                case 3:
                    BM.searchBook();
                    break;
                default:
                    System.out.println("Logout Successful");
            }
        } while (choice != 0);
        currentUser = null;
   }

   private static void  viewAdminPage() {
      int choice;
      do {
          System.out.println("******************** Welcome to the Admin Page ********************");
          System.out.println("                     Select From The Following Options: ");
          System.out.println("**********************************************************************");
          System.out.println(currentUser.toString());
          System.out.println( "----------------------------------------------------------------------------------------------------------");
          System.out.println("Press 1 to Add a book.");
          System.out.println("Press 2 to Display all Books");
          System.out.println("Press 3 to Delete a book");
          System.out.println("Press 4 to search for a book");
          System.out.println("Press 5 to Add new user");
          System.out.println("Press 6 to delet user");
          System.out.println("Press 7 to Rent a book");
          System.out.println("Press 8 to View Blocked Account");
          System.out.println("Press 9 to View Book- Order list");
          System.out.println("Press 0 to Logout.");


          System.out.println("-------------------------------------------------------------------------------------------------------");
          Scanner input = new Scanner(System.in);
          choice = input.nextInt();
          switch (choice) {
              case 1:
                   BM.addBookView(); 
                  break;
              case 2:
                  BM.Display(BM.adminDisplay());
                  break;
              case 3:
                  BM.deleteBook();
                  break;
              case 4:
                  BM.searchBook();
                  break;
              case 5 :
                  Register();   
                  break; 
              case 6: 
                  deleteUser(); 
                  break;   
              case 7:
                   BM.RentBook();
                   break;
              case 8:
                    viewBlocked();
                  break;
              case 9:
                  // 
                  break;    
              default:
                  System.out.println("Logout Successful");
          }
      } while (choice != 0);
      currentUser = null;
   }

   // create a new user (sign up)
   // boolean to check if user is already created return true if it is new one , return false if it  is already in haspmap
   public static Boolean Register(String ID,String password ,String type,String FirstName, String LastName, String Address, String CellPhone, String Email,Boolean isBlocked){
         if(allUsers.get(ID) == null){
            User newUser = new Reader(ID, password, type, FirstName,LastName, Address,CellPhone,Email,isBlocked = null);
            allUsers.put(newUser.ID, newUser);
            return true; 
         }
         return false;
   }
   static void Register() {
      Scanner input = new Scanner(System.in);

      System.out.println("Enter your ID:");
      String ID = input.next();

      System.out.println("Enter password:");
      String password = input.next();

      System.out.println("Enter Type:");
      String Type = input.next();

      System.out.println("Enter First Name:");
      String FirstName = input.next();

      System.out.println("Enter Last Name:");
      String LastName = input.next();

      System.out.println("Enter Address:");
      String Address = input.next();

      System.out.println("Enter CellPhone: ");
      String CellPhone = input.next();

      System.out.println("Enter Email: ");
      String Email = input.next();
      
      Boolean isUsed = Register(ID, password,Type ,FirstName, LastName,Address, CellPhone,Email, isUsed = false);
      if (!isUsed) {
          System.out.println("Student of this ID:" + ID + " is Already Registered.");
      }
  }

    // Delete user
   public static Boolean deleteUser(String Name) {
      return allUsers.remove(Name) != null;
   }     
   static void deleteUser() {
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the name of the user you want to delete");
    String name = input.next();
    if (deleteUser(name)) {
        System.out.println("The User is succesfully deleted");
    } else {
        System.err.println("You entered a wrong User name");
    }
}


//    view block account
   public static void viewBlocked(){
    //   Set<String> set = allUsers.keySet();
      for (String key  : allUsers.keySet()){
            if (allUsers.get(key).hashCode()) {
                allUsers.get(key);
            }
       
     }
   }

}
   

   
         
