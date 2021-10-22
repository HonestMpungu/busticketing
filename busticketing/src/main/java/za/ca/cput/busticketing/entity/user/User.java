package za.ca.cput.busticketing.entity.user;

import javax.persistence.*;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * User Entity class
 */

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(name="firstname")
	private String firstName;
	@Column(name="lastname")
	private String lastName;
	private String phone;
	private String email;
	private String password;

	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id )
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName( String firstName )
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName( String lastName )
	{
		this.lastName = lastName;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone( String phone )
	{
		this.phone = phone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public String getPassword()	{ return password; }

	public void setPassword( String password ) { this.password = password; 	}

	public User(){}

	private User(Builder builder) {
		this.id = builder.id;
		this.firstName = builder.firstname;
		this.lastName = builder.lastname;
		this.phone = builder.phone;
		this.email = builder.email;

	}

	public static class Builder {
		private Integer id;
		private String firstname;
		private String lastname;
		private String phone;
		private String email;

		public Builder setId(int id) {
			this.id = id;
			return this;
		}

		public Builder setFirstname(String firstname) {
			this.firstname = firstname;
			return this;
		}

		public Builder setLastname(String lastname) {
			this.lastname = lastname;
			return this;
		}

		public Builder setPhone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}

		public Builder copy(User user) {
			this.id = user.id;
			this.firstname = user.firstName;
			this.lastname = user.lastName;
			this.phone = user.phone;
			this.email = user.email;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
