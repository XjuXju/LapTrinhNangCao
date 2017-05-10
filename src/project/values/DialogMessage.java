package project.values;

import javax.swing.JOptionPane;



public class DialogMessage {
	public void dialogLoginError(Boolean isEmpty){
		if(isEmpty){
		JOptionPane.showMessageDialog(null, "Password or username is empty!","Error",JOptionPane.ERROR_MESSAGE) ;
		}else{
			JOptionPane.showMessageDialog(null, "Password or username is incorrect!","Error",JOptionPane.ERROR_MESSAGE) ;
		
		}
	}
	public void dialogEmpty(){
		JOptionPane.showMessageDialog(null, "Database is empty!","Error",JOptionPane.ERROR_MESSAGE) ;
	}
	public void dialogErrorTable(){
		
		JOptionPane.showMessageDialog(null, "You must select a row in table","Error",JOptionPane.ERROR_MESSAGE) ;
	}
	public void dialogUpdate(Boolean isUpdate){
		if(isUpdate){
			JOptionPane.showMessageDialog(null, "Update success ");
		}else {
			JOptionPane.showMessageDialog(null, "Error update! ","Error update",JOptionPane.ERROR_MESSAGE) ;
		}
		
	}
	public int dialogOption(){
		int select = JOptionPane.showOptionDialog(null, "Are you want delete","Delete",0,JOptionPane.YES_NO_OPTION, null, null, 1) ;
		return select;
	}
	// mAdd ==0 
	public void dialogAddNewStudent(int mAdd){
		if(mAdd==0){
			JOptionPane.showMessageDialog(null, "Add tudent success ");
		}else if(mAdd==1){
			JOptionPane.showMessageDialog(null, "Student already exists! ","Error add",JOptionPane.ERROR_MESSAGE) ;
		}else {
			JOptionPane.showMessageDialog(null, "You must fill out the parameters!","Error add",JOptionPane.ERROR_MESSAGE) ;
		}
		
	}
	public void dialogAddRecordTreatment(String message, Boolean isAdd){
		if(isAdd){
			JOptionPane.showMessageDialog(null, "Add tinformation success ");
		}else{
			JOptionPane.showMessageDialog(null, "Patient information is empty!, cann't add "+message,"Error add",JOptionPane.ERROR_MESSAGE) ;
		}
		
	}
	public void dialogShow(String message){
		JOptionPane.showMessageDialog(null, "Informatin of " + message + " is empty! ");
	}
	public static void dialogSearch(Boolean isSearch){
		if(isSearch){
		JOptionPane.showMessageDialog(null, "You must search id or name!");
		}else {
			JOptionPane.showMessageDialog(null,"Data is not valuable");	
		}
	}
public static void main(String[] args) {
	DialogMessage ms = new 	DialogMessage();
ms.dialogUpdate(true);
}


}
