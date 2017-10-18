package net.projecteuler.api;

public class QuadraticExp {
    private int a, b, c;

    public QuadraticExp(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int calculateFor(int x) {
        return a*x*x + b*x + c;
    }
}
