import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = getCountPeople();
        ProductList productList = getProductList();

        Calculation calculation = new Calculation(count, productList);

        calculation.counter();
    }

    public static int getCountPeople() {
        int countPerson;

        System.out.println("На скольких человек необходимо разделить счёт? Введите число:");

        while (true) {
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextInt()) {
                countPerson = scanner.nextInt();
                if (countPerson > 1) {
                    break;
                } else {
                    System.out.println("Колличество человек должно быть больше 1, попробуйте ещё раз:");
                }
            } else {
                System.out.println("Колличество человек должно быть целым числом, попробуйте ещё раз:");
            }

        }

        return countPerson;
    }

    public static ProductList getProductList() {
        Scanner scanner = new Scanner(System.in);

        ProductList productList = new ProductList();

        System.out.println("Хотите ввести товар? Да / Завершить");
        String answer = scanner.next();

        while (!answer.toLowerCase(Locale.ROOT).equals("завершить")) {
            Product product = new Product();

            setProductName(product);
            setProductPrice(product);

            productList.setProductToList(product);

            System.out.println("Хотите ввести ещё товар? Да / Завершить");
            answer = scanner.next();
        }

        return productList;
    }

    public static void setProductPrice(Product product) {
        double productPrice;

        System.out.println("Введите стоимость товара в формате: \"рубли,копейки\" [10,45]");

        while (true) {
            Scanner scanner = new Scanner(System.in);

            if (scanner.hasNextDouble()) {
                productPrice = scanner.nextDouble();
                if (productPrice > 0) {
                    break;
                } else {
                    System.out.println("Введенная стоимость товара должна быть больше 0, попробуйте еще раз:");
                }
            } else {
                System.out.println("Введенная стоимость товара НЕ в формате: \"рубли,копейки\" [10,45], попробуйте еще раз:");
            }
        }

        product.setProductPrice(productPrice);
    }

    public static void setProductName(Product product) {
        String productName;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите наименование товара");

        productName = scanner.next();
        product.setProductName(productName);
    }
}