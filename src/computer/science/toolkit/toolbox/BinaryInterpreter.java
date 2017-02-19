/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer.science.toolkit.toolbox;

/**
 *
 * @author MLH-Admin
 */
public class BinaryInterpreter {
    private String binary;
    private int length;
    private int[] bArray;
    private String signed = null;
    private String unsigned = null;
    private String onesCompliment = null;
    private String twosCompliment = null;
    private String bias = null;
    
    
    public BinaryInterpreter(String binary){
        binary = cleanse(binary);
        this.binary = binary;
        this.length = binary.length();
        bArray = new int[length];
        for (int i = 0; i < length; i++) {//parse the string into the array
            if (binary.charAt(i) == '1') {
                bArray[i] = 1;
            } else {
                bArray[i] = 0;
            }
        }
    }
    
    public BinaryInterpreter(){
        
    }
    
    public String unsignedConvert(){
        if(this.unsigned != null){
            return this.unsigned;
        }
        int unsignedI = 0;//algebra for n(n) * 2^(n-1) + ... + n(0) * 2^0
        for (int i = 0; i < length; i++) {
            //System.out.println(unsigned);
            unsignedI += Math.pow((double) 2, (double) (length - 1 - i)) * bArray[i];
        }
        String out = unsignedI + "";
        this.unsigned = out;
        return out;
    }
    
    public String signedConvert(){
        if(this.signed != null){
            return this.signed;
        }
        int signedI = 0;
        String out = null;
        if (bArray[0] == 0) {
            for (int i = 0; i < this.length; i++) {
                //System.out.println(unsigned);
                signedI += Math.pow((double) 2, (double) (length - 1 - i)) * bArray[i];
            }
            out = signedI + "";
        } else {
            for (int i = 1; i < this.length; i++) {
                //System.out.println(unsigned);
                signedI += Math.pow((double) 2, (double) (length - 1 - i)) * bArray[i];
            }
            signedI *= -1;
            out = "-" + signedI;
        }
        this.signed = out;
        return out;
    }
    
    public String onesComplimentConvert(){
        if(this.onesCompliment != null){
            return this.onesCompliment;
        }
        int onesComplimentI = 0;
        String out = null;
        if (bArray[0] == 0) {
            for (int i = 0; i < this.length; i++) {
                //System.out.println(unsigned);
                onesComplimentI += Math.pow((double) 2, (double) (length - 1 - i)) * bArray[i];
            }
            out = onesComplimentI + "";
        } else {
            int bArrayFlipped[];// = new int[length];//new array for when the bits flip
            bArrayFlipped = bArray.clone();//clone for modification
            for (int i = 1; i < this.length; i++) {
                //System.out.println(unsigned);
                bArrayFlipped[i] = Math.abs(bArray[i] - 1);
                onesComplimentI += Math.pow((double) 2, (double) (length - 1 - i)) * bArrayFlipped[i];
            }
            onesComplimentI *= -1;
            if(onesComplimentI == 0){
                out = "-" + onesComplimentI;
            } else {
                out = "" + onesComplimentI;
            }
        }
        this.onesCompliment = out;
        return out;
    }
    
    public String twosComplimentConvert(){
        if(this.twosCompliment != null){
            return this.twosCompliment;
        }
        int twosComplimentI = 0;//algebra for -n(n) * 2^(n-1) + n(n-1) * 2^(n-2) + ... + n(0) * 2^0
        String out = null;
        for (int i = 0; i < this.length; i++) {
            //System.out.println(unsigned);
            if (i == 0) {
                twosComplimentI -= Math.pow((double) 2, (double) (length - 1 - i)) * bArray[i];
            } else {
                twosComplimentI += Math.pow((double) 2, (double) (length - 1 - i)) * bArray[i];
                //System.out.println("At iteration " + i + ", twosCompliment is " + twosCompliment + " but should have added " + bArray[i]);
            }
        }
        out = twosComplimentI + "";
        this.twosCompliment = out;
        return out;
    }
    
    public String biasConvert(){
        if(this.bias != null){
            return this.bias;
        }
        int biasI = 0;
        String out = null;
        for (int i = 0; i < this.length; i++) {
            //System.out.println(unsigned);
            biasI += Math.pow((double) 2, (double) (length - 1 - i)) * bArray[i];
        }

        biasI -= Math.pow((double) 2, (double) (length - 1)) - 1;
        out = biasI + "";
        this.bias = out;
        return out;
    }
    
    public static String cleanse(String binary){
        //0x
        //System.out.println(binary.replaceAll("[^01]", ""));
        return binary.replaceAll("[^01]", "");
    }
    
    public void cleanse(){
        this.binary = binary.replaceAll("[^01]", "");
    }
    
    public void setBinary(String binary){
        binary = cleanse(binary);
        this.binary = binary;
        this.length = binary.length();
    }
    
    public String getBinary(){
        return this.binary;
    }
    
    public void deriveLength(String binary){
        this.length = binary.length();
    }
    
    public int getLength(){
        return this.length;
    }
}
