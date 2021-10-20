package za.ca.cput.busticketing.entity.card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Honest Mpungu
 * Part -Time Class
 * Student Number 215072081
 */
@Entity
public class CardType {
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

}
