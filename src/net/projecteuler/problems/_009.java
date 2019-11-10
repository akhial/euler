package net.projecteuler.problems;

public class _009 {

    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;
        boolean found = false;

        for(int i = 0; i < 998; i++) {
            for(int j = 0; j < 998; j++) {
                for(int k = 0; k < 998; k++) {
                    if(i + j + k == 1000 && (k*k + j*j == i*i)) {
                        c = i;
                        b = j;
                        a = k;
                        found = true;
                    }
                    if(found) break;
                }
                if(found) break;
            }
            if(found) break;
        }
        System.out.println(a*b*c);
    }
}
