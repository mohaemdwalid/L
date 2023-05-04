import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class main {
    static UsersManager UM = new UsersManager();
    static User currentUser = null;
    static BooksManager BM = new BooksManager();

    public static void main(String[] args) {
        viewHomePage();
    }

    static void viewHomePage() {
        int choice;
        do {
            System.out.println("\n ------------------------   Welcome to Library Management System   ------------------------\n");
            LocalDate dt = LocalDate.now();
				 dt = LocalDate.now();
		    System.out.println("				 Date:	" + dt );
            System.out.println("				 Select From The Following Options:              ");
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("Press 1 to Sign up");
            System.out.println("Press 2 to Sign in");
            System.out.println("Press 0 to Exit .");
            System.out.println("----------------------------------------------------------------------------------------------------------");

            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    Register();
                    break;
                case 2:
                    Login();
                    break;
                default:
                    System.out.println("Exit Successful");
            }
        } while (choice != 0);
    }

    static void viewReaderPage() {
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
                    Display(BM.readerDisplay());
                    break;
                case 2:
                    RentBook();
                    break;
                case 3:
                    searchBook();
                    break;
                default:
                    System.out.println("Logout Successful");
            }
        } while (choice != 0);
        currentUser = null;
    }

    static void viewAdminPage() {
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
                    addBook();
                    break;
                case 2:
                    Display(BM.adminDisplay());
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5 :
                    Register();   
                    break; 
                case 6: 
                    deleteUser(); 
                    break;   
                case 7:
                     RentBook();
                     break;
                case 8:
                    // UM.viewBlocked();
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
        
        Boolean isUsed = UM.Register(ID, password,Type ,FirstName, LastName,Address, CellPhone,Email, isUsed = false);
        if (!isUsed) {
            System.out.println("Student of this ID:" + ID + " is Already Registered.");
        }
    }

    static void Login() {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter User ID:");
        String email = input.next();

        System.out.println("Enter User password:");
        String password = input.next();

        currentUser = UM.Login(email, password);
        if (currentUser == null){
            System.err.println("Please check your Id and password!");
        } else if (currentUser.getClass() == Reader.class) {
            viewReaderPage();
        } else if (currentUser.getClass() == Admin.class) {
            viewAdminPage();
        }
    }

    

    
    static void Display(ArrayList<Books> all) {
        for (Books b : all) {
            System.out.println(b.toString());
        }
    }

    static void deleteBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the book you want to delete");
        String name = input.next();
        if (BM.deleteBook(name)) {
            System.out.println("The book is succesfully deleted");
        } else {
            System.err.println("You entered a wrong book name");
        }
    }
    static void deleteUser() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the user you want to delete");
        String name = input.next();
        if (UM.deleteUser(name)) {
            System.out.println("The User is succesfully deleted");
        } else {
            System.err.println("You entered a wrong User name");
        }
    }

    static void RentBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the book you want to rent");
        String name = input.nextLine();
        Books currentBook = BM.getBook(name);
        if (currentBook != null) {
            if (currentBook.bookQty > 0) {
                currentBook.bookQty--;
            } else {
                System.err.println("There are no available books ");
            }
        } else {
            System.err.println("There is no book with this name ");
        }
    }

    static void searchBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the name of the book you want to order");
        String name = input.next();
        Books currentBook = BM.getBook(name);
        if (currentBook != null) {
            System.out.println(currentBook.toString());
        } else {
            System.err.println("There is no book with this name ");
        }
    }

    static void addBook() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter book name:");
        String name = input.next();

        System.out.println("Enter book author:");
        String author = input.next();

    
        System.out.println("Enter stock quantity:");
        int stock = input.nextInt();

        Boolean isUsed = BM.addBook(name, author, stock);
        if (!isUsed) {
            System.out.println("This book " + name + " is Already in library.");
        }
    }
    
}