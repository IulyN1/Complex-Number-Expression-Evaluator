package domain;

// ComplexNumber class that defines a complex number
public class ComplexNumber {
    private float re;
    private float im;

    // Constructor for the ComplexNUmber class
    // re - float
    // im - float
    public ComplexNumber(float re,float im){
        this.re = re;
        this.im = im;
    }

    // Getter method for re attribute
    // returns - float
    public float getRe() {
        return re;
    }

    // Getter method for im attribute
    // returns - float
    public float getIm() {
        return im;
    }

    // Method that adds a complex number
    // nr - ComplexNumber
    public void add(ComplexNumber nr){
        this.re += nr.re;
        this.im += nr.im;
    }

    // Method that subtracts a complex number
    // nr - ComplexNumber
    public void subtract(ComplexNumber nr){
        this.re -= nr.re;
        this.im -= nr.im;
    }

    // Method that multiplies a complex number
    // nr - ComplexNumber
    public void multiply(ComplexNumber nr){
        float aux = this.re;
        this.re = aux * nr.re - this.im * nr.im;
        this.im = aux * nr.im + this.im * nr.re;
    }

    // Method that divides a complex number
    // nr - ComplexNumber
    public void divide(ComplexNumber nr){
        float aux = this.re;
        this.re = (aux * nr.re + this.im * nr.im)/(nr.re * nr.re + nr.im * nr.im);
        this.im = (this.im * nr.re - aux * nr.im)/(nr.re * nr.re + nr.im * nr.im);
    }

    // Overridden method toString() to change how the result is shown
    @Override
    public String toString() {
        if(im>=0)
            if(im==1)
                return re + "+i";
            else
                return re + "+" + im + "i";
        else
            return re + "" + im +"i";
    }
}
