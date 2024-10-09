import java.util.*;

public class WrittenMultiplication {
    public static void main(String[] args) {
    System.out.println(Arrays.toString(WrittenMultiplication.multiplyByWriting("66", "44")));
  }
  
  static int[] multiplyByWriting(String num1, String num2) {
    
    // init a result array
    int[] result = new int[num1.length() + num2.length()];
    
    System.out.println("num1.length(): "+num1.length());
    System.out.println("num2.length(): "+num2.length());
    
    for (int i = num1.length() -1; i >=0; i--) {
      System.out.println("===i-digit (first)===:");
      for (int j = num2.length() -1; j >=0; j--) {
        System.out.println("===j-digit (second)===:");
        
        // text to digit conversion
        int d1 = num1.charAt(i) - '0';
        System.out.println("d1: "+d1);
        int d2 = num2.charAt(j) - '0';
        System.out.println("d2: "+d2);
        
        // multiply the current digits
        int product = d1 * d2;
        System.out.println("product: "+product);
        
        
        // init an indexes of ones & tens (used in the result array)
        System.out.println("i: "+i);
        System.out.println("j: "+j);
        int onesIx = i + j + 1;
        System.out.println("onesIx: "+onesIx);
        int tensIx = i + j;
        System.out.println("tensIx: "+tensIx);
        
        // sum carried items (this is the -> current product in memory + 
        // + current ones digit (prev tens digit - so one item of current carry) - 
        // - so this is the new ones digit for the current iteration)
        int carry = product + result[onesIx];
        System.out.println("carry-result[onesIx]: "+result[onesIx]);
        System.out.println("carry: "+carry);
        
        // update ones & tens in the result array
        result[onesIx] = carry % 10; // getting current ones digit and set this in the result array
        System.out.println("result[onesIx]: "+result[onesIx]);
        result[tensIx] += carry / 10; // getting current tens digit, 
        // sum this with previous carried item, and carry it to the tens index in the result array, 
        // += is for carry-stack situation e.g. 44*66 -> 
        // 1-j-iteration: 4*6=24 (4 to ones, 2 to tens) 
        // 2-j-iteration: 4*6=24 (4 to ones [prev tens - 
        // - so there is 2] so += will be make 4+2=6, and carry 2 is going to hundreds, 
        // when we won't have += there will 4 [overrided 2]) 
        System.out.println("result[tensIx]: "+result[tensIx]);
        
        System.out.println("result[]: "+Arrays.toString(result));
      }
      System.out.println("\n");
    }
    return result;
  }
}