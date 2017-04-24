package bardzimashvili.db;

import java.sql.*;

public class Conn
{
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    /**
     * Connect to DB
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void Conn() throws ClassNotFoundException, SQLException
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
        conn = DriverManager.getConnection("jdbc:sqlite:./resources/TEST1.s3db");

        //System.out.println("База Подключена!");
    }

    /**
     * Create table
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'users' " +
                            "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'phone' INT);");
        statmt.execute("CREATE TABLE if not exists 'app' " +
                            "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'market' text);");
        statmt.execute("CREATE TABLE if not exists 'market' " +
                            "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'category' text);");
        statmt.execute("CREATE TABLE if not exists 'category' " +
                            "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text);");
        statmt.execute("CREATE TABLE if not exists 'subcategory' " +
                            "('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text);");

        //System.out.println("Таблица создана или уже существует.");
    }

    /**
     * Writing data to a table
     * @throws SQLException
     */
    public static void WriteDB() throws SQLException
    {
        /*statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Petya', 125453); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Vasya', 321789); ");
        statmt.execute("INSERT INTO 'users' ('name', 'phone') VALUES ('Masha', 456123); ");*/

        statmt.execute("INSERT INTO 'app' ('name', 'market') VALUES ('Crash Arena', 'Google Play'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market') VALUES ('Fly Catbug Fly!', 'Google Play'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market') VALUES ('Sumotori Dreams', 'Google Play'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market') VALUES ('Facets', 'Google Play'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market') VALUES ('NBA 2K14', 'Google Play'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market') VALUES ('Polar Bowler', 'Google Play'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market') VALUES ('Domo - Icon Pack', 'Google Play'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market') VALUES ('Fix My Car: Custom Mods', 'Google Play'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market') VALUES ('IMPOSSIBLE ROAD', 'Google Play'); ");
        statmt.execute("INSERT INTO 'app' ('name', 'market') VALUES ('Goat Rampage', 'Google Play'); ");

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

        /*statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Big Business'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Small Business'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Puzzle Games'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Race'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Education'); ");
        statmt.execute("INSERT INTO 'subcategory' ('name') VALUES ('Engineering'); ");*/


        System.out.println("Таблица заполнена");
    }

    // -------- Вывод таблицы--------
    public static void ReadDB() throws ClassNotFoundException, SQLException
    {
        resSet = statmt.executeQuery("SELECT * FROM users");

        while (resSet.next())
        {
            int id = resSet.getInt("id");
            String name = resSet.getString("name");
            String phone = resSet.getString("phone");
            System.out.println("ID = " + id);
            System.out.println("name = " + name);
            System.out.println("phone = " + phone);
            System.out.println();
        }

        System.out.println("Таблица выведена");
    }

    // -------- Вывод таблицы--------
    public ResultSet ReadTable(String table) throws Exception
    {
        resSet = statmt.executeQuery("SELECT * FROM " + table);

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
     * Close connect
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        //statmt.close();
        resSet.close();

        //System.out.println("Соединения закрыты");
    }
}
