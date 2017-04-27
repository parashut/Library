package zadanie6;


import java.util.List;

public interface Finder {
    List<Book> findBooksByAutor(String author);
    Book fastRecomendation();
    Book bestRankBook();
}
