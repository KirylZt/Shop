import java.util.ArrayList;
import java.util.Collections;

public class Shop{
    private ArrayList<Product> list = new ArrayList<>();

    public Shop() {};

    public Shop(ArrayList list) {
        this.list = list;
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public void setList(ArrayList<Product> list) {
        this.list = list;
    }

    public void AddProduct(Product p) throws IdError {
        if(list.contains(p)){
        throw new IdError(p.getId());
        }
        list.add(p);
    }

    public ArrayList<Product> getAllProducts(){
        return list;
    }

    public void removeProduct(int id){
        list.remove(new Product(id));
    }

    public void editProduct(Product p){
        int index = list.indexOf(p);
        if (index >= 0){
            list.set(index, p);
        }
    }
}
