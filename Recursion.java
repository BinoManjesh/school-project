class Recursion {
    
    static double factorial(int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            return n * factorial(n - 1);
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    static double factorialI(int n) {
        double prod = 1;
        int  i = n;
        while (i > 0) {
            prod *= i--;
        }
        return prod;
    }
    
    static void timeDiff() {
        long startTime = System.nanoTime();
        for (int i = 0; i < 150; i++) {
            factorial(i);
        }
        float elapsedTime1 = (System.nanoTime() - startTime) * 1e-9f;
        
        startTime = System.nanoTime();
        for (int i = 0; i < 150; i++) {
            factorialI(i);
        }
        float elapsedTime2 = (System.nanoTime() - startTime) * 1e-9f;
        
        System.out.println(elapsedTime1 + " " + elapsedTime2);
    }
    
    static void fps() {
        int i = 0;
        long startTime = System.nanoTime();
        while(i < 1000) {
            i++;
        }
        System.out.println(1000 / (System.nanoTime() - startTime) * 1e-9);
    }
}
