package za.ca.cput.busticketing.entity.user;

import za.ca.cput.busticketing.entity.card.Card;

import javax.persistence.*;
/**
 * @author M Manyati
 * Student No:215211855
 * Group:Part Time
 * UserCard Entity class
 */

@Entity
public class UserCard {
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


//    @Id
//    private Integer id;
//    @JoinColumn(name = "user_id")
//    private User user;
//    @JoinColumn(name="card_id")
//    private Card card;
}
