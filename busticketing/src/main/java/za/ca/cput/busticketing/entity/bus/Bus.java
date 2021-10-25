package za.ca.cput.busticketing.entity.bus;

import za.ca.cput.busticketing.entity.card.CardStatus;

import javax.persistence.*;

/*

Author : Asanda Mabaso - 205049990

 */
@Entity
public class Bus
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;

	public Integer getId() { return id; }

	public void setId( Integer id ) { this.id = id; }

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription( String description )
	{
		this.description = description;
	}



	protected Bus(){

	}

	private Bus(Bus.Builder builder) {
		this.name= builder.name;
		this.description = builder.description;
	}

	//remove getters please.

	public static class Builder {
		private String id;
		private String name;
		private String description;

		public Bus.Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Bus.Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Bus.Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Bus.Builder copy(Bus Bus) {

			return this;
		}

		public Bus build() {
			return new Bus(this);
		}

	}
}
