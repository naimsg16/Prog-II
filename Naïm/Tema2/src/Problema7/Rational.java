package Problema7;

public class Rational {

    private int num;
    private int den;

    public Rational(int numerator, int denominator){
        this.num = numerator;
        this.den = denominator;
    }

    //-------------------------------------------------------------------

    //Instance methods

    public void add(Rational rational){
        int lcm = lcm(this.den,rational.den);
        int num1 = lcm * this.num / this.den;
        int num2 = lcm * rational.num / rational.den;
        this.num = num1 + num2;
        this.den = lcm;
        simplify(this);
    }
    public void substract( Rational rational){
        Rational negativeRational = new Rational(-rational.num,rational.den);
        this.add(negativeRational);
    }

    public void multiply(Rational rational){
        this.num *= rational.num;
        this.den *= rational.den;
        simplify(this);
    }

    public void divide(Rational rational){
        this.num *= rational.den;
        this.den *= rational.num;
        simplify(this);
    }

    //---------------------------------------------------------------
    //STATIC METHODS
    public static Rational add(Rational r1, Rational r2){
        int lcm = lcm(r1.den,r2.den);
        int num1 = lcm * r1.num / r1.den;
        int num2 = lcm * r2.num / r2.den;

        Rational result = new Rational(num1 + num2,lcm);
        simplify(result);
        return result;
    }
    public static Rational substract(Rational r1, Rational r2){
        Rational negativeR2 = new Rational(-r2.num,r2.den);
        return Rational.add(r1,negativeR2);
    }
    public static Rational multiply(Rational r1, Rational r2){
        int resNum = r1.num * r2.num;
        int resDen = r1.den * r2.den;
        Rational result = new Rational(resNum,resDen);
        simplify(result);
        return result;
    }
    public static Rational divide(Rational r1, Rational r2){
        int resNum = r1.num * r2.den;
        int resDen = r1.den * r2.num;
        Rational result = new Rational(resNum,resDen);
        simplify(result);
        return result;
    }

    //--------------------------------------------------

    private static void simplify (Rational r){
        int gcd = gcd(Math.abs(r.num),Math.abs(r.den));
        r.num /= gcd;
        r.den /= gcd;
        moveSign(r);
    }

    private static int lcm(int num, int den){
        int lcd = Math.max(num,den);
        while(lcd % num != 0 || lcd % den != 0){
            lcd += 1;
        }
        return lcd;
    }
    private static int gcd(int num, int den){
        if (num == 0 ){
            return den;
        }
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
