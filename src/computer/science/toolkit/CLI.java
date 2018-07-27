/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer.science.toolkit;

import computer.science.toolkit.toolbox.BaseConversionsInterpreter;
import computer.science.toolkit.toolbox.BinaryInterpreter;
import computer.science.toolkit.toolbox.FloatingPointInterpreter;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class CLI {
    public void Run(){
        Scanner input = new Scanner(System.in);
        String tmp;
        int selection1;
        int selection2;
        int Page = 1;
        while(true){
            switch(Page){
                case 1:
                    System.out.println("Page 1 of 3:\n");
                    for(int i = 0; i < ComputerScienceToolKit.classl.getNumberOfClasses(); i++){
                        System.out.println(i + ". " + ComputerScienceToolKit.classl.cl[i].getName());
                    }
                    System.out.println("Type in a course index or 'Page' to change page");
                    tmp = input.nextLine();
                    if(tmp.contains("Page")){
                        System.out.print("Enter a page number: ");
                        Page = input.nextInt();
                    }else{
                        selection1 = Integer.parseInt(tmp);
                        for(int i = 0; i < ComputerScienceToolKit.classl.cl[selection1].getSuggestionCount(); i++){
                            System.out.println(i + ". " + ComputerScienceToolKit.classl.cl[selection1].getSuggestion(i).getName());
                        }
                        System.out.println("Type in a suggestion index or '.' to go back");
                        tmp = input.nextLine();
                        if(tmp.contains(".")){
                            continue;
                        }else{
                            selection2 = Integer.parseInt(tmp);
                            System.out.println(ComputerScienceToolKit.classl.cl[selection1].getSuggestion(selection2).getContent());
                            continue;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Page 1 of 3:\n");
                    System.out.println("0. Binary Interpretation\n1. Floating Point Interpreter\n2. MIPS to Binary\n3. Binary to MIPS\n4. Base Conversions\n5. Process Flow");
                    System.out.println("Type in a function index or 'Page' to change page");
                    tmp = input.nextLine();
                    if(tmp.contains("Page")){
                        System.out.print("Enter a page number: ");
                        Page = input.nextInt();
                    }else{
                        selection1 = Integer.parseInt(tmp);
                        switch(selection1){
                            case 0:
                                BinaryInterpreter BinIn;// = new BinaryInterpreter();
                                System.out.print("Input a binary string: ");
                                tmp = input.next();
                                BinIn = new BinaryInterpreter(tmp);
                                System.out.println("Unsigned: " + BinIn.unsignedConvert() + "\nSigned: " + BinIn.signedConvert() + "\nOne's Compliment: " + BinIn.onesComplimentConvert() + "\nTwo's Compliment: " + BinIn.twosComplimentConvert() + "\nBias: " + BinIn.biasConvert());
                                break;
                            case 1:
                                FloatingPointInterpreter fp;// = new BinaryInterpreter();
                                System.out.print("Input a binary string: ");
                                tmp = input.next();
                                fp = new FloatingPointInterpreter(tmp);
                                System.out.println(fp.singleLineView());
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                BaseConversionsInterpreter Basic;
                                System.out.print("Input a number, input base, and output base: ");
                                String num = input.next();
                                int ibs = input.nextInt();
                                int obs = input.nextInt();
                                Basic = new BaseConversionsInterpreter(num, ibs, obs);
                                System.out.print("\nOutput: " + Basic.convert());
                                break;
                            case 5:
                                System.out.println("Unsupported at this time");
                                break;
                            default:
                                System.out.println("Unrecognized command");
                                break;
                            
                        }
                    }
                    break;
                case 3:
                    System.out.println("Page 3 of 3:\n");
                    System.out.println("0. Load New File");
                    
                    break;
            }
        }
        
    }
}
