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

    protected UserCard(){

    }

    private UserCard(Builder builder) {
        this.name= builder.name;
       this.description = builder.description;
    }

    //remove getters please.

    public static class Builder {
        private Integer id;
        private String name;
        private String description;

        public Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(UserCard userCard) {

            return this;
        }

        public UserCard build() {
            return new UserCard(this);
        }

    }

    @Override
    public String toString() {
        return "UserCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
//    @Id
//    private Integer id;
//    @JoinColumn(name = "user_id")
//    private User user;
//    @JoinColumn(name="card_id")
//    private Card card;
}
