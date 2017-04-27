package zadanie6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Library implements Finder, Renter {
    private List<RentalElement> rentalElementTable = new ArrayList<>();
    private Map<String, RentalElement> rentalElementByTitle = new HashMap<>();
    private List<Book> listBook = new ArrayList<>();
    private List<Paper> listPaper = new ArrayList<>();


    public Library(List<Book> bookTable, List<Paper> paperTable) {
        this.listBook = bookTable;
        this.listPaper = paperTable;

        rentalElementTable.addAll(bookTable);
        rentalElementTable.addAll(paperTable);

        for (RentalElement rt : rentalElementTable) {
            rentalElementByTitle.put(rt.getTitle(), rt);
        }
    }

    public String report() {
        //stream (java8)
        StringBuilder sb = new StringBuilder();
        rentalElementTable.forEach(rentalElement -> sb.append(rentalElement.getInfo() + "\n"));
//        rentalElementTable.forEach(rentalElement -> {
//                    System.out.println("we are in stream: " + rentalElement.getInfo());
//                }
//        );

//        String report = "Pozycje w bibliotece:\n";
//        for (RentalElement rt : rentalElementTable){
//            report += (rt.getInfo() + "\n");
//        }
//        return report;
        return sb.toString();
    }

    public void filterPapers(Type paperType) {
        listPaper.stream()
                .filter(paper -> paper.getType() == paperType)
                .forEach(System.out::println);
    }

    @Override
    public RentalElement findRentalElementByTitle(String title) {
        return rentalElementByTitle.get(title);
    }

    @Override
    public Book bestRankBook() {
        double theBestRank = Double.MIN_VALUE;
        Book theBestBook = null;

        for (Book bk : listBook) {
            if (theBestRank <= bk.getRank()) {
                theBestRank = bk.getRank();
                theBestBook = bk;
            }
        }
        return theBestBook;
    }

    @Override
    public Book fastRecomendation() {
        double theBestRank = Double.MIN_VALUE;
        Book toRent = null;

        for (Book bk : listBook) {
            if (theBestRank <= bk.getRank() & bk.isAviable()) {
                theBestRank = bk.getRank();
                toRent = bk;
            }
        }
        return toRent;
    }

    @Override
    public void rentElement(String title) {
        if (findRentalElementByTitle(title).isAviable()) {
            findRentalElementByTitle(title).setAviable(false);
        }
    }

    @Override
    public List<Book> findBooksByAutor(String author) {
        List<Book> byAuthor = new ArrayList<>();
        for (Book book : listBook) {
            if (book.getWriter().equalsIgnoreCase(author)) {
                byAuthor.add(book);
            }
        }
        return byAuthor;
    }
}
