package com.f1020.forum;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class RegisterAction extends ActionSupport implements Preparable{
	private String username;
	private String password;
	private String name;
	private String nic;
	private String sex;
	private int age;
	private String email;
	private String phone;
	private String selfshow;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSelfshow() {
		return selfshow;
	}
	public void setSelfshow(String selfshow) {
		this.selfshow = selfshow;
	}
	
	public void validate() {
		if((sex.equals(null)) || (!sex.equals("Ů") && !sex.equals("��"))){
			addFieldError(sex, "�Ա���д����");
		}
	}
	
	@Override
	public String execute() throws Exception {  
	    // TODO Auto-generated method stub  
		UsersDAO usersDAO=new UsersDAO();
		boolean flag=usersDAO.findUsers(username);
		if(flag){
			return INPUT;
		}
		Users users=new Users();
		System.out.println(username);
		users.setUsername(username);
		users.setPassword(password);
		users.setName(name);
		users.setNic(nic);
		users.setSex(sex);
		users.setAge(age);
		users.setEmail(email);
		users.setPhone(phone);
		users.setSelfshow(selfshow);
		int i = usersDAO.saveUsers(users);
		if(i>0){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		clearErrorsAndMessages();
	}
}
