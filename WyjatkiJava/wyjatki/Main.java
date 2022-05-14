package wyjatki;
import java.util.Scanner;
import java.util.ArrayList;

class Main
{
    public static void main(String [] args) throws CustomerNotFoundException, AccountNotFoundException, AccountLoginFailedException
    {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();
        boolean loop = true;
        String name;
        String surname;
        String pesel;
        int accountNumber;
        String login;
        int password;
        double balance;
        double amount;
        Customer user;
        Account account;
        ArrayList<Account> accounts;
        int choice, choice2;
        while(loop)
        {
            System.out.println(" 1.Login.\n 2.Add user.\n 3.Add account.\n 4.Find user by surname.\n 5.Find account by number.\n 6.Find all user's accounts.\n 7.Exit.\n");
            System.out.println("Your choice: ");
            choice = input.nextInt();
            try
            {
                switch(choice)
                {
                    case 1:
                        System.out.println("Login: ");
                        input.nextLine();
                        login = input.nextLine();
                        System.out.println("Password: ");
                        password = input.nextInt();
                        bank.login(login, password);
                        do
                        {
                            System.out.println(" 1.Transfer money into account.\n 2.Withdraw money.\n 3.Logout.\n");
                            System.out.println("Your choice: ");
                            choice2 = input.nextInt();
                            switch(choice2)
                            {
                                case 1:
                                    System.out.println("Account number: ");
                                    accountNumber = input.nextInt();
                                    account = bank.findByNumber(accountNumber);
                                    user = account.getCustomer();
                                    System.out.println("Amount: ");
                                    amount = input.nextDouble();
                                    account.transferMoneyToAccount(amount);
                                    System.out.println("Balance: "+ account.getBalance());
                                    break;
                                case 2:
                                    System.out.println("Account number: ");
                                    accountNumber = input.nextInt();
                                    account = bank.findByNumber(accountNumber);
                                    user = account.getCustomer();
                                    System.out.println("Amount: ");
                                    amount = input.nextDouble();
                                    account.withdraw(amount);
                                    System.out.println("Balance: "+ account.getBalance());
                                    break;
                                case 3:
                                    break;

                                default:
                                    System.out.println("Wrong input. Try again.");
                                    break;
                            }

                        }while(choice2 != 3);
                        break;
                    case 2:
                        System.out.println("Name: ");
                        input.nextLine();
                        name = input.nextLine();
                        System.out.println("Surname: ");
                        surname = input.nextLine();
                        System.out.println("PESEL: ");
                        pesel = input.nextLine();
                        bank.addUser(name, surname, pesel);
                        break;
                    case 3:
                        System.out.println("Name: ");
                        input.nextLine();
                        name = input.nextLine();
                        System.out.println("Surname: ");
                        surname = input.nextLine();
                        System.out.println("PESEL: ");
                        pesel = input.nextLine();
                        System.out.println("Account number: ");
                        accountNumber = input.nextInt();
                        System.out.println("Login: ");
                        input.nextLine();
                        login = input.nextLine();
                        System.out.println("Password: ");
                        password = input.nextInt();
                        balance = 0;
                        bank.addAccount(accountNumber, name, surname, pesel, balance, password, login);
                        break;
                    case 4:
                        System.out.println("Surname: ");
                        input.nextLine();
                        surname = input.nextLine();
                        user = bank.findByName(surname);
                        System.out.println("Name: " + user.getName());
                        System.out.println("Surname: " + user.getSurname());
                        System.out.println("PESEL: " + user.getPESEL());
                        break;
                    case 5:
                        System.out.println("Account number: ");
                        accountNumber = input.nextInt();
                        account = bank.findByNumber(accountNumber);
                        user = account.getCustomer();
                        System.out.println("Name: " + user.getName());
                        System.out.println("Surname: " + user.getSurname());
                        System.out.println("PESEL: " + user.getPESEL());
                        System.out.println("Balance: " + account.getBalance());
                        System.out.println("Account Number: " + account.getNumber());
                        break;
                    case 6:
                        System.out.println("Name: ");
                        input.nextLine();
                        name = input.nextLine();
                        System.out.println("Surname: ");
                        surname = input.nextLine();
                        System.out.println("PESEL: ");
                        pesel = input.nextLine();
                        user = new Customer(name, surname, pesel);
                        accounts = bank.findAllCustomerAccounts(user);
                        for(int i = 0; i < accounts.size(); i++)
                        {
                            account = accounts.get(i);
                            System.out.println("Account " + (i+1) + ".:");
                            System.out.println("Account number: " + account.getNumber());
                            System.out.println("Balance: " + account.getBalance());
                        }
                        break;
                    case 7:
                        loop = false;
                        break;
                    default:
                        System.out.println("Wrong input. Try again.");
                        break;
                }
            }
            catch(AccountLoginFailedException s){}
            catch(CustomerNotFoundException s){}
            catch(AccountNotFoundException s){}

        }
        input.close();
    }
}

