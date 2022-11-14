import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
    private String productName;
    private double price;
    private double count;
    private boolean bought;

    public Product(String productName, double price, double count) {
        setProductName(productName);
        setPrice(price);
        this.count = count;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName != null && !productName.isBlank() && isValidName(productName)) {
            this.productName = productName;
        } else {
            throw new IllegalArgumentException("Наименование не задано, либо не корректно. Заполните карточку товара полностью.");
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException("Цена не задана. Заполните карточку товара полностью.");
        }
    }

    public double getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count > 0) {
            this.count = count;
        } else {
            throw new IllegalArgumentException("Количество не задано. Заполните карточку товара полностью.");
        }
    }

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    private boolean isValidName(String name) {
        Pattern pattern = Pattern.compile("[а-яА-Я]");
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }

    @Override
    public String toString() {
        return productName;
    }
}
