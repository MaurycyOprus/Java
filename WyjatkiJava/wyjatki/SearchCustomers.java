package wyjatki;

interface SearchCustomers
{
    Customer findByName(String name)
    throws CustomerNotFoundException;
}