package encryptdecrypt;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String[] parsedArgument = parseArguments(args); // 0 = mode, 1 = key, 2 = data, 3 = in, 4 = out, 5 = algorithm
        String mode = parsedArgument[0];
        int key = Integer.parseInt(parsedArgument[1]);
        String data;
        String fileInput = parsedArgument[3];
        String output = parsedArgument[4];
        String alg = parsedArgument[5];
        
        Context context = null;
    
        String result;
        
        // decide what value data takes
        if(!fileInput.equals("")) {
            File inputFile = new File(fileInput);
            Scanner fileReader = new Scanner(inputFile);
    
            data = fileReader.nextLine();
            fileReader.close();
        } else {
            data = parsedArgument[2];
        }
    
        switch (alg) {
            case "shift":
                context = new Context(new Shift());
                break;
            case "unicode" :
                context = new Context(new Unicode());
                break;
            default:
                break;
        }
        if (context != null) {
            result = context.operation(mode, data, key);
        } else {
            result = "";
        }
        
        if(!output.equals("")){
            File outFile = new File(parsedArgument[4]);
            PrintWriter writer = new PrintWriter(outFile);
            writer.print(result);
            writer.close();
        } else {
            System.out.println(result);
        }
    }
    
    
    /** Returns a String[5] which includes values corresponding to the keys
    0 = mode, 1 = key, 2 = data, 3 = in, 4 = out, 5 = algorithm
    */
    
    private static String[] parseArguments(String[] str){
        String[] parsedArgs = {"", "", "", "", "", ""};
        
        for(int i = 0, j = 1; j <= str.length; i+=2, j+=2){
            switch (str[i]) {
                case "-mode":
                    parsedArgs[0] = str[j];
                    break;
                case "-key":
                    parsedArgs[1] = str[j];
                    break;
                case "-data":
                    parsedArgs[2] = str[j];
                    break;
                case "-in":
                    parsedArgs[3] = str[j];
                    break;
                case "-out":
                    parsedArgs[4] = str[j];
                    break;
                case "-alg":
                    parsedArgs[5] = str[j];
                    break;
            }
        }
    
        Scanner sc = new Scanner(System.in);
        
        if(parsedArgs[0].equals("")){
            parsedArgs[0] = "enc";
        }
        if(parsedArgs[1].equals("")){
            System.out.print("Please enter encryption key: ");
            parsedArgs[1] = sc.nextLine();
        }
        if(parsedArgs[2].equals("") && parsedArgs[3].equals("")){
            System.out.print("Please enter data to be encrypted: ");
            parsedArgs[2] = sc.nextLine();
        }
        if(parsedArgs[5].equals("")){
            System.out.print("Please select an algoritm from the list \n 1- shift: ");
            parsedArgs[2] = sc.nextLine();
        }

        sc.close();
        
        return parsedArgs;
    }
}