package bardzimashvili.db;

import bardzimashvili.Properties;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class DirAndFiles implements Properties
{
    /**
     * Saver
     * The constructor performs the checking of the directory, file, and writes to the file
     *
     * @throws Exception
     */
    public DirAndFiles() throws Exception
    {
        createDir();
        createFile();

    }

    /**
     * dirInspection
     * check the availability of a directory
     */
    public void createDir()
    {
        File dir = new File(DIRPATH);
        if (!dir.exists())
        {
            dir.mkdirs();
        }
    }

    /**
     * fileInspection
     * Checking for a file
     * check for file
     */
    public void createFile()
    {
        File file = new File(DIRFILEPATH);
        System.out.println(!file.exists());
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
