package demo.data;

import java.util.ArrayList;

public class Shop {
    public  ArrayList<Product> products = new ArrayList<>();
    public Shop()
    {
        products.add(new Milk("bread", 1,"1488"));
        products.add(new Bread("milky", 3,"228"));
        products.add(new Milk("bread", 45,"1488"));
        products.add(new Bread("milky", 56,"228"));
        products.add(new Milk("bread", 34,"1488"));
        products.add(new Bread("milky", 234,"228"));
        products.add(new Bread("milky", 223,"228"));
        products.add(new Bread("milky", 123,"228"));
    }




    public int getCount() {
        return products.size();
    }

    public Product getProduct(int index) {
        Product product = products.get(index);
        return product;
    }

    public Product remove(int index)
    {
        return products.remove(index);
    }


    public void add(Product product)
    {
        this.products.add(product);
    }
}
