public class ConstantUserOptions implements UserOptions
{
    private String username = "coleman";
    private String editor = "nano";

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
