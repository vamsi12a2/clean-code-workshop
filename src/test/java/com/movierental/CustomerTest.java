package com.movierental;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    @Test
    public void statementTestWithNoRental(){
        Customer customer=new Customer("Ramesh");
        System.out.println(customer.statement());
        assertEquals("Rental Record for Ramesh\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points", customer.statement());
    }
    @Test
    public void statementTestWithDifferentRentals(){
        Customer customer=new Customer("Ramesh");
        Rental rental=new Rental(new Movie("RRR", Movie.NEW_RELEASE), 1);
        Rental anotherRental=new Rental(new Movie("KGF", Movie.REGULAR), 1);
        customer.addRental(rental);
        customer.addRental(anotherRental);
        System.out.println(customer.statement());
        assertEquals("Rental Record for Ramesh\n" +
                "\tRRR\t3.0\n" +
                "\tKGF\t2.0\n" +
                "Amount owed is 5.0\n" +
                "You earned 2 frequent renter points",customer.statement());
    }
    @Test
    public void statementTestWithMultipleNumberOfDays(){
        Customer customer=new Customer("Ramesh");
        Rental rental=new Rental(new Movie("RRR", Movie.NEW_RELEASE), 2);
        customer.addRental(rental);
        System.out.println(customer.statement());
        assertEquals("Rental Record for Ramesh\n" +
                "\tRRR\t6.0\n" +
                "Amount owed is 6.0\n" +
                "You earned 2 frequent renter points", customer.statement());
    }
}