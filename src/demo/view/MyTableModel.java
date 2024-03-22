package demo.view;

import demo.data.Product;
import demo.data.Milk;
import demo.data.Bread;
import demo.data.Shop;

import javax.lang.model.type.NullType;
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
        showAdding();
    }
    public void showAdding()
    {
        this.shopB.clear();
        this.shopM.clear();
        for (int i =  0 ; i < data.getCount();i++ )
        {
            if (this.data.getProduct(i) instanceof Milk)
            {
                this.shopM.add((Milk)this.data.getProduct(i));
            }
            else
            {
                this.shopB.add((Bread)this.data.getProduct(i));
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
    private boolean emptyaValue(Object aValue)
    {
        String s;
        s = (String) aValue;
        if (s.equals("")) {

            return false;
        }
        return true;

    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        try {
            if(P) {
                switch (columnIndex) {
                    case 1:
                        if (emptyaValue((String) aValue)) {
                            shopB.get(rowIndex).setName((String) aValue);
                            data.getProductID(shopB.get(rowIndex).getId()).setName((String) aValue);
                            break;
                        }
                        else {
                            break;
                        }


                    case 2:
//                    data.getProduct(rowIndex).setCountInt((Integer) aValue);

                        shopB.get(rowIndex).setCount((String) aValue);
                        data.getProductID(shopB.get(rowIndex).getId()).setCount((String) aValue);
                        break;

                    case 3: {
                        if (emptyaValue((String) aValue)) {
                            shopB.get(rowIndex).setFlour((String) aValue);
                            Product p1 = data.getProductID(shopB.get(rowIndex).getId());
                            ((Bread) p1).setFlour((String) aValue);
                            break;
                        }
                        else
                        {
                            break;
                        }
                    }

                }
            }
            else
            {
                switch (columnIndex) {
                    case 1:
                        if (emptyaValue((String) aValue)) {
                            shopM.get(rowIndex).setName((String) aValue);
                            data.getProductID(shopM.get(rowIndex).getId()).setName((String) aValue);
                            break;
                        }
                        else
                        {
                            break;
                        }

                    case 2:
//                    data.getProduct(rowIndex).setCountInt((Integer) aValue);
                        shopM.get(rowIndex).setCount((String) aValue);
                        data.getProductID(shopM.get(rowIndex).getId()).setCount((String) aValue);
                        break;

                    case 3: {
                        if (emptyaValue((String) aValue)) {
                            shopM.get(rowIndex).setProd_type((String) aValue);
                            Product p1 = data.getProductID(shopM.get(rowIndex).getId());
                            ((Milk) p1).setProd_type((String) aValue);
                            break;
                        }
                        else
                        {
                            break;
                        }

                    }

                }
            }
    }

        catch (ClassCastException ex)
        {
            if (P)
            {
                shopB.get(rowIndex).setCountInt((Integer) aValue);
                data.getProductID(shopB.get(rowIndex).getId()).setCountInt((Integer) aValue);
            }
            else
            {
                shopM.get(rowIndex).setCountInt((Integer) aValue);
                data.getProductID(shopM.get(rowIndex).getId()).setCountInt((Integer) aValue);
            }
//            data.getProduct(rowIndex).setCountInt((Integer) aValue);
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch (columnIndex)
        {
            case 1, 2, 3: return true;

            case 0 : return false;
        }

        return false;
    }

    public void delete(int index)
    {

        int id;
        if (P)
        {
             id  = this.shopB.get(index).getId();
             this.shopB.remove(index);

        }
        else
        {
             id  = this.shopM.get(index).getId();
             this.shopM.remove(index);

        }
        this.Mycnt--;
        this.data.removeID(id);
        fireTableDataChanged();
    }

    public void addMIlk(String name, int cnt, String type) {

        this.Mycnt++;
        data.add(new Milk(name, cnt, type));
        showAdding();
        this.fireTableDataChanged();
    }

    public void addBread(String name, int cnt, String type) {

        this.Mycnt++;
        data.add(new Bread(name, cnt, type));
        showAdding();
        this.fireTableDataChanged();
    }



}


