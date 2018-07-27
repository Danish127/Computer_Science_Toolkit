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
public class BinarytoMIPSInterpreter {

    private String binary;
    private String opcode;
    private char type;
    private String name;
    private String mnemonic;
    private String rs;
    private String rt;
    private String rd;
    private String shamt;
    private String funct;
    private String immediate;
    private String address;

    //Intilize binary string
    public BinarytoMIPSInterpreter(String binary) {
        this.binary = binary;
        this.opcode = binary.substring(0, 5);
        this.funct = binary.substring(26, 31);
        this.mnemonic = deriveMnemonic(opcode, funct);
        this.type = getFunction(opcode).charAt(0);
        this.name = getFunction(opcode);
    }

    //Break down the instruction
    public String deriveMnemonic(String opcode, String funct) {
        String tmp = "";
        switch (opcode) {
            case "000000":
                
                break;
            case "100000":
                tmp = "add";
                break;
            case "001000":
                tmp = "addi";
                break;
            case "001001":
                tmp = "addiu";
                break;
            case "100100":
                tmp = "and";
                break;
            case "001100":
                tmp = "andi";
                break;
            case "000100":
                tmp = "beq";
                break;
            case "000101":
                tmp = "bne";
                break;
            case "000010":
                tmp = "j";
                break;
            case "000011":
                tmp = "jal";
                break;
           /* 
                
            Cut for time    
            case "001000":
                tmp = "jr";
                break;
            case "100000":
                tmp = "lbu";
                break;
            case "100000":
                tmp = "lhu";
                break;
            case "100000":
                tmp = "ll";
                break;
            case "100000":
                tmp = "lui";
                break;
            case "100000":
                tmp = "lw";
                break;
            case "100000":
                tmp = "nor";
                break;
            case "100000":
                tmp = "or";
                break;
            case "100000":
                tmp = "ori";
                break;
            case "100000":
                tmp = "slt";
                break;
            case "100000":
                tmp = "slti";
                break;
            case "100000":
                tmp = "sltiu";
                break;
            case "100000":
                tmp = "sltu";
                break;
            case "100000":
                tmp = "sll";
                break;
            case "100000":
                tmp = "srl";
                break;
            case "100000":
                tmp = "sb";
                break;
            case "100000":
                tmp = "sc";
                break;
            case "100000":
                tmp = "sh";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sub";
                break;
            case "100000":
                tmp = "subu";
                break;
            /*case "100000":
                tmp = "bclt";
                break;
            case "100000":
                tmp = "bclf";
                break;
            case "100000":
                tmp = "div";
                break;
            case "100000":
                tmp = "divu";
                break;
            case "100000":
                tmp = "add.s";
                break;
            case "100000":
                tmp = "add.d";
                break;
            case "100000":
                tmp = "";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;
            case "100000":
                tmp = "sw";
                break;*/

            default:
                tmp = "Unknown or unimplemented command";
                break;

        }
        return tmp;
    }

    //derive the function from the opcode CUT FOR TIME
    public String getFunction(String opcode) {
        String tmp = "";
        switch (opcode) {

        }
        return tmp;
    }

    //Gets/Sets
    public String getBinary() {
        return this.binary;
    }

    public void setBinary(String binary) {
        this.binary = binary;
    }

}
