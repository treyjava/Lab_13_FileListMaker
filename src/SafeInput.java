import java.util.Scanner;

public class SafeInput
{
    /**
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLengthString(Scanner pipe, String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print(prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;

    }


    /**
     * Prompts the user to input an integer
     * @param pipe
     * @param prompt Prompts the user to input
     * @return
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print(prompt + " : ");
            if (pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                System.out.println("\nYou said your integer is " + retVal + ".");
                done = true;

            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("\nYou must enter a valid integer, not " + trash + ".");
            }
        }while(!done);

        return retVal;
    }


    /**
     *
     * @param pipe Scanner instance to use for the console input
     * @param prompt String that tells the user what to input
     * @param low Lower bound for the range of valid numbers
     * @param high Higher bound for the range of valid numbers
     * @return Integer within the range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print(prompt + "[" + low  + "-" + high + "] : ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    System.out.println("\nYou said your integer is " + retVal + ".");
                    done = true;
                }
                else
                {
                    System.out.println("You said your integer is " + retVal + " but that is not in the correct range. ");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer, not " + trash);
            }
        }while(!done);

        return retVal;
    }


    /**
     * Return a user supplied double
     *
     * @param pipe Scanner used for the console input
     * @param prompt String that asks the user to input an integer
     * @return An arbitrary double within the range
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print(prompt + " : ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                System.out.println("\nYou said your double is " + retVal + ".");
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double not " + trash);
            }
        }while(!done);

        return retVal;
    }


    /**
     * Returns a user's supplied double within the range
     *
     * @param pipe
     * @param prompt String that asks the user to enter a double
     * @param low The lower bound for the range of valid integers
     * @param high The higher bound for the range of valid integers
     * @return An arbitrary double within the range
     */
    public static double getRangeDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print(prompt + "[" + low + "-" + high + "] : " );
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                if(retVal >= low && retVal <= high)
                {
                    System.out.println("\nYou said your double is " + retVal + ".");
                    done = true;
                }
                else
                {
                    System.out.println("You said your double is " + retVal + ", but that is not within the correct range");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid integer, not " + trash + ".");
            }
        }while(!done);

        return retVal;
    }


    /**
     * Takes Y or N and returns true or false
     *
     * @param pipe Scanner for console input
     * @param prompt String indicating what to input
     * @return Boolean true of false based on Y or N
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = false;
        boolean done = false;
        String inputYN = "";
        String trash = "";

        do
        {
            System.out.print(prompt + " [Y/N]: ");
            inputYN = pipe.nextLine();
            if(inputYN.equalsIgnoreCase("Y"))
            {
                retVal = true;
                done = true;
            }
            else if(inputYN.equalsIgnoreCase("N"))
            {
                done = true;
                retVal = false;
            }
            else
            {
                System.out.println("You must enter Y or N. ");
                done = false;
            }
        }while(!done);

        return retVal;
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retVal = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            retVal = pipe.nextLine();
            if(retVal.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("\n" + retVal + " must match the pattern " + regEx);
            }
        }while (!done);

        return retVal;
    }
    public static void prettyHeader(String msg) {
        int starCount = 60;

        for (int c = 0; c < starCount; c++)
        {
            System.out.print("*");
        }
        System.out.println();
        int starsLeft = (60 - msg.length()) / 2;
        int spaces = starsLeft - 3;
        System.out.print("***");

        for (int c = 0; c < spaces; c++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        if (msg.length() % 2 == 0 )    // test to see if it is even so if this is true then it's even
        {
            for (int c = 0; c < spaces; c++)
            {
                System.out.print(" ");
            }
        }
        else
        {
            for (int c = 0; c <= spaces; c++)
            {
                System.out.print(" ");
            }
        }

        System.out.println("***");

        for (int c = 0; c < starCount; c++)
        {
            System.out.print("*");
        }
        System.out.println();
    }
}