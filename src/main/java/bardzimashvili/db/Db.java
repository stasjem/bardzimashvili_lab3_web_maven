package bardzimashvili.db;

import java.sql.SQLException;

public class Db {

    //public static void main(String[] args) throws ClassNotFoundException, SQLException {
    public void db() throws ClassNotFoundException, SQLException {
        Conn conn = new Conn();
        conn.conn();
        conn.createDB();
        conn.writeDB();
        conn.readDB();
        //conn.closeDB();
    }
}

