package Problema6;

public class Rational {

    private int num;
    private int den;

    public Rational(int numerator, int denominator){
        this.num = numerator;
        this.den = denominator;
    }

    public static Rational add(Rational r1, Rational r2){
        moveSign(r1);
        moveSign(r2);
        int resultNum = r1.num * r2.den + r1.den * r2.num;
        int resultDen = r1.den * r2.den;
        Rational result = new Rational(resultNum,resultDen);
        simplify(result);
        return result;
    }
//    public static Rational substract(Rational r1, Rational r2){
//
//
//
//    }
//    public static Rational multiply(Rational r1, Rational r2){
//
//
//    }
//    public static Rational divide(Rational r1, Rational r2){
//
//
//    }

    private static void simplify (Rational r){
        int gcd = gcd(r.num,r.den);
        r.num /= gcd;
        r.den /= gcd;
    }

    private static int gcd(int num, int den){
        int gcd = Math.min(num,den);
        while(num % gcd != 0 || den % gcd != 0){
            gcd -= 1;
        }
        return gcd;
    }

    public String toString (){
        if(this.den == 1){
            return String.valueOf(this.num);
        }
        return String.valueOf(this.num) + "/" + String.valueOf(this.den);
    }

    public boolean equalsRational (Rational r){
        return this.num == r.num && this.den == r.den;
    }

    private static void moveSign (Rational r){
        if(r.den < 0){
            r.den = -r.den;
            r.num = -r.num;
        }
    }

}
