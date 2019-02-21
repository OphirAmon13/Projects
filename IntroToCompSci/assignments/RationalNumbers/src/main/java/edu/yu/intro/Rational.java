package edu.yu.intro;

public class Rational{
    private int numerator;
    private int denominator;

    public Rational(){
        this.numerator = 0;
        this.denominator = 1;
    }

    public Rational(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
        if(this.denominator == 0){
            throw new IllegalArgumentException("Denominator can not equal zero");
        }
    }

    public String printRational(){
        int n = numerator;
        int d = denominator;

        if(d < 0 && n > 0){
            n = -n;
            d = -d;
        }
        else if(n < 0 & d < 0){
            n = -n;
            d = -d;
        }
        return n + "/" + d;
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public void negate(){
        if(numerator < 0 && denominator > 0){
            numerator = -numerator;
        }

        else if(denominator < 0 && numerator > 0){
            denominator = -denominator;
        }

        else if(numerator > 0 && denominator > 0){
            numerator = -numerator;
        }

        else if(numerator < 0 && denominator < 0){
            denominator = -denominator;
        }
    }

    public void invert(){
        int holder = numerator;
        numerator = denominator;
        denominator = holder;
        if(denominator == 0){
            throw new UnsupportedOperationException("Denominator can not equal zero");
        }
    }

    public double toDouble(){
        return (double) numerator / (double) denominator;
    }

    public Rational reduce(){
        int max = Math.abs(Math.max(numerator, denominator));
        int min = Math.abs(Math.min(numerator, denominator));
        int remainder = max % min;
        int gcd = min;
        while(remainder != 0){
            gcd = min;
            remainder = max % min;
            max = min;
            min = remainder;
        }
        return new Rational((numerator / gcd), (denominator / gcd));
    }

    public Rational add(final Rational that){
        int n1 = numerator * that.getDenominator();
        int n2 = denominator * that.getNumerator();
        int d = denominator * that.getDenominator();
        Rational sum = new Rational(n1 + n2, d);
        return sum.reduce();
    }

    public static void main(String[] args){
        Rational r;

        //Test for constructor when denominator in zero
        try {
            System.out.println("Testing constructor");
            r = new Rational(3,0);
            System.out.println("if we got here something went wrong");
        }
        catch (IllegalArgumentException e){
            System.out.println("we got here so we're good");
        }

        //Test for negate
        System.out.println("Test for negate");
        r = new Rational(-5, 2);
        System.out.println(r.printRational());
        r.negate();
        System.out.println(r.printRational());
        r = new Rational(5, 2);
        System.out.println(r.printRational());
        r.negate();
        System.out.println(r.printRational());

        //Test for invert
        try{
            System.out.println("Test for good invert");
            System.out.println(r.printRational());
            r.invert();
            System.out.println(r.printRational());

            System.out.println("Testing bad invert");
            r = new Rational();
            System.out.println(r.printRational());
            r.invert();
            System.out.println("if we got here something went wrong");
        }
        catch (UnsupportedOperationException e){
            System.out.println("we got here so we're good");
        }

        //Test for toDouble
        System.out.println("Testing toDouble");
        r = new Rational(1, 2);
        System.out.println(r.printRational());
        System.out.println(r.toDouble());
        r = new Rational(2, 5);
        System.out.println(r.printRational());
        System.out.println(r.toDouble());

        //Test for reduce
        System.out.println("Testing for reduce");
        r = new Rational(4, 10);
        System.out.println(r.printRational());
        Rational r2 = r.reduce();
        System.out.println(r2.printRational());

        r = new Rational(3768, 1701);
        System.out.println(r.printRational());
        r2 = r.reduce();
        System.out.println(r2.printRational());

        //Test for add
        System.out.println("Testing for add");
        Rational r3 = new Rational(2, 5);
        Rational r4 = new Rational(4, 10);
        System.out.println(r3.add(r4).printRational());
    }
}

