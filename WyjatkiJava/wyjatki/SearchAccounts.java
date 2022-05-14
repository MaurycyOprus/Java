package wyjatki;
import java.util.ArrayList;

interface SearchAccounts
{
    Account findByNumber(int number)
    throws AccountNotFoundException;
    ArrayList<Account> findAllCustomerAccounts(Customer cust)
    throws AccountNotFoundException;
}
//interfejsy pozwalaja na tworzyc ogolny szkielet jakiejs klasy, pozwalajac dopasowac metody wedle uznania