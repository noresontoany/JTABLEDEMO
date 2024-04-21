package demo.data;

public class Milk extends Product {
    protected String prod_type;
    public String getProd_type() {
        return prod_type;
    }

    public void setProd_type(String prod_type) {
        this.prod_type = prod_type;
    }

    public Milk()
    {
        super(0,"", 0);
    }
    public Milk(int id , String name, int count , String prod_type)
    {
        super(id , name, count);

        this.prod_type = prod_type;

    }


}
