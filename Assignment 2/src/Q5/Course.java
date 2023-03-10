import java.util.ArrayList;

public class Course 
{
    private int code;
    private ArrayList<Book> books;

    public Course(int code, ArrayList<Book> books)
    {
        this.code = code;
        this.books = books;
    }
}
