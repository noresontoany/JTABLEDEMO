package demo.view;

import demo.data.Product;
import demo.data.Milk;
import demo.data.Bread;
import demo.data.Shop;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
    public Shop data;
    public int Mycnt;
    public ArrayList<Milk> shopM = new ArrayList<>();
    public ArrayList<Bread> shopB = new ArrayList<>();

    protected  boolean P;
    public MyTableModel(Shop shop)
    {
        this.data = shop;

        for (int i =  0 ; i < data.getCount();i++ )
        {
            if (data.getProduct(i) instanceof Milk)
            {
                shopM.add((Milk)data.getProduct(i));
            }
            else
            {
                shopB.add((Bread)data.getProduct(i));
            }

        }

    }

    public void setMycnt(int cnt)
    {
        this.Mycnt = cnt;


    }


    @Override
    public int getRowCount() {


        return Mycnt;

    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {

        if (P)
            switch (column) {
                case 0:
                    return "id";
                case 1:
                    return "название";
                case 2:
                    return "кол-во";
                case 3:
                    return "тип";
            }
        else {
            switch (column){
                case 0: return "id";
                case 1:
                    return "название";
                case 2:
                    return "кол-во";
                case 3:
                    return "тип";
            }
        }

        return "";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {



        if (P) {
            switch (columnIndex) {
                case 0: return shopB.get(rowIndex).getId();

                case 1: return shopB.get(rowIndex).getName();

                case 2: return shopB.get(rowIndex).getCount();

                case 3:

                    Product p1 = shopB.get(rowIndex);

                    return ((Bread) p1).getFlour();

            }
        }
        else {
            switch (columnIndex) {

                case 0: return shopM.get(rowIndex).getId();

                case 1: return shopM.get(rowIndex).getName();

                case 2: return shopM.get(rowIndex).getCount();

                case 3:

                    Product p2 = shopM.get(rowIndex);

                    return ((Milk) p2).getProd_type();

            }
        }
                return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        if (columnIndex == 0 || columnIndex == 2)
        {
            return Integer.class;
        }
        return String.class;

    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        try {
            switch (columnIndex) {
                case 0:
                    data.getProduct(rowIndex).setName((String) aValue);

                case 1:
//                    data.getProduct(rowIndex).setCountInt((Integer) aValue);
                    data.getProduct(rowIndex).setCount((String) aValue);

                case 2: {
                    Product p = data.getProduct(rowIndex);
                    if (p instanceof Milk) {
                        ((Milk) p).setProd_type((String) aValue);
                    }

                }
                case 3: {
                    Product p = data.getProduct(rowIndex);
                    if (p instanceof Bread) {
                        ((Bread) p).setFlour((String) aValue);
                    }

                }

            }
        }
        catch (ClassCastException ex)
        {
            data.getProduct(rowIndex).setCountInt((Integer) aValue);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex)
        {
            case 0: return false;

            case 1, 2, 3: return true;
        }

        return false;
    }

    public void delete(int index)
    {
        this.data.remove(index);

        fireTableDataChanged();
    }

    public void addMIlk(String name, int cnt, String type) {
        data.add(new Milk(name, cnt, type));
        this.fireTableDataChanged();
    }

    public void addBread(String name, int cnt, String type) {
        data.add(new Bread(name, cnt, type));
        this.fireTableDataChanged();
    }



}


