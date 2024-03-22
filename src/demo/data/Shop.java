package demo.data;

import java.util.ArrayList;

public class Shop {
    private  ArrayList<Product> products = new ArrayList<>();
    public Shop()
    {
        products.add(new Milk("bread", 1,"ggg"));
        products.add(new Bread("milky", 3,"ddd"));
        products.add(new Milk("bread", 45,"sad"));
        products.add(new Bread("milky", 56,"asd"));
        products.add(new Milk("bread", 34,"asd"));
        products.add(new Bread("milky", 234,"sdf"));
        products.add(new Bread("milky", 223,"sdfsd"));
        products.add(new Bread("milky", 123,"asd"));
    }




    public int getCount() {
        return products.size();
    }

    public Product getProduct(int index) {
        Product product = products.get(index);
        return product;
    }

    public Product getProductID(int indexID) {
        Product ret = null;
        for (int i = 0; i < products.size(); i++)
        {
            if (products.get(i).getId() == indexID )
            {
                ret = products.get(i);
                break;
            }
        }
        return ret;
    }

//    public Product remove(int index)
//    {
//        return products.remove(index);
//    }

    public Product removeID(int indexID) {
        int ret = 0;
        for (int i = 0; i < products.size(); i++)
        {
            if (products.get(i).getId() == indexID )
            {
                ret = i;
                break;
            }
        }
        return products.remove(ret);
    }



    public void add(Product product)
    {
        this.products.add(product);
    }
}
