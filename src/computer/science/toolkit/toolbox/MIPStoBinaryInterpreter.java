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
public class MIPStoBinaryInterpreter {
    private BinaryInterpreter BinIn;
    private String binary;
    private String opcode;
    private String type;
    private String rs;
    private String rt;
    private String rd;
    private String shamt;
    private String funct;
    private String intermediate;
    private String address;
    private String[][] name = new String[32][2];
    
    //Convert single mips instruction to binary CUT FOR TIME
    MIPStoBinaryInterpreter(String binary){
        BinIn = new BinaryInterpreter(binary);
        this.binary = BinIn.getBinary();
        this.opcode = this.binary.substring(0, 5);
        
    }
}
