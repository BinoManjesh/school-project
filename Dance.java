class Dance {
    
    private static final StringBuffer[] frames = new StringBuffer[] {
        new StringBuffer(
        "0011100\n" +
        "0011100\n" +
        "0001001\n" +
        "1111111\n" +
        "1001000\n" +
        "0001001\n" +
        "1111111\n" +
        "1000000\n"),
        
        new StringBuffer(
        "0011100\n" +
        "0011100\n" +
        "1001000\n" +
        "1111111\n" +
        "0001001\n" +
        "1001000\n" +
        "1111111\n" +
        "0000001\n")
    };
    
    private static void init() {
        for (StringBuffer frame : frames) {
            for (int i = 0; i < frame.length(); ++i) {
                char c = frame.charAt(i);
                switch (c) {
                    case '1': c = '\u2588'; break;
                    case '0': c = '\u2591'; break;
                }
                frame.setCharAt(i, c);
            }
        }
    }
    
    public static void main(String[] args) {
        init();
        while (true) {
            for (StringBuffer frame : frames) {
                System.out.print('\u000C');
                System.out.print(frame);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    
                }
            }
        }
    }
}
