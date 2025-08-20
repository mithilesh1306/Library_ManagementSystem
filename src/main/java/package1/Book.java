package package1;

public class Book {
    private int id;
    private String name;
    private int edition;
    private int price;

 
    public Book(int id, String name, int edition, int price) {
        this.id = id;
        this.name = name;
        this.edition = edition;
        this.price = price;
    }

   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
