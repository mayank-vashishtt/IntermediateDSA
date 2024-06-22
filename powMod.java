public class powMod {

        public int pow(int A, int B, int C) {
            if (B == 0) {
                return 1 % C; // Anything to the power of 0 is 1
            }
    
            long result = 1;
            long base = A % C; // Ensure base is within modulo C
    
            while (B > 0) {
                // If B is odd, multiply base with result and take modulo
                if (B % 2 == 1) {
                    result = (result * base) % C;
                }
    
                // B is even, square the base and reduce B by half
                base = (base * base) % C;
                B /= 2;
            }
    
            // Ensure result is non-negative
            result = (result + C) % C;
    
            return (int) result;
        }
    }
    
    
    

