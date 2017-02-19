/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computer.science.toolkit;
/**
 *
 * @author MLH-Admin
 */
public class ClassList {
    
	private String school;
	private String semester;
	private int numberOfClasses;
        public Class cl[];
        
        public ClassList(String school, String semester, int numberOfClasses){
            this.school = school;
            this.semester = semester;
            this.numberOfClasses = numberOfClasses;
            this.cl = new Class[numberOfClasses];
        }

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
        
	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public int getNumberOfClasses() {
		return this.numberOfClasses;
	}

	public void setNumberOfClasses(int numberOfClasses) {
		this.numberOfClasses = numberOfClasses;
	}
        //, int sNum, String sName, String sText
        public void addClass(int index, String cName, int sNum){
            cl[index] = new Class(cName, sNum);
            //for(int i = 0; i < sNum; i++){
                //cl[index].add(sNum, sName, sText);
            //}
        }
    
}
