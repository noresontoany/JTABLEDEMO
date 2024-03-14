package demo.view;

import demo.data.Shop;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;
import java.util.regex.PatternSyntaxException;

import static java.sql.Types.NULL;

public class MainWindow extends JFrame {
    private JTable jTable;
    private MyTableModel myTableModel;
    private JButton buttonDelete;
    private JButton button;
    private JButton  button_back;

    private JButton  addBread;

    private JButton  addMilk;

    public MainWindow()
    {
        super("bread and milk");
        jTable = new JTable();

        myTableModel = new MyTableModel(new Shop());

        final TableRowSorter <MyTableModel> sorter = new TableRowSorter<MyTableModel>(myTableModel);

//        TableRowSorter<MyTableModel> sorter = new TableRowSorter<>(myTableModel);
        
        jTable.setModel(myTableModel);

        jTable.setRowSorter(sorter);


        JScrollPane jScrollPane = new JScrollPane(jTable);

        buttonDelete = new JButton("Delete");

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    myTableModel.delete(jTable.getSelectedRow());
                }
                catch (IndexOutOfBoundsException ex)
                {
                    JDialog jDialog = new JDialog(MainWindow.this, "Выделети персону",true);

                    jDialog.setVisible(true);

                }

            }
        });

        JPanel panel = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Filter");



        final JTextField filterText = new JTextField();



        button = new JButton("Filter");
        button_back = new JButton("Back");
        addBread = new JButton("add Bread");
        addMilk = new JButton("add Milk");



        panel.add(label, BorderLayout.WEST);
        panel.add(button_back, BorderLayout.WEST);
        panel.add(button, BorderLayout.EAST);
        panel.add(filterText, BorderLayout.CENTER);

        panel2.add(addBread, BorderLayout.WEST);
        panel2.add(addMilk, BorderLayout.EAST);
        panel2.add(buttonDelete, BorderLayout.CENTER);


        this.add(panel, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.SOUTH);



        this.setSize(300, 250);
        this.setVisible(true);


        this.add(jScrollPane, BorderLayout.CENTER);







        this.add(jScrollPane);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


        addMilk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myTableModel.addMIlk();
            }
        });

        addBread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myTableModel.addBread();
            }
        });




        button_back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sorter.setRowFilter(null);
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text = filterText.getText();
                if (text.isEmpty()) {
                    sorter.setRowFilter(null);
                } else {
                    try {

                        sorter.setRowFilter(RowFilter.regexFilter(text, 0));

                    } catch (PatternSyntaxException pse) {
                        System.err.println("Bad regex pattern");
                    }

                }
            }
        });
    }
}

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
//    }
//}
