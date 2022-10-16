public class Calculation {
    float count;
    ProductList productList;
    Calculation(int count, ProductList productList) {
        this.count = count;
        this.productList = productList;
    }
    public void counter() {
        String names = productList.getProductListNames();
        double prices = productList.getProductListPrices();

        if (names.equals("")) {
            System.out.print("Список товаров пустой, считать нечего");
        } else {
            int rouble = (int) (prices / this.count);
            String roubleText = declination(rouble);

            System.out.printf("Добавленные товары:\n%s%n", names);

            System.out.printf("Ваш счёт: %.2f %s%n", prices / this.count, roubleText);
        }
    }

    private static String declination(int rouble) {
        int preLastDigit = rouble % 100 / 10;
        if (preLastDigit == 1) {
            return "рублей";
        }

        switch (rouble % 10) {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
