package za.ca.cput.busticketing.entity.bus;



import javax.persistence.*;

/*

Author : Asanda Mabaso - 205049990

 */
@Entity
public class BusCapacity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
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



    protected BusCapacity(){

    }

    private BusCapacity(BusCapacity.Builder builder) {
        this.name= builder.name;
        this.description = builder.description;
    }

    //remove getters please.

    public static class Builder {
        private String id;
        private String name;
        private String description;

        public BusCapacity.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public BusCapacity.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public BusCapacity.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public BusCapacity.Builder copy(BusCapacity BusCapacity) {

            return this;
        }

        public BusCapacity build() {
            return new BusCapacity(this);
        }

    }
}
