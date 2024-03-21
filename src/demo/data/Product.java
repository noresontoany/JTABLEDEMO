package demo.data;

public abstract class Product {
    protected String name;
    protected int count;
    protected static int id_count;
    protected int id;


    public Product(String name, int count)
    {
        this.count = count;
        this.name = name;
        this.id_count++;
        this.id = id_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(String count)
    {
            try
            {
                this.count = Integer.parseInt(count);
            }
            catch (NumberFormatException ex)
            {
                System.err.println("");
            }
    }

    public void setCountInt(Integer count)
    {
        this.count = count;
    }

    public int getId()
    {
        return id;
    }
}

