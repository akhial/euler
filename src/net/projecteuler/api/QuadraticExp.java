package net.projecteuler.api;

public class QuadraticExp {
    private final int a;
    private final int b;
    private final int c;

    public QuadraticExp(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int calculateFor(int x) {
        return a*x*x + b*x + c;
    }
}
