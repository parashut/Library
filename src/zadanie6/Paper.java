package zadanie6;

public class Paper extends RentalElement {
    private static int counter = 0;
    private Type type;
    private String format;

    public Paper(String title, int isbn, Type type, String format) {
        super(title, isbn);
        this.type = type;
        this.format = format;
        counter++;
    }

    @Override
    public String getInfo() {
        return "Newspaper: " + getTitle() + " ;dostępność: " + isAviable();
    }

    @Override
    public String toString() {
        return getInfo() + " ;typ: " + type + " format; " + format;
    }

    public Type getType() {
        return type;
    }
}