package BookIT;

public class Book {
    private long bookID =0;
    private long seller = 0;
    private String title = "";
    private String writer = "";
    private String publisher = "";
    private int year = 2023;
    private String synopsis = "";
    private int price = 0;

    //constructor
    public Book(long seller, String title, String writer, String publisher, int year, String synopsis, int price){
        this.seller = seller;
        this.title = title;
        this.writer = writer;
        this.publisher =publisher;
        this.year = year;
        this.synopsis = synopsis;
        this.price =price;
        this.bookID = Integer.parseInt(createID())
    }

    private synchronized String createID()
    {
        return String.valueOf(bookID++);
    }
    
}