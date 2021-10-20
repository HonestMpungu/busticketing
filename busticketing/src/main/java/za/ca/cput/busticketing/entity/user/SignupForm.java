package za.ca.cput.busticketing.entity.user;

public class SignupForm
{
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;

	public SignupForm(){
		super();
	}
	public SignupForm( String firstName, String lastName, String emailId, String password )
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
	}
}
