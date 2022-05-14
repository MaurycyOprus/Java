package wyjatki;

public class Account 
{
    private int accountNumber;
    private Customer owner;
    private double balance;
    private int password;
    private String login;
    public Account(){}
    public Account(int n, Customer c, double p, String l, int pass)
    {
        accountNumber = n;
        owner = c;
        balance = p;
        login = l;
        password = pass;
    }
    public Customer getCustomer() 
    {
        return owner;
    }
    public int getNumber() 
    {
        return accountNumber;
    }
    public String getLogin() 
    {
        return login;
    }
    public int getPassword() 
    {
        return password;
    }
    public double getBalance() 
    {
        return balance;
    }
    public double withdraw(double amount) 
    {
        if(balance - amount >= 0)
        {
            balance = balance - amount;
        }
        else
        {
            System.out.println("Za malo srodkow na koncie.");
        }
        return balance;
    }
    public double transferMoneyToAccount(double amount)
    {
        balance = balance + amount;
        return balance;
    }
}