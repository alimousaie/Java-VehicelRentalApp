package assessment.rental;

public class Path {
    private String source;
    private String destination;
    private int length;

    public Path(String source, String destination, int length) {
        this.source = source;
        this.destination = destination;
        this.length = length;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getLength() {
        return length;
    }
}