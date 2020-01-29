public class ParameterizedUserOptions implements UserOptions
{
    private String username;
    private String editor;

    public ParameterizedUserOptions(String username, String editor)
    {
        this.username = username;
        this.editor = editor;
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
