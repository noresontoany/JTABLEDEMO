package demo.data;

public abstract class Product {
    protected String name;
    protected int count;
    protected static int rows_count;
    protected int row_count;
    protected int id;



    public Product(int id,String name, int count)
    {
        this.id  = id;
        this.count = count;
        this.name = name;
        rows_count++;
        this.row_count = rows_count;



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

    public int getRow_count()
    {
        return row_count;
    }

    public int getId()
    {

        return this.id;
    }

}

