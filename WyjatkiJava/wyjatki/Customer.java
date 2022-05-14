package wyjatki;

public class Customer 
{
    private String name;
    private String surname;
    private String pesel;
    
    public Customer(){}
    public Customer(String s, String a, String newPESEL){
        name = s;
        surname = a;
        pesel = newPESEL;
    }
    public String getName() 
    {
        return name;
    }
    public String getSurname() 
    {
        return surname;
    }
    public String getPESEL() 
    {
        return pesel;
    }
    @Override
    public boolean equals(Object c) //override, aby kompilator wiedział, że ta metoda przesłania inną
    {                               // jeśli żadna nie zostanie odnaleziona, kompilator zwróci błąd
        if(surname == c)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

