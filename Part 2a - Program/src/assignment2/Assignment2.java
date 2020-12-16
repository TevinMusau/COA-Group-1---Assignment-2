package assignment2;

public class Assignment2
{
    //This is assignment 2 part A
    public static void main(String[] args) 
    {
        //For the table formart
        System.out.print("Decimal (base 10) \t");
        System.out.print("Binary (base 2) \t");
        System.out.println("Hexadecimal (base 16)");    
        
        int numbers = 0;        //Counter for the numbers until 256
        char hexed [] = new char [10]; //array to store generated hexadecimal values
        char hexchars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; // array of hexadecimal values
        int binary [] = new int [9]; // array to store generated binary
        
        do                      //loop to print the numbers 0 - 256
        {
            System.out.print("\t");
            System.out.print(numbers); //prints the number
            System.out.print("\t \t");
            
            int t = numbers;    // reference to the current number, for computing binary
            int d = numbers;    // reference to the current number, for computing hexadecimal
            int rem;            // calculate reminder for hexadecimal
            int position = 0;   //determines position of the array index (binary)
            int dre = 0;        //determines position of the array index (hexadecimal)
            
            //Converting to binary
            do
            {
                if (t %2 == 0)  //divisible by 2?
                {
                    t = t/2;
                    binary[position] = 0;
                }
                else
                {
                    t = t/2;
                    binary[position] = 1;
                }
                position++;   //increment array index position            
            }while(t>0);
            
            for (int y = binary.length - 1; y >= 0; y--) //prints binary array backwards
            {
                System.out.print(binary[y]);
            }
            
            System.out.print("\t \t ");
            
            //Converting to hexadecimal
            do
            {
                rem = d % 16;   //determine reminder            
                hexed[dre] = hexchars[rem];   //store the associated hexadecimal valus in an array
                d = d/16;
                dre++;          // increment array index (hexadecimal)
            }while(d>0);
            
            for (int y = hexed.length - 1; y >= 0; y--) //prints hexadecimal array backwards
            {
                System.out.print(hexed[y]);
            }
            
                System.out.print("\n");     
                
        numbers++;              // go to the next number
        }while(numbers<=256);
    }
}