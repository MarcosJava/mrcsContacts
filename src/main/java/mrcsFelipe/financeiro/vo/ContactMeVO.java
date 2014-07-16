package mrcsFelipe.financeiro.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ContactMeVO implements Serializable {
	
	@NotNull @NotEmpty
	private String firstName;
	
	@NotNull @NotEmpty
	private String lastName;
	
	@NotNull @NotEmpty
	@Email(message="E-mail preenchido errado")
	private String email;
	
	private String subject;
	
	@Size(min=10, message="A mensagem tem que ter no minimo 10 characters (letras)")
	@NotNull @NotEmpty
	private String message;

	
	public ContactMeVO() {
		// TODO Auto-generated constructor stub
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ContactMeVO [firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", subject=" + subject + ", message="
				+ message + "]";
	}
	
	
}
