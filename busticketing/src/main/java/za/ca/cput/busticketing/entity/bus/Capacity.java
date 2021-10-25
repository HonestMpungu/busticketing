package za.ca.cput.busticketing.entity.bus;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/*

Author : Asanda Mabaso - 205049990

 */
@Entity
public class Capacity {

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



    protected Capacity(){

    }

    private Capacity(Capacity.Builder builder) {
        this.name= builder.name;
        this.description = builder.description;
    }

    //remove getters please.

    public static class Builder {
        private String id;
        private String name;
        private String description;

        public Capacity.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Capacity.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Capacity.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Capacity.Builder copy(Capacity Capacity) {

            return this;
        }

        public Capacity build() {
            return new Capacity(this);
        }

    }
}
