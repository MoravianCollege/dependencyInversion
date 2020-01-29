public class Main
{
    public static void main(String[] args)
    {
        ConstantUserOptions userOptions = new ConstantUserOptions();

        BigApp app = new BigApp(userOptions);

        app.bigImportantComputation();
    }
}
