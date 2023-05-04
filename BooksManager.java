import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class BooksManager {

 HashMap<String, Books> allBooks;

//  create 2 book in stock
 public BooksManager() {
        allBooks = new HashMap<String, Books>();

        Books newBook = new Books("Rich Dad Poor Dad", "Robert T. Kiyosaki ", 10);
        allBooks.put(newBook.bookName, newBook);

        newBook = new Books("Atomic Habits", "James Clear ", 1);
        allBooks.put(newBook.bookName, newBook);

       //  newBook = new Books("The 7 Habits of Highly Effective People", "Stephen R. Covey", 1);
       //  allBooks.put(newBook.bookName, newBook);
 }
//  Add new book 
 public Boolean addBook(String bookName, String authorName, int bookQty) {
        if (allBooks.get(bookName) == null) {
            Books newBook = new Books(bookName, authorName, bookQty);
                allBooks.put(newBook.bookName, newBook);
            return true;
        }
        return false;
 }

// Delete book
public Boolean deleteBook(String Name) {
        return allBooks.remove(Name) != null;
}
// display all admin
public ArrayList<Books> adminDisplay(){
        ArrayList<Books> result = new ArrayList<>();
        for (Map.Entry<String, Books> entry : allBooks.entrySet()) {
        //String key = entry.getKey();
        Books val = entry.getValue();
        result.add(val);
        }
        return result;
 }
//  display all reader
 public ArrayList<Books> readerDisplay(){
        ArrayList<Books> result = new ArrayList<>();
        for (Map.Entry<String, Books> entry : allBooks.entrySet()) {
        //String key = entry.getKey();
        Books val = entry.getValue();
        if(val.bookQty > 0)
            result.add(val);
        }
        return result;
 }
//search for a book
public Books getBook(String name) {
     return allBooks.get(name);
}
}