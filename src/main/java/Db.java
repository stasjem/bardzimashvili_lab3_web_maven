import java.sql.SQLException;

public class Db {

    //public static void main(String[] args) throws ClassNotFoundException, SQLException {
    public static void main1() throws ClassNotFoundException, SQLException {
        Conn conn = new Conn();
        conn.Conn();
        conn.CreateDB();
        conn.WriteDB();
        conn.ReadDB();
        conn.CloseDB();
    }
}

