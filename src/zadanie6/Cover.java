package zadanie6;

public class Cover {
    private double size;
    private Book book;

    public Cover(double size, Book book) {
        this.size = size;
        this.book = book;
    }

    public double getSize() {
        return size;
    }

    public Book getBook() {
        return book;
    }
}
