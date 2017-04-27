package zadanie6;

public abstract class RentalElement {
    private String title;
    private int isbn;
    private boolean isAviable = true;

    public RentalElement(String title, int isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return "Tytuł: " + title + " ,dostępność: " + isAviable;
    }

    public boolean isAviable() {
        return isAviable;
    }

    public void setAviable(boolean aviable) {
        isAviable = aviable;
    }
}
