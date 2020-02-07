import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class FractionCalculator {

    public static void main(String [] args){

        System.out.println("This program is a fraction calculator.");

        System.out.println("It will add, subtract, multiply, and divide fractions until you type Q to quit.");

        System.out.println("Please enter your fractions in the form a/b, where a and b are integers.");

        FractionCalculator c = new FractionCalculator();

        while (true){

            System.out.println("--------------------------------------------------------------------");

            Scanner in = new Scanner(System.in);

            String op = c.getOperation(in);

            if (op.equalsIgnoreCase("Q")) {

                break;

            } else {

                Fraction f1 = c.getFraction(in);

                Fraction f2 = c.getFraction(in);

                if (op.equals("+")){

                    Fraction f3 = f1.add(f2);

                    System.out.println(f3);

                } else if (op.equals("-")) {

                    Fraction f3 = f1.subtract(f2);

                    System.out.println(f3);

                } else if (op.equals("*")) {

                    Fraction f3 = f1.multiply(f2);

                    System.out.println(f3);

                } else if (op.equals("/")) {

                    Fraction f3 = f1.divide(f2);

                    System.out.println(f3);

                } else {

                    if (f1.equals(f2) == true) {

                        System.out.println(f1 + " = " + f2 + " is true");

                    } else {

                        System.out.println(f1 + " = " + f2 + " is false");

                    }
                }
            }
        }
    }

    public String getOperation (Scanner input){

        String operation = "";

        boolean invalidOperator = true;

        while (invalidOperator) {

            System.out.print("\n\nPlease enter an operation (+, -, /, *, = or Q to quit): ");

            operation = input.nextLine();

            if (operation.equals("+") || operation.equals("-") ||
            operation.equals("*") || operation.equals("/") ||
            operation.equals("=") || operation.equalsIgnoreCase("Q")){

                invalidOperator = false;

            }

        }
        return operation;

    } //done

    public boolean validFraction (String fraction) {

        if (fraction.contains("/")) {

            String [] terms = fraction.split("/");

            if ((isNumber(terms[0]) == true) && isNumber(terms[1]) == true){

                int numerator = Integer.parseInt(terms[0]);

                int denominator = Integer.parseInt(terms[1]);

                if (denominator > 0) {

                    return true;

                }
            }
        }

        return false;

    }

    public boolean isNumber(String term) {

        String n = "";

        if (term.contains("-")) {

            String [] nTerm = term.split("-");

            n = nTerm[1];

        } else {

            n = term;

        }

        int amountOfNumbers = 0;

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < n.length(); j++) {

                if (n.contains(String.valueOf(i))) {

                    amountOfNumbers++;

                }

            }

        }

        if (amountOfNumbers == n.length()) {

            return true;

        }

        return false;

    }

    public Fraction getFraction(Scanner input) {

        String strFraction = "";

        Fraction f = new Fraction();

        boolean invalidFraction = true;

        System.out.print("\n\nPlease enter a fraction (a/b) or integer (a): ");

        while (invalidFraction == true) {

            strFraction = input.nextLine();

            if (validFraction(strFraction) == true) {

                String [] fractionTerms = strFraction.split("/");

                int numerator = Integer.parseInt(fractionTerms[0]);

                int denominator;

                if (fractionTerms[1] != null) {

                    denominator = Integer.parseInt(fractionTerms[1]);

                    if (denominator != 0) {

                        Fraction nF = new Fraction (numerator, denominator);

                        f = nF;

                        invalidFraction = false;

                    } else {

                        Fraction mF = new Fraction (numerator);

                        f = mF;

                        invalidFraction = false;

                    }

                } else {

                    Fraction mF = new Fraction (numerator);

                    f = mF;

                    invalidFraction = false;

                }

            } else {

                System.out.print("\n\nInvalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");

            }
        }

        return f;
    }
}


