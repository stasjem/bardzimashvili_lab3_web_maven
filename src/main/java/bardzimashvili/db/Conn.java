package bardzimashvili.db;

import java.sql.*;

public class Conn
{
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    /**
     * Connect to DB
     * The existence of the file is checked, then the connection to the database
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        try
        {
            new DirAndFiles();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        conn = DriverManager.getConnection("jdbc:sqlite:TEST1.s3db");

        //System.out.println("База Подключена!");
    }

    /**
     * Create table
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void createDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' " +
                           "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");
        statmt.execute("CREATE TABLE if not exists 'app' " +
                           "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'market' text, 'descriptions' text, 'size' text, 'category' text);");
        statmt.execute("CREATE TABLE if not exists 'market' " +
                           "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'category' text);");
        statmt.execute("CREATE TABLE if not exists 'category' " +
                           "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text);");
        statmt.execute("CREATE TABLE if not exists 'subcategory' " +
                           "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text);");

        statmt.execute("CREATE TABLE if not exists 'test' " +
                           "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text);");

        //System.out.println("Таблица создана или уже существует.");
    }

    /**
     * Writing data to a table
     *
     * @throws SQLException
     */
    public void writeDB() throws SQLException
    {
        /*statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");*/

        statmt.execute("INSERT INTO 'app' ('name', 'market', 'descriptions', 'size', 'category') VALUES ('Crash Arena', 'Google Play', 'descriptions', 'size', 'category'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market', 'descriptions', 'size', 'category') VALUES ('Fly Catbug Fly!', 'Google Play', 'descriptions', 'size', 'category'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market', 'descriptions', 'size', 'category') VALUES ('Sumotori Dreams', 'Google Play', 'descriptions', 'size', 'category'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market', 'descriptions', 'size', 'category') VALUES ('Facets', 'Google Play', 'descriptions', 'size', 'category'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market', 'descriptions', 'size', 'category') VALUES ('NBA 2K14', 'Google Play', 'descriptions', 'size', 'category'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market', 'descriptions', 'size', 'category') VALUES ('Polar Bowler', 'Google Play', 'descriptions', 'size', 'category'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market', 'descriptions', 'size', 'category') VALUES ('Domo - Icon Pack', 'Google Play', 'descriptions', 'size', 'category'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market', 'descriptions', 'size', 'category') VALUES ('Fix My Car: Custom Mods', 'Google Play', 'descriptions', 'size', 'category'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market', 'descriptions', 'size', 'category') VALUES ('IMPOSSIBLE ROAD', 'Google Play', 'descriptions', 'size', 'category'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market', 'descriptions', 'size', 'category') VALUES ('Goat Rampage', 'Google Play', 'descriptions', 'size', 'category'); ");

        /*statmt.execute("INSERT INTO 'market' ('name', 'category') VALUES ('Google Play', '1'); ");
        statmt.execute("INSERT INTO 'market' ('name', 'category') VALUES ('Amazon Appstore', '1'); ");
        statmt.execute("INSERT INTO 'market' ('name', 'category') VALUES ('Aptoid', '1'); ");
        statmt.execute("INSERT INTO 'market' ('name', 'category') VALUES ('Opera Mobile Store', '1'); ");
        statmt.execute("INSERT INTO 'market' ('name', 'category') VALUES ('Яндекс.Store', '1'); ");
        statmt.execute("INSERT INTO 'market' ('name', 'category') VALUES ('Slide.ME', '1'); ");
        statmt.execute("INSERT INTO 'market' ('name', 'category') VALUES ('AppsLib', '1'); ");
        statmt.execute("INSERT INTO 'market' ('name', 'category') VALUES ('F-Droid', '1'); ");*/

        statmt.execute("INSERT INTO 'category' ('name') VALUES ('Business'); ");
        statmt.execute("INSERT INTO 'category' ('name') VALUES ('Calc'); ");
        statmt.execute("INSERT INTO 'category' ('name') VALUES ('Game'); ");
        statmt.execute("INSERT INTO 'category' ('name') VALUES ('Engineering'); ");

        /*statmt.execute("INSERT INTO 'category' ('name', 'subcategory') VALUES ('Business', '1'); ");
        statmt.execute("INSERT INTO 'category' ('name', 'subcategory') VALUES ('Calc', '1'); ");
        statmt.execute("INSERT INTO 'category' ('name', 'subcategory') VALUES ('Game', '1'); ");
        statmt.execute("INSERT INTO 'category' ('name', 'subcategory') VALUES ('Engineering', '1'); ");*/

        statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Big Business'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Small Business'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Puzzle Games'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Race'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Education'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Engineering'); ");


        //System.out.println("Таблица заполнена");
    }

    public void writeTableApp(String name, String market, String descriptions, String size, String category) throws SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("INSERT INTO 'app' ('name', 'market', 'descriptions', 'size', 'category') VALUES " +
                           "('" + name + "','" + market + "','" + descriptions + "','" + size + "','" + category + "'); ");
    }

    // -------- Вывод таблицы--------
    public void readDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");
        while (resSet.next())
        {
            int id = resSet.getInt("id");
            String name = resSet.getString("name");
            String phone = resSet.getString("phone");
            /*System.out.println("ID = " + id);
            System.out.println("name = " + name);
            System.out.println("phone = " + phone);
            System.out.println();*/
        }

        //System.out.println("Таблица выведена");
    }

    // -------- Вывод таблицы--------
    public ResultSet readTable(String table) throws Exception
    {
        statmt = conn.createStatement();
        resSet = statmt.executeQuery("SELECT * FROM " + table + "; ");

        /*while (resSet.next())
        {
            int id = resSet.getInt("id");
            String name = resSet.getString("name");
            String phone = resSet.getString("phone");
            System.out.println("ID = " + id);
            System.out.println("name = " + name);
            System.out.println("phone = " + phone);
            System.out.println();
        }*/

        //System.out.println("Таблица выведена");
        return resSet;
    }

    /**
     *
     * @param table
     * @return
     * @throws Exception
     */
    public ResultSet readTableWhere(String table, int id) throws Exception
    {
        resSet = statmt.executeQuery("SELECT * FROM " + table + " WHERE id=" + id + "; ");
        return resSet;
    }

    /**
     * Close connect
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void closeDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        //statmt.close();
        resSet.close();

        //System.out.println("Соединения закрыты");
    }
}
