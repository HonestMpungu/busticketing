package za.ca.cput.busticketing.entity.route;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Author: Sanele Ngwenya
 * No.: 216019699
 * Group: PT
 */
@Entity
public class BusStop {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;

    public static BusStop create(String cape_town) {
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

    protected BusStop (){

    }

    private BusStop (BusStop .Builder builder) {
        this.name= builder.name;
        this.description = builder.description;
    }


    public static class Builder {
        private String id;
        private String name;
        private String description;

        public BusStop.Builder setId(String id) {
            this.id = id;
            return this;
        }

        public BusStop.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public BusStop.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public BusStop.Builder copy(BusStop BusStop) {

            return this;
        }

        public BusStop build() {
            return new BusStop(this);
        }
    }

}
