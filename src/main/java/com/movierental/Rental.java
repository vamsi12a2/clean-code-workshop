package com.movierental;

public class Rental {

    private int daysRented;
    private Movie movie;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    double calculateAmount() {
        double thisAmount = 0;
        //determine amounts for each line
        switch (movie.getPriceCode()) {
            case Movie.REGULAR:
                thisAmount += 2;
                if (daysRented > 2)
                    thisAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                thisAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                thisAmount += 1.5;
                if (daysRented > 3)
                    thisAmount += (daysRented - 3) * 1.5;
                break;
        }
        return thisAmount;
    }

    int calculateFrequentRenterPoints() {
        int frequentRenterPoints = 1;
        if (isBonusApplied())
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private boolean isBonusApplied() {
        return (movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1;
    }
}