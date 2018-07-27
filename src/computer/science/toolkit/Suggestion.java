/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer.science.toolkit;

/**
 *
 * @author daniel
 */
public class Suggestion {
    private String name;
    private String content;
    Suggestion(String name, String content){
        this.name = name;
        this.content = content;
    }
    
    public String getContent(){
        return this.content;
    }
    
    public String getName(){
        return this.name;
    }
}
