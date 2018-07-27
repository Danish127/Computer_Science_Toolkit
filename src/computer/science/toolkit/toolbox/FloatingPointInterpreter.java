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
public class FloatingPointInterpreter {
    BinaryInterpreter BinIn;
    private String signS = null;
    private String exponentS = null;
    private int exponent;
    private String significandS = null;
    private int significand;
    private int bin[];
    
    //Represent floating points as their numeric representation
    public FloatingPointInterpreter(String binary){
        BinIn = new BinaryInterpreter(binary);
        if(BinIn.getLength() == 32){
            bin = new int[32];
            for(int i = 0; i < 32; i++){
                if(BinIn.getBinary().charAt(i) == '1'){
                    bin[i] = 1;
                }else{
                    bin[i] = 0;
                }
            }
            this.signS = BinIn.getBinary().substring(0, 1);
            this.exponentS = BinIn.getBinary().substring(1, 9);
            this.exponent = Integer.parseInt(new BinaryInterpreter(BinIn.getBinary().substring(1, 9)).biasConvert());
            this.significandS = BinIn.getBinary().substring(9, 32);
            this.significand = Integer.parseInt(new BinaryInterpreter(BinIn.getBinary().substring(9, 32)).unsignedConvert());
        } else if(BinIn.getLength() == 64){
            bin = new int[64];
            for(int i = 0; i < 64; i++){
                if(BinIn.getBinary().charAt(i) == '1'){
                    bin[i] = 1;
                }else{
                    bin[i] = 0;
                }
            }
            this.signS = BinIn.getBinary().substring(0, 1);
            this.exponentS = BinIn.getBinary().substring(1, 12);
            this.exponent = Integer.parseInt(new BinaryInterpreter(BinIn.getBinary().substring(1, 9)).biasConvert());
            this.significandS = BinIn.getBinary().substring(12, 64);
            this.significand = Integer.parseInt(new BinaryInterpreter(BinIn.getBinary().substring(9, 32)).unsignedConvert());
        }else{
            
        }
        
        
    }
    
    //Shows string of value
    public String singleLineView(){
        String out = null;
        if(this.signS.equals("1")){
            out += "-1";
        } else {
            out = "1";
        }
        out += " x 1.";
        double tmp = 0.0f;
        for(int i = 1; i < 9; i++){
            tmp += bin[i]/Math.pow(2, -1);
        }
        out += 1 + tmp;
        out += " x 2^(" + this.exponent +")";
        
        
        return out;
        
    }
}
