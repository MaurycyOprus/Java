package wyjatki;

public class AccountLoginFailedException extends Exception
{
    static final long serialVersionUID = 1L;
    private int password;
    private String login;
    private Customer owner;
    AccountLoginFailedException(){}
    AccountLoginFailedException(String errorMsg, String s, int passwd)
    {
        super(errorMsg);
        login = s;
        password = passwd;
        System.out.println(errorMsg);
        System.out.println("Login: "+ login + "\nPassword: " + password);
    }
    //metody
    int getPassword()
    {
        return password;
    }
    String getLogin()
    {
        return login;
    }
    Customer getOwner()
    {
        return owner;
    }
}
