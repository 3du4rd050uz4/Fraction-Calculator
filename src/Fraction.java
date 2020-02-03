import java.util.*;

public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction (int numerator, int denominator) throws IllegalArgumentException {

        if (denominator != 0) {

            if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator < 0)) {

                numerator   *= -1;

                denominator *= -1;

            }

            this.numerator   = numerator;

            this.denominator = denominator;

        } else {

            throw new IllegalArgumentException();

        }
    }

    public Fraction (int numerator) {

        this.numerator   = numerator;

        this.denominator = 1;

    }

    public Fraction() {

        this.numerator = 0;

        this.denominator = 1;

    }

    public int getNumerator() {

        return this.numerator;

    }

    public int getDenominator() {

        return this.denominator;

    }

    public String toString() {

        return this.numerator + "/" + this.denominator;

    }

    public double toDouble() {

        return (double) this.numerator / (double) this.denominator;

    }

    public Fraction add (Fraction other) {

        int addedNumerator, addedDenominator;

        if (this.denominator == other.getDenominator()){

            addedNumerator     = this.numerator + other.getNumerator();

            addedDenominator   = this.denominator;

        } else {

            addedNumerator     = (this.numerator * other.getDenominator()) + (this.denominator + getNumerator());

            addedDenominator   = this.denominator * other.getDenominator();

        }

        Fraction addedFraction = new Fraction(addedNumerator, addedDenominator);

        return addedFraction;

    }

    public Fraction subtract (Fraction other) {

        int subtractedNumerator, subtractedDenominator;

        if (this.denominator == other.getDenominator()){

            subtractedNumerator     = this.numerator - other.getNumerator();

            subtractedDenominator   = this.denominator;

        } else {

            subtractedNumerator     = (this.numerator * other.getDenominator()) - (this.denominator + getNumerator());

            subtractedDenominator   = this.denominator * other.getDenominator();

        }

        Fraction subtractedFraction = new Fraction(subtractedNumerator, subtractedDenominator);

        return subtractedFraction;

    }

    public Fraction multiply(Fraction other) {

        int multipliedNumerator     = this.numerator * other.getNumerator();

        int multipliedDenominator   = this.denominator * other.getDenominator();

        Fraction multipliedFraction = new Fraction(multipliedNumerator, multipliedDenominator);

        return multipliedFraction;

    }

    public Fraction divide(Fraction other) throws IllegalArgumentException {

        if (other.toDouble() == 0) {

            throw new IllegalArgumentException();

        }

        Fraction invertedOther = new Fraction (other.getDenominator(), other.getNumerator());

        return this.multiply(invertedOther);

    }

    public boolean equals(Object f) {

        if (f instanceof Fraction) {

            if ((this.numerator == ((Fraction) f).getNumerator()) && (this.denominator == ((Fraction) f).getDenominator())) {

                return true;

            } else {

                return false;

            }

        }

        return false;

    }

    public static int gcd(int a, int b) {

        int r;

        while (a != 0 && b != 0) {

            r = a % b;

            a = b;

            b = r;

        }

        return a;
    }

    public void toLowestTerms(){

        int g = gcd(this.numerator, this.denominator);

        this.numerator   /= g;

        this.denominator /= g;

    }
}
