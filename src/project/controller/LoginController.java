package project.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import project.model.Admin;
import project.values.DialogMessage;
import project.view.*;
import project.model.*;


public class LoginController {
	ILoginForm mLoginForm;
	private Connection connection;
	
	ConnectDatabase connectDb = new ConnectDatabase();
	Admin admin = new Admin("", "");

	DialogMessage dialogMessage = new DialogMessage();
	public LoginController() {
		mLoginForm = new LoginForm();
	//	dbConfig.ConnectToMySQL();

		
			mLoginForm.setActionListenerForLoginButtonInLoginForm(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if ((mLoginForm.getUserName().compareTo("")) == 0 || (mLoginForm.getPassWord().compareTo("")) == 0) {
						dialogMessage.dialogLoginError(true);
					} else if (connectDb.isAdmin(mLoginForm.getUserName(), mLoginForm.getPassWord())) {
						mLoginForm.closeForm();
						new MainController(connectDb);
					} else {
						dialogMessage.dialogLoginError(false);
					}

				}
			});

			mLoginForm.setActionListenerForCancelButtonInLoginForm(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					mLoginForm.closeForm();
				}
			});
		}
	

}
