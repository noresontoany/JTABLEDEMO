package demo.view;

import demo.data.Bread;
import demo.data.Milk;
import demo.data.Product;
import demo.data.Shop;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class MilkTable extends AbstractTableModel {
    public Shop data;
    protected  boolean P;
    public MilkTable(Shop shop)
    {
        this.data = shop;
    }
    @Override
    public int getRowCount() {
        return data.getCount();
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

        Product p = data.getProduct(rowIndex);

        if (P && p instanceof Bread) {
            switch (columnIndex) {
                case 0: return data.getProduct(rowIndex).getId();

                case 1: return data.getProduct(rowIndex).getName();

                case 2: return data.getProduct(rowIndex).getCount();

                case 3: return ((Bread) p).getFlour();

            }
        }
        else if(!P && p instanceof Milk)
        {
            switch (columnIndex) {

                case 0: return data.getProduct(rowIndex).getId();

                case 1: return data.getProduct(rowIndex).getName();

                case 2: return data.getProduct(rowIndex).getCount();

                case 3: return ((Milk) p).getProd_type();

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


