package dto;

public class BookDTO {
    private String name;
    private String id;
    private String author;
    private int quantity;

    public BookDTO(String newCategoryName) {
        this.category=newCategoryName;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "name='" + getName() + '\'' +
                ", id='" + getId() + '\'' +
                ", author='" + getAuthor() + '\'' +
                ", quantity=" + getQuantity() +
                ", category='" + getCategory() + '\'' +
                ", pages=" + getPages() +
                ", price=" + getPrice() +
                ", supplierName='" + getSupplierName() + '\'' +
                ", supplierBatch='" + getSupplierBatch() + '\'' +
                ", isbn='" + getIsbn() + '\'' +
                '}';
    }

    private String category;
    private int pages;
    private int price;
    private String supplierName;
    private String supplierBatch;
    private String isbn;

    public BookDTO() {
    }

    public BookDTO(String name, String id, String author, int quantity, String category, int pages, int price, String supplierName, String supplierBatch, String isbn) {
        this.setName(name);
        this.setId(id);
        this.setAuthor(author);
        this.setQuantity(quantity);
        this.setCategory(category);
        this.setPages(pages);
        this.setPrice(price);
        this.setSupplierName(supplierName);
        this.setSupplierBatch(supplierBatch);
        this.setIsbn(isbn);
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

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
