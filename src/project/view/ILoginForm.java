package project.view;

import java.awt.event.ActionListener;

public interface ILoginForm {
	public void setActionListenerForLoginButtonInLoginForm(ActionListener listener);

	public void setActionListenerForCancelButtonInLoginForm(ActionListener listener);
	public String getUserName();
	public String getPassWord();
	public void closeForm();
}
