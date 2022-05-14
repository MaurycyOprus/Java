package wyjatki;

public class CustomerNotFoundException  extends Exception
{
    static final long serialVersionUID = 1L ;
    CustomerNotFoundException(){}
    CustomerNotFoundException(String errorMsg)
    {
        System.out.println(errorMsg);
    }
}
