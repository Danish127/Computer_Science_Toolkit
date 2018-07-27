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
public class Class {
    private String name;
    private Suggestion sug[];
    
    public Class(String name, int n){
        this.name = name;
        sug = new Suggestion[n];
    }
    
    public void add(int index, String sName, String content){
        sug[index] = new Suggestion(sName, content);
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getSuggestionCount(){
        return this.sug.length;
    }
    
    public Suggestion getSuggestion(int i){
        return this.sug[i];
    }
}
