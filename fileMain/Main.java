import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            FileUserOptions userOptions = new FileUserOptions("options.txt");

            BigApp app = new BigApp(userOptions);

            app.bigImportantComputation();
        }
        catch (IOException e)
        {
            System.out.println("Error reading options.txt");
        }

    }
}
