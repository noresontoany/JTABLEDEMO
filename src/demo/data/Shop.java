package demo.data;

import java.util.ArrayList;

public class Shop {
    private  ArrayList<Product> products = new ArrayList<>();
    private DbFunctions db;
    private  java.sql.Connection con;
    public Shop()
    {
        this.db = new DbFunctions();
        this.con  = db.connetinon_to_db("postgres", "123");
        db.readData(con , "milk", "prod_type", products);
        db.readData(con , "bread", "flour_type", products);
    }




    public int getCount() {
        return products.size();
    }

    public Product getProduct(int index) {
        Product product = products.get(index);
        return product;
    }

//    public Product getProductRowCount(int indexID) {
//        Product ret = null;
//        for (int i = 0; i < products.size(); i++)
//        {
//            if (products.get(i).getRow_count() == indexID )
//            {
//                ret = products.get(i);
//                break;
//            }
//        }
//        return ret;
//    }

//    public Product remove(int index)
//    {
//        return products.remove(index);
//    }

//    public Product removeRowCount(int indexID) {
//        int ret = 0;
//        for (int i = 0; i < products.size(); i++)
//        {
//            if (products.get(i).getRow_count() == indexID )
//            {
//                ret = products.get(i).getId();
//                break;
//            }
//        }
//
//        db.deleteRow(con, "Products", ret);
//
//        return products.remove(ret);
//    }



//    public void add(Product product)
//    {
//        this.products.add(product);
//    }

    public void reload() {
        products.clear();
        Product.rows_count = 0;
        db.readData(con , "milk", "prod_type", products);
        db.readData(con , "bread", "flour_type", products);

    }
}
