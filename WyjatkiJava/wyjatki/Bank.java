package wyjatki;
import java.util.ArrayList;

public class Bank implements SearchAccounts, SearchCustomers
{
    ArrayList<Customer> customers = new ArrayList<Customer>();
    ArrayList<Account> accounts = new ArrayList<Account>();

    public void addAccount(int number, String name, String surname, String pesel, double balance, int password, String login)
    {
        Customer user = new Customer(name, surname, pesel);
        Account account = new Account(number, user, balance, login, password);
        accounts.add(account);
        System.out.println("Account successfully created. \n");
    }

    public void addUser(String name, String surname, String pesel)
    {
        Customer user = new Customer(name, surname, pesel);
        customers.add(user);
        System.out.println("User added to database. \n");
    }

    public String login(String l, int passwd)
    throws AccountLoginFailedException
    {
        for(int i = 0; i < accounts.size(); i++)
        {
            Account temp = accounts.get(i);
            String login = temp.getLogin();
            int password = temp.getPassword();
            if(login.equals(l) && password == passwd)
            {
                return "Login successful.";
            }
        } 
        throw new AccountLoginFailedException("Wrong login or password.", l, passwd);
    }
    @Override
    public Customer findByName(String name)
    throws CustomerNotFoundException
    {
        for(int i = 0; i < customers.size(); i++)
        {
            Customer temp = customers.get(i);
            String surname = temp.getSurname();
            if(surname.equals(name))
            {
                return temp;
            }
        }
        throw new CustomerNotFoundException("User not found. \n");
    }
    @Override
    public Account findByNumber(int num)
    throws AccountNotFoundException
    {
        for(int i = 0; i < accounts.size(); i++)
        {
            Account temp = accounts.get(i);
            int number = temp.getNumber();
            if(number == num)
            {
                return temp;
            }
        }
        throw new AccountNotFoundException("Account not found. \n");
    }
    @Override
    public ArrayList<Account> findAllCustomerAccounts(Customer cust)
    throws AccountNotFoundException
    {
        ArrayList<Account> OneUserAcccounts = new ArrayList<Account>();
        for(int i = 0; i < accounts.size(); i++)
        {
            Account temp = accounts.get(i);
            Customer temp2 = temp.getCustomer();
            String surname = temp2.getSurname();
            String name = temp2.getName();
            String pesel = temp2.getPESEL();
            String surname2 = cust.getSurname();
            String name2 = cust.getName();
            String pesel2 = cust.getPESEL();
            if(name.equals(name2) && surname.equals(surname2) && pesel.equals(pesel2))
            {
                OneUserAcccounts.add(temp);
            }
        }
        if (OneUserAcccounts.isEmpty())
        {
            throw new AccountNotFoundException("User not found. \n");
        }
        else
        {
            return OneUserAcccounts;
        }
    }
}