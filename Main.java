//Project_1_Jefferson_Kim
//jtk200000
import java.util.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws FileNotFoundException {
        final int ARRAY_SIZE = 10;
        File infile = null;
        Scanner scnr = new Scanner(System.in);
        String[] arrayReadIn = new String[ARRAY_SIZE];
        Creature[][] gridArray = new Creature[ARRAY_SIZE][ARRAY_SIZE];
        char inAntChar, inBeetleChar;
        int numTurns;
        
        //get input from user
        System.out.print("Input file: ");
        String fileName = scnr.next();
        infile = new File(fileName);
        Scanner iscnr = new Scanner(infile);
        //input ant char
        System.out.print("Input ant character: ");
        inAntChar = scnr.next().charAt(0);
        //input beetle char
        System.out.print("Input beetle character: ");
        inBeetleChar = scnr.next().charAt(0);
        //input number of turns
        System.out.print("Input number of turns: ");
        numTurns = scnr.nextInt();
    
        //open input file
        if (infile.canRead()) {
            for (int i = 0; i < ARRAY_SIZE; i++) {
                if(!iscnr.hasNext()) {
                    arrayReadIn[i] = "          ";
                }
                else {
                    arrayReadIn[i] = iscnr.nextLine();
                }
            }
        }
        iscnr.close();
        
        parseDatatoGrid(arrayReadIn, gridArray, ARRAY_SIZE, inBeetleChar, inAntChar);
        displayGrid(gridArray, ARRAY_SIZE);
        System.out.println(createMoveString(gridArray, 1, 1));
        //System.out.println(gridArray[1][1].move(createMoveString(gridArray, 1, 1)));
        Ant test = new Ant(inAntChar);
        //System.out.println(test.move(""))
        
    }//main end
    /*
    Method 1: parseDatatoGrid
    Will change the contents of the string array to
    the contents of the character grid.
    */
    public static void parseDatatoGrid(String[] arr, Creature[][] arr2, final int ARRAY_SIZE, char char1, char char2) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                if (arr[i].charAt(j) == 'a') {
                    Ant a = new Ant(char2);
                    arr2[i][j] = a;
                }
                else if (arr[i].charAt(j) == 'B') {
                    Beetle B = new Beetle(char1);
                    arr2[i][j] = B;
                }
            }
        }
    }//end method 1
    /*
    Method 2: displayGrid
    Will diplay contents of grid properly
    */
    public static void displayGrid(Creature[][] arr, final int ARRAY_SIZE) {
      for (int i = 0; i < ARRAY_SIZE; i++) {
            for (int j = 0; j < ARRAY_SIZE; j++) {
                if (arr[i][j] == null) {
                    System.out.print(' ');
                }
                else {
                    System.out.print(arr[i][j].getChar());
                }
            }
            System.out.println();
        }
    }//end method 2
    /*
    Method 3: createMoveString
    Will create a 4 charater string that will input into movement.
    */
    public static String createMoveString (Creature[][] arr, int pos1, int pos2) {
        String movementString = "";
        boolean creatureFound = false;
        //movement String for Beetle
        if (arr[pos1][pos2] instanceof Beetle) {
            //north
            for (int inc = 0; (pos1 - inc) >= 0 && !creatureFound; inc++) {
                if (arr[pos1 - inc][pos2] instanceof Ant) {
                    movementString = movementString.concat(Integer.toString(inc));
                    creatureFound = true;
                }
            }
            if (!creatureFound) {
                movementString = movementString.concat("0");
            }
            //east
            creatureFound = false;
            for (int inc = 0; (pos2 + inc) < 10 && !creatureFound; inc++) {
                if (arr[pos1][pos2 + inc] instanceof Ant) {
                    movementString = movementString.concat(Integer.toString(inc));
                    creatureFound = true;
                }
            }
            if (!creatureFound) {
                movementString = movementString.concat("0");
            }
            //south
            creatureFound = false;
            for (int inc = 10; (pos1 + inc) < 10 && !creatureFound; inc++) {
                if (arr[pos1 + inc][pos2] instanceof Ant) {
                    movementString = movementString.concat(Integer.toString(inc));
                    creatureFound = true;
                }
            }
            if (!creatureFound) {
                movementString = movementString.concat("0");
            }
            //west
            creatureFound = false;
            for (int inc = 0; (pos2 - inc) >= 0 && !creatureFound; inc++) {
                if (arr[pos1][pos2 - inc] instanceof Ant) {
                    movementString = movementString.concat(Integer.toString(inc));
                    creatureFound = true;
                }
            }
            if (!creatureFound) {
                movementString = movementString.concat("0");
            }
        }
        //movement string for ant
        else if (arr[pos1][pos2] instanceof Ant) {
            //north
            for (int inc = 0; (pos1 - inc) >= 0; inc++) {
                if (arr[pos1 - inc][pos2] instanceof Beetle) {
                    movementString = movementString.concat(Integer.toString(inc));
                }
                else {
                    movementString = movementString.concat("0");
                }
            }
            //east
            for (int inc = 0; (pos2 + inc) < 10; inc++) {
                if (arr[pos1][pos2 + inc] instanceof Ant) {
                    movementString = movementString.concat(Integer.toString(inc));
                }
                else {
                    movementString = movementString.concat("0");
                }
            }
            //south
            for (int inc = 10; (pos1 + inc) < 10; inc++) {
                if (arr[pos1 + inc][pos2] instanceof Ant) {
                    movementString = movementString.concat(Integer.toString(inc));
                }
                else {
                    movementString = movementString.concat("0");
                }
            }
            //west
            for (int inc = 0; (pos2 - inc) >= 0; inc++) {
                if (arr[pos1][pos2 - inc] instanceof Ant) {
                    movementString = movementString.concat(Integer.toString(inc));
                }
                else {
                    movementString = movementString.concat("0");
                }
            }
        }
        return movementString;
    }








}