import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUserOptions implements UserOptions
{
    String username;
    String editor;

    public FileUserOptions(String filename) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader(filename));

        // No error checking here, proof-of-concept code!
        username = in.readLine();
        editor = in.readLine();
    }

    @Override
    public String getUsername()
    {
        return username;
    }

    @Override
    public String getEditor()
    {
        return editor;
    }
}
