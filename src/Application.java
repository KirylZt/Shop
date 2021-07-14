import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application {

    private HashMap<Integer,String> menu = new HashMap<>();
    Shop shop = new Shop();
    Scanner scanner = new Scanner(System.in);

    public Application() {
        this.menu.put(1,"Вывод всех товаров.");
        this.menu.put(10,"Сортировать по очерёдности добавления.");
        this.menu.put(11,"Сортировать по цене (Возростание).");
        this.menu.put(12,"Сортировать по цене (Убывание).");
        this.menu.put(2,"Добавить товар.");
        this.menu.put(3,"Удалить товар.");
        this.menu.put(4,"Редактировать товар.");
        this.menu.put(0,"Выход.");
    }

    public void start(){
        while (true){
            showMenu();
            System.out.println("Выберите опцию: ");
            int choice = getInt();
            if (choice == 0){
                return;
            }
            if (choice == 1){
                shopProducts();
            }
            if (choice == 2){
                shopAddProduct();
            }
            if (choice == 3){
                shopRemoveProduct();
            }
            if (choice == 4){
                shopEditProduct();
            }
            }
        }

    private void shopAddProduct(){
        System.out.println("Введите ID товара: ");
        int id = getInt();
        System.out.println("Введите наименование товара: ");
        String name = scanner.next();
        System.out.println("Введите стоимость товара: ");
        int price = getInt();
        try {
            shop.AddProduct(new Product(id, name, price));
        }catch (IdError e){
            e.getMessage();
        }
    }

    private void shopEditProduct(){
        System.out.println("Введите ID редактируемого товара: ");
        int id = getInt();
        System.out.println("Введите новое наименование товара: ");
        String name = scanner.next();
        System.out.println("Введите новую стоимость товара: ");
        int price = getInt();
        shop.editProduct(new Product(id,name,price));
    }

    private void shopRemoveProduct(){
        int delete = getInt();
        shop.removeProduct(delete);
    }

    private void shopProducts(){
        List<Product> example = shop.getList();
        System.out.println("Выберите сортировку: ");
        showSortMenu();
        switch (getInt()){
            case 1: example.sort(new ProductSortByPrice());
            break;
            case 2: example.sort(new ProductSortByPrice().reversed());
            break;
            case 0: break;
            default:
                shopProducts();
        }
        for (Product product: example){
            System.out.println(product);
        }
    }

    public int getInt(){
        if (scanner.hasNextInt()){
                return scanner.nextInt();
        }
        System.out.println("Введено не число!");
        scanner.nextLine();
        return getInt();
    }



    public void showMenu(){
        for (int i = 0; i<5; i++){
            System.out.println(i + ": " + menu.get(i));
        }
    }

    public void showSortMenu(){
        for (int i = 0; i<=2; i++){
            System.out.println(i + ": " + menu.get(10+i));
        }
    }


}
