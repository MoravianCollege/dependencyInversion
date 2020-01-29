public class BigApp
{
    private UserOptions userOptions;

    public BigApp(UserOptions userOptions)
    {
        this.userOptions = userOptions;
    }

    public void bigImportantComputation()
    {
        System.out.println(userOptions.getUsername() + " prefers " + userOptions.getEditor());
    }
}
