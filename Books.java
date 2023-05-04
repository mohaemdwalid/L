public class Books {
    public String bookName;
	public String authorName;
	public int bookQty;

    public Books(String bookName, String authorName, int bookQty) {
        this.bookName = bookName;
        this.authorName = authorName;
        this.bookQty = bookQty;
    }
    @Override
    public String toString()
    {
    return " " + bookName + " " + authorName + " " + bookQty;
   
    }
}