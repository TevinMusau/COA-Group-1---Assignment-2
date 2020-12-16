package assignment2b;

import java.text.DecimalFormat;

public class Assignment2b 
{
    //This is assignment 2 part B
    public static void main(String[] args) 
    {
        double min = 0.0;           //determines the range for
        double max = 1000.0;        //generating the random numbers
        
        int t = 0;                  //counter for the random numbers
        int m = 1;                  //counter for the numbering (S/No)
                
        //For the table format
        System.out.print("S/No. \t");               
        System.out.print("Decimal Number \t");
        System.out.print("Binary number \t \t");
        System.out.print("Remark \n");
        
        do                      //for listing the numbering (1-30), listing random numbers and the array of the calculated binary digits
        {
            int position = 0;       //determines array index for the binary array
            int posi = 0;           //determines array index for the whole ninary number
            int binary [] = new int [10];       //array to store integer binary equivalent
            int whole [] = new int [6];         //array to store fraction part binary equivalent
            
            System.out.print(m);
            m++;                            //increments the numbering (1-30)
            
            System.out.print("\t");
            
            double random = min + Math.random() * (max - min);          //generates random number within the range (max-min)
            DecimalFormat numberFormat = new DecimalFormat("#.000");    //restricts the number of decimal places for the random number to 3
            System.out.print(numberFormat.format(random)+ "\t");        //prints the random number

            int intPart = (int) random;                                 //TypeCast the integer part to a number, for easy working
            String Decimal = numberFormat.format(random - intPart);     //Separates integer part from the fraction part
//            System.out.print("Integer Part: " + intPart);
//            System.out.print("Decimal Part: " + Decimal);         
            
            System.out.print("\t");
            t++;                                                        
            
            do                                                          //converts integer part to binary
            {
                if(intPart %2 == 0)                                     //divisible by 2?
                {
                    intPart = intPart/2;                             
                    binary[position] = 0;                               
                }
                else
                {
                    intPart = intPart/2;
                    binary[position] = 1;
                }
                position++;                                             //increments the array index
            }while(intPart > 0);                                        //process continues until integer is <= 0
            
            double i = Double.parseDouble(Decimal);                     //TypeCasts Decimal part of number from String to double
            //System.out.println(i);
            int count = 0;                                              //counter for the number of iterations for a recurring number (max of 5 decimal places)
            
            do
            {
                if(i > 0.999)                                             //number is 1.smth?
                {
                    i = (Double.parseDouble(numberFormat.format( i - (int) i)) * 2);        //takes only the fraction part of the number and multiplies by 2
                    //System.out.println(i);
                    whole[posi] = (int) i;                                                  //stores the 1(one) in an array
                    posi++;                                                                 //increments array index 
                    count++;                                                                //increments the counter for the ,ax decimal places
                }
                else if (i<=0.999)
                {
                    i = i * 2;                                                                //multiplies fraction by 2
                    //System.out.println(i);
                    whole[posi] = (int) i;                                                  //stores the 0(zero) in an array
                    posi++;
                    count++;
                }
            }while(count < 6);                                                              //process continues until a max of 5 decimal places
            
            
            for (int y = binary.length - 1; y >= 0; y--)                                    //prints decimal intger's binary array backwards
            {
                System.out.print(binary[y]);
            }
            System.out.print(".");
            for (int x = 0; x <whole.length - 1 ; x++)                                      //prints the decimal fraction's binary equivalent array backwards
            {
                System.out.print(whole[x]);
            }
            System.out.print("\t \t");
            
            //System.out.print(count);
                if(count >= 5)                                                              //if count >= 5, it means the array for the fraction part is full, thus the remarks apply
                {
                    System.out.print("Approximate");
                }
                else
                {
                    System.out.print("Exact");
                }

            System.out.print("\n");
            
            System.out.print("\n");
        }while(t<30);                                                                      //process continues until 30 random numbers are generated
    }
}