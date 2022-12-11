//Shawn Russell
//Csc-1350, Kundu

import java.util.Arrays;
import java.util.Scanner;

public class BinaryAddition
{ final int[] binaryNum, binaryNum2;
  
  public BinaryAddition(int numBits)
  { int powerOf2 = 1;
    for(int i = 0; i < numBits - 1; ++i)
    { powerOf2 *= 2; 
    }          
    int maxInt = powerOf2 - 1;
    int minInt = -powerOf2;
    System.out.print("\nEnter two intergers (>= " + minInt + " and <= " + 
                     maxInt + ") separated by a blank: ");
    Scanner scan = new Scanner(System.in);
    int inputInt = scan.nextInt();
    int inputInt2 = scan.nextInt();
    binaryNum = decimalToBinary(inputInt, numBits, minInt);
    binaryNum2 = decimalToBinary(inputInt2, numBits, minInt);
    System.out.println("binary array-form: " + Arrays.toString(binaryNum) + 
                       " of inputInt = " + inputInt);
    System.out.println("binary array-form: " + Arrays.toString(binaryNum2) + 
                       " of inputInt2 = " + inputInt2);
  }
   
  private static int[] decimalToBinary(int decNumber, int numBits, int minValue)  
  { int[] bits = new int[numBits];
    if (decNumber < 0){bits[0] = 1; decNumber = decNumber - minValue;}
    
    for(int i = numBits - 1; i > 0; --i)
    { if(decNumber < 1) 
      { break;
      } 
      bits[i] = decNumber % 2;
      decNumber /= 2;
    }
    return bits;
  }
  
  public static void main(String[] args)
  { System.out.print("Enter number of bits (>= 1 and <= 10): ");
    Scanner scan = new Scanner(System.in);
    int numBits = scan.nextInt();
    for (int i = 0; i < 5; ++i)
    { new BinaryAddition(numBits);
    }
    
  }
}
/*
Enter number of bits (>= 1 and <= 10): 6

Enter two intergers (>= -32 and <= 31) separated by a blank: 15 -20
binary array-form: [0, 0, 1, 1, 1, 1] of inputInt = 15
binary array-form: [1, 0, 1, 1, 0, 0] of inputInt2 = -20

Enter two intergers (>= -32 and <= 31) separated by a blank: 0 16
binary array-form: [0, 0, 0, 0, 0, 0] of inputInt = 0
binary array-form: [0, 1, 0, 0, 0, 0] of inputInt2 = 16

Enter two intergers (>= -32 and <= 31) separated by a blank: -32 17
binary array-form: [1, 0, 0, 0, 0, 0] of inputInt = -32
binary array-form: [0, 1, 0, 0, 0, 1] of inputInt2 = 17

Enter two intergers (>= -32 and <= 31) separated by a blank: -17 31
binary array-form: [1, 0, 1, 1, 1, 1] of inputInt = -17
binary array-form: [0, 1, 1, 1, 1, 1] of inputInt2 = 31

Enter two intergers (>= -32 and <= 31) separated by a blank: -13 -19
binary array-form: [1, 1, 0, 0, 1, 1] of inputInt = -13
binary array-form: [1, 0, 1, 1, 0, 1] of inputInt2 = -19
*/