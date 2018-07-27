/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer.science.toolkit.toolbox;

/**
 *
 * @author daniel
 */
public class BaseConversionsInterpreter {
    private String input;
    private int ibase;
    private int obase;
    private String output;
    
    //String value of input, int of input base, int of output base
    public BaseConversionsInterpreter(String input, int ibase, int obase){
        this.ibase = ibase;
        this.input = cleanse(input);
        this.obase = obase;
    }
    
    public BaseConversionsInterpreter(){
        
    }
    
    //Sanitize string input
    public String cleanse(String toclean){
        String notscrub = "[^";
        for(int i = 0; i < this.ibase; i++){
            notscrub += hotswapIntToChar(i);
        }
        return toclean.replaceAll(notscrub + "]", "");
    }
    
    //Converts existing object value
    public String convert(){
        String output = "";
        if(ibase > obase){
            int tmp = makeBase10(input, ibase);
            //int outputsize = (int)Math.ceil((Math.log(ibase)/Math.log(input.length()))* (double)obase);
            //System.out.println(tmp + " " + outputsize);
            //for(int i = 0; i < outputsize; i++){
            while(tmp > 0){
                output += hotswapIntToChar(tmp % obase);
                tmp /= obase;
            }
            String inv = "";
            for(int i = 0; i < output.length(); i++){
                inv += output.substring(output.length() - 1 - i, output.length() - i);
            }
            output = inv;
        } else if(ibase < obase){
            int tmp = makeBase10(input, ibase);
            //int outputsize = (int)Math.floor(Math.log(obase)/Math.log(input.length()) * (double)ibase);
            //for(int i = 0; i < outputsize; i++){
            while(tmp > 0){
                output += hotswapIntToChar(tmp % obase);
                tmp /= obase;
                //System.out.println(tmp);
            }
            String inv = "";
            for(int i = 0; i < output.length(); i++){
                inv += output.substring(output.length() - 1 - i, output.length() - i);
            }
            output = inv;
            
        } else {
            output = this.input;
        }
        this.output = output;
        return output;
    }
    
    //First converts value to base 10
    private int makeBase10(String input, int ibase){
        int output = 0;
        if(ibase < 10){
            for(int i = 0; i < input.length(); i++){
                output += Integer.parseInt(input.substring(input.length() - 1 - i, input.length() - i)) * Math.pow(ibase, i);
            }
        } else if(ibase > 10){
            for(int i = 0; i < input.length(); i++){
                output += hotswapCharToInt(input.substring(input.length() - 1 - i, input.length() - i)) * Math.pow(ibase, i);
            }
        } else {
            output = Integer.parseInt(input);
        }
            
        return output;
    }
    
    //Supports up to Base 36
    private int hotswapCharToInt(String chad){
        switch(chad){
            case "0":
                return 0;
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "A":
                return 10;
            case "B":
                return 11;
            case "C":
                return 12;
            case "D":
                return 13;
            case "E":
                return 14;
            case "F":
                return 15;
            case "G":
                return 16;
            case "H":
                return 17;
            case "I":
                return 18;
            case "J":
                return 19;
            case "K":
                return 20;
            case "L":
                return 21;
            case "M":
                return 22;
            case "N":
                return 23;
            case "O":
                return 24;
            case "P":
                return 25;
            case "Q":
                return 26;
            case "R":
                return 27;
            case "S":
                return 28;
            case "T":
                return 29;
            case "U":
                return 30;
            case "V":
                return 31;
            case "W":
                return 32;
            case "X":
                return 33;
            case "Y":
                return 34;
            case "Z":
                return 35;
            default:
                return -1;
        }
    }
    
    //Converts the int to its char representation
    private String hotswapIntToChar(int chad){
        switch(chad){
            case 0:
                return "0";
            case 1:
                return "1";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            case 16:
                return "G";
            case 17:
                return "H";
            case 18:
                return "I";
            case 19:
                return "J";
            case 20:
                return "K";
            case 21:
                return "L";
            case 22:
                return "M";
            case 23:
                return "N";
            case 24:
                return "O";
            case 25:
                return "P";
            case 26:
                return "Q";
            case 27:
                return "R";
            case 28:
                return "S";
            case 29:
                return "T";
            case 30:
                return "U";
            case 31:
                return "V";
            case 32:
                return "W";
            case 33:
                return "X";
            case 34:
                return "Y";
            case 35:
                return "Z";
            default:
                return "-1";
        }
    }
    
    //basic get/sets
    public String getInput(){
        return this.input;
    }
    
    public void setInput(String input){
        this.input = input;
    }
}
