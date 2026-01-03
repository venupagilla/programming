class NumberofWaystoPaintN3Grid{
    public int numOfWays(int n) {
        long mod = 1_000_000_007;
        
        // Base case n=1
        long typeA = 6; // Pattern ABC
        long typeB = 6; // Pattern ABA
        
        for (int i = 2; i <= n; i++) {
            long newTypeA = (2 * typeA + 2 * typeB) % mod;
            long newTypeB = (2 * typeA + 3 * typeB) % mod;
            
            typeA = newTypeA;
            typeB = newTypeB;
        }
        
        return (int)((typeA + typeB) % mod);
    }
}
