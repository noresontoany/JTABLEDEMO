package demo.data;

public class Bread extends Product {
    protected String flour_type;
    public Bread()
    {
        super("", 0);

    }

    public Bread(String name, int count, String subject)
    {
        super(name, count);
        this.flour_type = subject;
    }

    public java.lang.String getFlour() {
        return flour_type;
    }

    public void setFlour(java.lang.String subject) {
        this.flour_type = subject;
    }




}
