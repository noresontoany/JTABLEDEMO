package demo.view;

import demo.data.Bread;
import demo.data.Milk;
import demo.data.Shop;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.PatternSyntaxException;

public class MainWindow extends JFrame {
    private JTable jTable;
    private MyTableModel myTableModel;
    private JButton  buttonAddMlk;
    private JButton buttonAddBread;
    private JButton showMlk;
    private JButton showBread;
    private JButton buttonDelete;
    private JButton buttonFilter;
    private JButton button_back;
    private JDialog milkDialog;
    private JDialog breadDialog ;
    private JDialog milkDialogAdd;
    private JDialog breadDialogAdd;
    private JTextField filterText;
    private void myDispose()
    {
        try {
            this.milkDialog.dispose();
        }
        catch (NullPointerException ex)
        {
            System.out.println();
        }
        try {
            this.breadDialogAdd.dispose();
        }
        catch (NullPointerException ex)
        {
            System.out.println();
        }
        try {
            this.milkDialogAdd.dispose();
        }
        catch (NullPointerException ex)
        {
            System.out.println();
        }
        try {
            this.breadDialog.dispose();
        }
        catch (NullPointerException ex)
        {
            System.out.println();
        }
    }

    public MainWindow()
    {
        super("bread and milk");

        jTable = new JTable();


        JPanel panel = new JPanel(new GridLayout(4, 1, 30, 30));
        myTableModel = new MyTableModel(new Shop());
        buttonAddBread = new JButton("Bread add");
        buttonAddMlk = new JButton("Milk add");
        showBread = new JButton("show Bread");
        showMlk = new JButton("show Millk");








        buttonDelete = new JButton("Delete");
        buttonFilter = new JButton("Filter");
        button_back = new JButton("Back");
        filterText = new JTextField();



        panel.setBackground(Color.darkGray);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));
        panel.add(buttonAddBread);
        panel.add(buttonAddMlk);
        panel.add(showBread);
        panel.add(showMlk);



        this.add(panel, BorderLayout.CENTER);
        this.pack();
        this.setSize(300, 250);
        this.setVisible(true);





        showBread.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                myDispose();
                int cnt = 0;
                myTableModel.P = true;
                for (int i =  0 ; i < myTableModel.data.getCount();i++ )
                {
                    if (myTableModel.data.getProduct(i) instanceof Bread)
                    {
                        cnt++;
                    }

                }
                myTableModel.setMycnt(cnt);
                TableRowSorter <MyTableModel> sorter = new TableRowSorter<MyTableModel>(myTableModel);
                sorter = new TableRowSorter<>(myTableModel);
                jTable.setModel(myTableModel);
                jTable.setRowSorter(sorter);

                JScrollPane jScrollPane = new JScrollPane(jTable);

                breadDialog = new JDialog();
//                breadDialog.setModal(true);

                JPanel panel = new JPanel(new BorderLayout());
                JPanel panel2 = new JPanel();


                panel.add(button_back, BorderLayout.WEST);
                panel.add(buttonFilter, BorderLayout.EAST);
                panel.add(filterText, BorderLayout.CENTER);

                panel2.add(buttonDelete, BorderLayout.CENTER);


                breadDialog.add(panel, BorderLayout.NORTH);
                breadDialog.add(panel2, BorderLayout.SOUTH);
                breadDialog.add(jScrollPane, BorderLayout.CENTER);
                breadDialog.setLocationRelativeTo(null);
                breadDialog.pack();
                breadDialog.setVisible(true);


                buttonDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try
                        {
                            myTableModel.delete(jTable.getSelectedRow());
                        }
                        catch (IndexOutOfBoundsException ex)
                        {
                            System.err.println("");
                        }
                    }
                });

                TableRowSorter<MyTableModel> finalSorter1 = sorter;
                button_back.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        finalSorter1.setRowFilter(null);
                    }
                });

                TableRowSorter<MyTableModel> finalSorter = sorter;
                buttonFilter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String text = filterText.getText();
                        if (text.isEmpty()) {
                            finalSorter.setRowFilter(null);
                        } else {
                            try {

                                finalSorter.setRowFilter(RowFilter.regexFilter(text, 0));

                            } catch (PatternSyntaxException pse) {
                                System.err.println("");
                            }

                        }
                    }
                });



            }
        });
        showMlk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                myDispose();

                int cnt = 0;
                myTableModel.P = false;
                for (int i =  0 ; i < myTableModel.data.getCount();i++ )
                {
                    if (myTableModel.data.getProduct(i) instanceof Milk)
                    {
                        cnt++;
                    }

                }

                myTableModel.setMycnt(cnt);

                TableRowSorter <MyTableModel> sorter = new TableRowSorter<MyTableModel>(myTableModel);
                sorter = new TableRowSorter<>(myTableModel);
                jTable.setModel(myTableModel);
                jTable.setRowSorter(sorter);

                JScrollPane jScrollPane = new JScrollPane(jTable);

                milkDialog = new JDialog();
//                milkDialog.setModal(true);
                JPanel panel = new JPanel(new BorderLayout());
                JPanel panel2 = new JPanel();

                panel.add(button_back, BorderLayout.WEST);
                panel.add(buttonFilter, BorderLayout.EAST);
                panel.add(filterText, BorderLayout.CENTER);

                panel2.add(buttonDelete, BorderLayout.CENTER);




                milkDialog.add(panel, BorderLayout.NORTH);
                milkDialog.add(panel2, BorderLayout.SOUTH);
                milkDialog.add(jScrollPane, BorderLayout.CENTER);
                milkDialog.setLocationRelativeTo(null);
                milkDialog.pack();
                milkDialog.setVisible(true);

                buttonDelete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try
                        {
                            myTableModel.delete(jTable.getSelectedRow());
                        }
                        catch (IndexOutOfBoundsException ex)
                        {
                            System.err.println("");

                        }
                    }
                });

                TableRowSorter<MyTableModel> finalSorter1 = sorter;
                button_back.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            finalSorter1.setRowFilter(null);
                        }
                });

                TableRowSorter<MyTableModel> finalSorter = sorter;
                buttonFilter.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                            String text = filterText.getText();
                            if (text.isEmpty()) {
                                finalSorter.setRowFilter(null);
                            } else {
                                try {

                                    finalSorter.setRowFilter(RowFilter.regexFilter(text, 0));

                                } catch (PatternSyntaxException pse) {
                                    System.err.println("");
                                }

                            }
                        }
                });

            }
        });
        buttonAddBread.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDispose();
                breadDialogAdd = new JDialog();
//                breadDialogAdd.setModal(true);
                breadDialogAdd.setSize(250, 270);
                breadDialogAdd.setTitle("Добавление");
                breadDialogAdd.setLocationRelativeTo(null);

                JPanel grid = new JPanel();
                grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                GridLayout gridLayout = new GridLayout(5, 2, 0, 15);
                grid.setLayout(gridLayout);

                grid.add(new JLabel("Название:"));
                TextField textName = new TextField(20);
                grid.add(textName);

                grid.add(new JLabel("Кол-во:"));
                TextField textCnt = new TextField(20);
                grid.add(textCnt);

                grid.add(new JLabel("Тип муки:"));
                TextField textType = new TextField(20);
                grid.add(textType);

                JButton buttonAddDialog = new JButton("Добавить");


                grid.add(buttonAddDialog);


                buttonAddDialog.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String name = textName.getText();
                        String type = textType.getText();
                        if (name.isEmpty() || type.isEmpty())
                        {
                            textName.setBackground(new Color(213, 28, 47, 95));
                            textType.setBackground(new Color(213, 28, 47, 95));
                            return;
                        }
                        int cnt;
                        try
                        {
                            cnt = Integer.parseInt(textCnt.getText());
                            myTableModel.addBread(name, cnt, type);

                        }
                        catch (NumberFormatException ex)
                        {
                            textCnt.setBackground(new Color(213, 28, 47, 95));
                            textName.setBackground(new Color(40, 204, 40));
                            textType.setBackground(new Color(40, 204, 40));
                            return;
                        }
                        textCnt.setBackground(new Color(40, 204, 40));
                        breadDialogAdd.dispose();

                    }
                });

                breadDialogAdd.getContentPane().add(grid);
                breadDialogAdd.setVisible(true);





            }
        });
        buttonAddMlk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myDispose();

//                  dialogB = new BreadDialog(MainWindow.this, myTableModel);

                milkDialogAdd = new JDialog();
//                milkDialogAdd.setModal(true);
                milkDialogAdd.setSize(250, 270);
                milkDialogAdd.setTitle("Добавление");
                milkDialogAdd.setLocationRelativeTo(null);

                JPanel grid = new JPanel();
                grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                GridLayout gridLayout = new GridLayout(5, 2, 0, 15);
                grid.setLayout(gridLayout);

                grid.add(new JLabel("Название:"));
                TextField textName = new TextField(20);
                grid.add(textName);

                grid.add(new JLabel("Кол-во:"));
                TextField textCnt = new TextField(20);
                grid.add(textCnt);

                grid.add(new JLabel("Тип продукта:"));
                TextField textType = new TextField(20);
                grid.add(textType);

                JButton buttonAddDialog = new JButton("Добавить");
                grid.add(buttonAddDialog);


                buttonAddDialog.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {


                        String name = textName.getText();
                        String type = textType.getText();

                        if (name.isEmpty() || type.isEmpty())
                        {
                            textName.setBackground(new Color(213, 28, 47, 95));
                            textType.setBackground(new Color(213, 28, 47, 95));
                            return;
                        }
                        int cnt;
                        try
                        {
                            cnt = Integer.parseInt(textCnt.getText());
                            myTableModel.addMIlk(name, cnt, type);

                        }
                        catch (NumberFormatException ex)
                        {
                            textCnt.setBackground(new Color(213, 28, 47, 95));
                            textName.setBackground(new Color(40, 204, 40));
                            textType.setBackground(new Color(40, 204, 40));
                            return;
                        }
                        textCnt.setBackground(new Color(40, 204, 40));
                        milkDialogAdd.dispose();

                    }
                });

                milkDialogAdd.getContentPane().add(grid);
                milkDialogAdd.setVisible(true);

            }
        });



//        myTableModelMilk = new MyTableModel(new Shop());
//
//        final TableRowSorter <MyTableModel> sorter = new TableRowSorter<MyTableModel>(myTableModelMilk);
//
////      TableRowSorter<MyTableModel> sorter = new TableRowSorter<>(myTableModel);
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



//    public void myListers()
//    {
//        showMlk.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//
//        showBread.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//            }
//        });
//    }

}
