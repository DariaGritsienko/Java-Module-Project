public class ProductList {
    String productListNames = "";
    double productListPrice = 0;

    public void setProductToList(Product product) {
        if (!this.productListNames.equals("")) {
            this.productListNames = this.productListNames + "\n" + product.productName;
        } else {
            this.productListNames = this.productListNames + product.productName;
        }
        this.productListPrice += product.productPrice;

        System.out.println("Товар успешно добавлен в список");
    }

    public String getProductListNames() {
        return this.productListNames;
    }

    public double getProductListPrices() {
        return this.productListPrice;
    }
}

