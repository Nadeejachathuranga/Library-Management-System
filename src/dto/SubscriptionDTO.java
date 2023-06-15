package dto;

public class SubscriptionDTO {
    private String name;
    private String id;
    private String price;
    private String timePeriod;
    private String description;
    private String fine;

    public SubscriptionDTO(String name, String id, String price, String timePeriod, String description, String fine) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.timePeriod = timePeriod;
        this.description = description;
        this.fine = fine;
    }

    public SubscriptionDTO() {
    }

    @Override
    public String toString() {
        return "SubscriptionDTO{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", price='" + price + '\'' +
                ", timePeriod='" + timePeriod + '\'' +
                ", description='" + description + '\'' +
                ", fine='" + fine + '\'' +
                '}';
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
