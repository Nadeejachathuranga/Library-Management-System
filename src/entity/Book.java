package entity;

public class Book {
    private String name;
    private String id;
    private String author;
    private int quantity;
    private String category;
    private int pages;
    private int price;
    private String supplierName;
    private String supplierBatch;
    private String isbn;

    public Book(String category) {
        this.category=category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierBatch() {
        return supplierBatch;
    }

    public void setSupplierBatch(String supplierBatch) {
        this.supplierBatch = supplierBatch;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book(String name, String id, String author, int quantity, String category, int pages, int price, String supplierName, String supplierBatch, String isbn) {
        this.name = name;
        this.id = id;
        this.author = author;
        this.quantity = quantity;
        this.category = category;
        this.pages = pages;
        this.price = price;
        this.supplierName = supplierName;
        this.supplierBatch = supplierBatch;
        this.isbn = isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                ", supplierName='" + supplierName + '\'' +
                ", supplierBatch='" + supplierBatch + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
