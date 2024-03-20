package demo.view;

import demo.data.Shop;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.PatternSyntaxException;

public class MainWindow extends JFrame {
    private JTable jTable;
    private MyTableModel myTableModelMilk;
    private MyTableModel myTableModelBread;

    private   JButton  buttonAddMlk;

    private JButton buttonAddBread;

    private   JButton  showMlk;

    private JButton showBread;


////    private JButton buttonDelete;
//    private JButton buttonFilter;
//    private JButton  button_back;
//    private JButton  addBread;
//    private JButton  addMilk;

    private JDialog milkDialog;
    JTextField filterText;

    public MainWindow()
    {
        super("bread and milk");

        jTable = new JTable();

        JPanel panel = new JPanel(new BorderLayout());

        buttonAddBread = new JButton("Bread add");

        buttonAddMlk = new JButton("Milk add");

        showBread = new JButton("Bread show");

        showMlk = new JButton("Milk show");

        panel.add(buttonAddBread, BorderLayout.NORTH);

        panel.add(buttonAddMlk, BorderLayout.WEST);

        panel.add(showBread, BorderLayout.EAST);

        panel.add(showMlk, BorderLayout.SOUTH);

        this.add(panel, BorderLayout.NORTH);

        this.setSize(300, 250);

        this.setVisible(true);








//        myTableModelMilk = new MyTableModel(new Shop());
//
//        final TableRowSorter <MyTableModel> sorter = new TableRowSorter<MyTableModel>(myTableModelMilk);
//
////        TableRowSorter<MyTableModel> sorter = new TableRowSorter<>(myTableModel);
//
//        jTable.setModel(myTableModelMilk);
//
//        jTable.setRowSorter(sorter);
//
//
//        JScrollPane jScrollPane = new JScrollPane(jTable);
//
//        buttonDelete = new JButton("Delete");
//
//        buttonDelete.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                try {
//                    myTableModelMilk.delete(jTable.getSelectedRow());
//                }
//                catch (IndexOutOfBoundsException ex)
//                {
//                    JDialog jDialog = new JDialog(MainWindow.this, "Выделети персону",true);
//
//                    jDialog.setVisible(true);
//
//                }
//
//            }
//        });
//
//        JPanel panel = new JPanel(new BorderLayout());
//        JPanel panel2 = new JPanel(new BorderLayout());
//        JLabel label = new JLabel("Filter");
//
//
//
//        filterText = new JTextField();
//
//
//
////        buttonFilter = new JButton("Filter");
////        button_back = new JButton("Back");
////        addBread = new JButton("add Bread");
////        addMilk = new JButton("add Milk");
//
//
//
////        panel.add(label, BorderLayout.WEST);
////        panel.add(button_back, BorderLayout.WEST);
////        panel.add(buttonFilter, BorderLayout.EAST);
////        panel.add(filterText, BorderLayout.CENTER);
////
////        panel2.add(addBread, BorderLayout.WEST);
////        panel2.add(addMilk, BorderLayout.EAST);
////        panel2.add(buttonDelete, BorderLayout.CENTER);
//
//
//        this.add(panel, BorderLayout.NORTH);
//        this.add(panel2, BorderLayout.SOUTH);
//
//
//
//        this.setSize(300, 250);
//        this.setVisible(true);
//
//
////        this.add(jScrollPane, BorderLayout.CENTER);
//
//
//
//
//
//
//
//        this.add(jScrollPane);
//        this.pack();
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);
//
//
//        addMilk.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//                milkDialog = new JDialog();
//
//                milkDialog.add(jScrollPane, BorderLayout.CENTER);
//
//                milkDialog.add(filterText, BorderLayout.NORTH);
//
//                milkDialog.add(buttonFilter, BorderLayout.SOUTH);
//
//                milkDialog.setVisible(true);
//            }
//        });
//
//        addBread.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                myTableModelMilk.addBread();
//            }
//        });
//
//        // главный кэкран
//        // добавить -> то давить -> форма добавления
//        // работа с таблицами -> ыбираю таблицу ->  работа с ней + поиск
//
//        button_back.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                sorter.setRowFilter(null);
//            }
//        });
//
//        buttonFilter.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String text = filterText.getText();
//                if (text.isEmpty()) {
//                    sorter.setRowFilter(null);
//                } else {
//                    try {
//
//                        sorter.setRowFilter(RowFilter.regexFilter(text, 0));
//
//                    } catch (PatternSyntaxException pse) {
//                        System.err.println("");
//                    }
//
//                }
//            }
//        });
//    }
//}

//class TableRowSorterModel extends DefaultRowSorter {
//    public Comparator getComparator(int column) {
//        if (column == 1) {
//            return new Comparator() {
//                public int compare(Object o1, Object o2) {
//                    Integer int1 = Integer.parseInt((String)o1);
//                    Integer int2 = Integer.parseInt((String)o2);
//                    return int1.compareTo(int2);
//                }
//            };
//        } else {
//            return super.getComparator(column);
//        }
    }



    public void myListers()
    {
        showMlk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        showBread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

}
