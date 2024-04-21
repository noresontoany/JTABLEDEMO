package demo.data;

import java.sql.*;
import java.util.ArrayList;

public class DbFunctions {

    public java.sql.Connection connetinon_to_db(String user, String pass)
    {
        java.sql.Connection con = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jtable", user, pass);
            if (con !=null)
            {
                System.out.println("Connection if legit");

            }
            else
            {
                System.out.println("Conection is failed");
            }
        }
        catch (Exception e)
        {
            System.out.println("error");
        }


        return  con;
    }
    public void createTable(java.sql.Connection con, String tableName)
    {
        Statement statement;
        try
        {
            String query  = "create table " + tableName + "(Id SERIAL PRIMARY KEY, \n" +
                    "\n" +
                    "                                              name varchar, count int );";
            try {
                statement = con.createStatement();
                statement.execute(query);
            } catch (SQLException e) {
                System.out.println("error sql CREATE1");
            }

        }
        catch (Exception e) {
            System.out.println("error sql CREATE2");
        }
    }

    public void createTable(java.sql.Connection con, String tableName , String type)
    {
        Statement statement;

        try
        {
            String query = "create table " + tableName + "(Id SERIAL PRIMARY KEY, \n" +
                     "\n" +
                     "                                              "+ type + " varchar, productId INTEGER REFERENCES products (id) ON DELETE CASCADE);";


            try {
                statement = con.createStatement();
                statement.execute(query);
            } catch (SQLException e) {
                System.out.println("error sql CREATE1");
            }

        }
        catch (Exception e) {
            System.out.println("error sql CREATE2");
        }
    }

    public void insertIntoTable(java.sql.Connection con, String tableName, String name , int count, String typeValue, String type)
    {
        Statement statement;

        try
        {

            ///String query = String.format("insert into products (name, count) values('%s', %s);",  name , count);


            String query = String.format("DO $$" + "\n" +
                                                "DECLARE tableId integer;" + "\n" +
                                                 "BEGIN" + "\n" +
                                                 "INSERT INTO public.products(name, count) VALUES ('%s', %s) RETURNING id INTO tableId;" + "\n" +
                                                 "INSERT INTO public.%s("+ type + ", productId) VALUES ('%s', tableId);" + "\n" +
                                                 "COMMIT;"+ "\n" +
                                                 "END $$;", name , count , tableName,  typeValue);
            System.out.println(query);

            statement = con.createStatement();
            statement.executeQuery(query);

        }
        catch (SQLException e)
        {
//            System.out.println("insert error");
        }

    }

    public  void readData(java.sql.Connection con , String table_name, String type, ArrayList<Product> arr)
    {
        Statement statement;
        ResultSet rs;
        try
        {
            String query = String.format("select products.id , products.name , products.count, %s.%s\n" +
                    "from products, " + table_name + "\n" +
                    "where products.id = "+ table_name + ".productid", table_name, type);
            statement = con.createStatement();
            statement.executeQuery(query);
            rs  = statement.executeQuery(query);
            while (rs.next() )
            {
//                System.out.println(rs.getString("id") + " ");
//                System.out.println(rs.getString("name") + " ");
//                System.out.println(rs.getString("count") + " ");
//                System.out.println(rs.getString(type) + " ");

                if (type.equals("prod_type"))
                {
                    arr.add(new Milk(rs.getInt("id"), rs.getString("name"), rs.getInt("count"), rs.getString(type)));

                }
                else
                {
                    arr.add(new Bread(rs.getInt("id"), rs.getString("name"), rs.getInt("count"), rs.getString(type)));
                }

            }
        }
        catch (Exception ex)
        {
           // System.out.println("readData  error");
        }
    }

    public  void  searchByName(java.sql.Connection con , String table_name,int id)
    {
        Statement statement;
        ResultSet rs=null;
        //try
        //{
            String query = String.format("select * from %s where id= '%d'",table_name, id);
        try {
            statement = con.createStatement();



        rs = statement.executeQuery(query);
            while (rs.next())
            {
                System.out.println(rs.getString("id") + " ");
                System.out.println(rs.getString("name") + " ");
                System.out.println(rs.getString("count") + " ");
                System.out.println(rs.getString("prod_type") + " ");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       // }
        //catch (Exception ex)
        //{
         //   System.out.println("search error");
        //}
    }

    public void deleteRow(java.sql.Connection con, String table_name, int id)
    {
        Statement statement;
        try
        {
            String query = String.format("delete from %s where id= %s ", table_name,id);
            statement = con.createStatement();
            statement.executeQuery(query);
            statement.close();

//            System.out.println("good delete");
        }
        catch (SQLException e)
        {
//            System.out.println("delete ex");
        }
    }


    public <T> void updateRow(Connection con , String table_name, String colName, int id, T value)
    {

        Statement statement;
        String query = "";
        try
        {
           query = String.format("update %s \n" +
                    "set %s = '%s' \n" +
                    "where productid = %s", table_name, colName, value, id);
            statement = con.createStatement();
            statement.executeQuery(query);
            statement.close();

//            System.out.println("good update");
        }
        catch (SQLException e)
        {
//            System.out.println("bad update");
//            System.out.println(query);
        }
    }

    public <T> void updateRow(Connection con ,  String colName, int id, T value)
    {

        Statement statement;
        String query = "";
        try
        {
            query = String.format("update Products \n" +
                    "set %s = '%s' \n" +
                    "where id = %s",  colName, value, id);
            statement = con.createStatement();
            statement.executeQuery(query);
            statement.close();

            //System.out.println("good update");
        }
        catch (SQLException e)
        {
            //System.out.println("bad update");
            //System.out.println(query);
        }
    }




}
