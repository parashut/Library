package zadanie6;

import java.util.ArrayList;
import java.util.List;

public class Run {

    public static void main(String[] args) {

        Book hobbit = new Book("Hobbit", 111, "Tolkien", 8.5, 600);
        Book lordofrings = new Book("Lord of Rings", 222, "Tolkien", 9.5, 800);
        Book thinkinginjava = new Book("Thinking in Java", 333, "Bruce Eckel", 7.1, 1200);

        Paper wiek21 = new Paper("21 WIEK", 555, Type.MONTHLY, "A4");
        Paper playboy = new Paper("Playboy", 666, Type.DAILY, "A4");

        List<Book> books = new ArrayList<>();
        List<Paper> papers = new ArrayList<>();

        books.add(hobbit);
        books.add(lordofrings);
        books.add(thinkinginjava);

        papers.add(wiek21);
        papers.add(playboy);

        Library szkolna = new Library(books, papers);

        String polecana1 = szkolna.fastRecomendation().getTitle();
        System.out.println("Polecana (dostępna) pozycja: " + polecana1);
        System.out.println("dostępność: " + szkolna.findRentalElementByTitle(polecana1).isAviable());
        szkolna.rentElement(polecana1);
        System.out.println("dostępność: " + szkolna.findRentalElementByTitle(polecana1).isAviable());
        System.out.println();

        String polecana2 = szkolna.fastRecomendation().getTitle();
        System.out.println("Polecana (dostępna) pozycja: " + polecana2);
        System.out.println("dostępność: " + szkolna.findRentalElementByTitle(polecana2).isAviable());
        szkolna.rentElement(polecana2);
        System.out.println("dostępność: " + szkolna.findRentalElementByTitle(polecana2).isAviable());
        System.out.println();

        System.out.println("Polecana (dostępna) pozycja: " + szkolna.fastRecomendation().getTitle());
        System.out.println();

        System.out.println(szkolna.report());
        szkolna.filterPapers(Type.DAILY);
//        szkolna.report();

        System.out.println(szkolna.findBooksByAutor("Tolkien"));
    }
}
