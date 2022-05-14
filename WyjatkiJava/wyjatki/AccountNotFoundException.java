package wyjatki;

public class AccountNotFoundException extends Exception
{
    static final long serialVersionUID = 1L ;
    AccountNotFoundException(){};
    AccountNotFoundException(String errorMsg)
    {
        System.out.println(errorMsg);
    }    
}
