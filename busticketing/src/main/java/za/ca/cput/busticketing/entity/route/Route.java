package za.ca.cput.busticketing.entity.route;


import javax.persistence.*;

@Entity
public class Route
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	private String description;

    public static Route create(String cape_town) {
		return null;
	}

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

	protected Route(){

	}

	private Route(Route.Builder builder) {
		this.name= builder.name;
		this.description = builder.description;
	}


	public static class Builder {
		private String id;
		private String name;
		private String description;

		public Route.Builder setId(String id) {
			this.id = id;
			return this;
		}

		public Route.Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Route.Builder setDescription(String description) {
			this.description = description;
			return this;
		}

		public Route.Builder copy(Route Route) {

			return this;
		}

		public Route build() {
			return new Route(this);
		}

	}

}


