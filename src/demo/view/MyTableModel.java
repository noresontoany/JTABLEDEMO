package demo.view;

import demo.data.Product;
import demo.data.Milk;
import demo.data.Bread;
import demo.data.Shop;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {
    public Shop data;
    public MyTableModel(Shop shop)
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

        switch (column){
            case 0: return "Название";
            case 1:
                return "кол-во";
            case 2:
                return "тип муки";
            case 3:
                return "тип молока";
        }
        return "";
    }


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex){

            case 0: return data.getProduct(rowIndex).getName();

            case 1: return data.getProduct(rowIndex).getCount();

            case 2 :
            {
                    Product p = data.getProduct(rowIndex);
                    if (p instanceof Milk)
                    {
                        return ((Milk) p).getProd_type();
                    }
                    else {
                        return "no";
                    }
            }

            case 3:
            {
                Product p = data.getProduct(rowIndex);
                if (p instanceof Bread)
                {
                    return ((Bread) p).getFlour();
                }
                else {
                    return "no";
                }
            }
        }
        return "default";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {

        if (columnIndex == 1)
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
            case 0: return true;

            case 1: return true;

            case 2: return true;

            case 3: return true;


        }

        return false;
    }

    public void delete(int index)
    {
        this.data.remove(index);

        fireTableDataChanged();
    }

    public void addMIlk() {
        data.add(new Milk());
        this.fireTableDataChanged();
    }

    public void addBread() {
        data.add(new Bread());
        this.fireTableDataChanged();
    }



}


