class Test {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int[] arr = new int[1_00_000_000];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = (arr[i - 1] % MOD + arr[i - 2] % MOD) % MOD;
        }
        System.out.println(arr[arr.length - 1]);
    }
}
