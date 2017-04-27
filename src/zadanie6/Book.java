package zadanie6;

public class Book extends RentalElement {
    private static int counter = 0;
    private String writer;
    private double rank;
    private int pages;

    public Book(String title, int isbn, String writer, double rank, int pages) {
        super(title, isbn);
        this.writer = writer;
        this.rank = rank;
        this.pages = pages;
        counter++;
    }

    public String getWriter() {
        return writer;
    }

    public double getRank() {
        return rank;
    }

    @Override
    public String getInfo() {
        return "Book: " + getTitle() + " ;dostępność: " + isAviable();
    }

    @Override
    public String toString() {
        return getInfo() + " ;writer: " + writer + " ;pages: " + pages;
    }
}
