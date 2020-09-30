package com.altunfatih;

import java.util.Objects;

public class RationalNumber implements Comparable<RationalNumber>{
    private int numerator;
    private int denominator;

    public RationalNumber() {
        numerator = 0;
        denominator = 1;
    }

    public RationalNumber(int numerator, int denominator) {
        int gcd = findGcd(numerator, denominator);
        this.numerator = ((denominator > 0) ? 1 : -1) * (numerator / gcd);
        this.denominator = Math.abs(denominator) / gcd;
    }

    private int findGcd(int numerator, int denominator) {
        int numeratorAbsoluteValue = Math.abs(numerator);
        int denominatorAbsoluteValue = Math.abs(denominator);
        int gcd = 1;

        for (int i = 1; i <= numeratorAbsoluteValue && i <= denominatorAbsoluteValue; i++)
            if (numeratorAbsoluteValue % i == 0 && denominatorAbsoluteValue % i == 0)
                gcd = i;

        return gcd;
    }

    public RationalNumber sum(RationalNumber numberSum) {
        int newNumerator = (this.numerator * numberSum.denominator) + (this.denominator * (numberSum.numerator));
        int newDenominator = denominator * numberSum.denominator;
        RationalNumber result = new RationalNumber(newNumerator, newDenominator);
        return result;
    }

    public RationalNumber sub(RationalNumber numberSub) {
        int newNumerator = (this.numerator * numberSub.denominator) - (this.denominator * (numberSub.numerator));
        int newDenominator = denominator * numberSub.denominator;
        RationalNumber result = new RationalNumber(newNumerator, newDenominator);
        return result;
    }

    public RationalNumber multi(RationalNumber numberMulti) {
        int newNumerator = this.numerator * numberMulti.numerator;
        int newDenominator = this.denominator * numberMulti.denominator;
        RationalNumber result = new RationalNumber(newNumerator, newDenominator);
        return result;
    }

    public RationalNumber dvi(RationalNumber numberDvi) {
        int newNumerator = this.numerator * numberDvi.denominator;
        int newDenominator = this.denominator * numberDvi.numerator;
        RationalNumber result = new RationalNumber(newNumerator, newDenominator);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RationalNumber that = (RationalNumber) o;
        return numerator == that.numerator &&
                denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString() {
        if (denominator == 1)
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    @Override
    public int compareTo(RationalNumber o) {
        if (this.sub(o).numerator > 0)
            return 1;
        else if (this.sub(o).numerator < 0)
            return -1;
        else
            return 0;
    }
}
