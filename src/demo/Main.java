package demo;

import demo.data.DbFunctions;
import demo.view.MainWindow;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

//
//        DbFunctions db = new DbFunctions();
//        java.sql.Connection con  = db.connetinon_to_db("postgres", "123");
////        //db.createTable(con , "products" );
////        db.createTable(con , "milk", "prod_type");
////        db.createTable(con , "bread", "flour_type");
////        db.insertIntoTable(con, "milk", "tryrty", 456, "ahahah","prod_type" );
////        db.insertIntoTable(con, "bread", "234y", 999, "123123","flour_type" );
////        ///db.readData(con, "ahah9");
////       // db.searchByName(con, "ahah9",3);
//            db.deleteRow(con , "products", 9);
//            db.updateRow(con, "products", "Name", 5, "ahahahha");
////
////
//        db.readData(con , "milk", "prod_type");
        new MainWindow();

//        Map<Integer, Person> states = new HashMap<Integer, Person>();
//        states.put(1 + 100, new Student("bread", "1488"));
//        states.put(2 + 100, new Teacher("milky", "228"));
//        int size = states.size();
//        Teacher t = new Teacher("asd", "23asd");
//
//        System.out.println(t.getFio());


    }
}