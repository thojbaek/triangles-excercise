package shapes;

/**
 *
 * @author tth
 */
public class Triangle {
    private final long id;
    private final String content;
    
    public Triangle(long id, String content) {
        this.id = id;
        this.content = content;
    }
    
    public long getId() {
        return id;
    }
    
    public String getContent() {
        return content;
    }
}
