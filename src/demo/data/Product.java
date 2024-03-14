package demo.data;

import java.util.regex.PatternSyntaxException;

public abstract class Product {
    protected String name;
    protected int count;

    public Product(String name, int count )
    {
        this.count = count;
        this.name = name;
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
            try{
                this.count = Integer.parseInt(count);
            }
            catch (NumberFormatException ex)
            {
                System.err.println("Bad regex pattern");
            }
    }

    public void setCountInt(Integer count)
    {
        this.count = count;
    }
}

