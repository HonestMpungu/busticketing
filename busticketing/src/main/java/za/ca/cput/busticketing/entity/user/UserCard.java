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

    private UserCard(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.description = builder.description;
    }

    private UserCard() {
    }
    public static class Builder {
        private Integer id;
        private String name;
        private String description;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDesc(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(UserCard userCard) {
            this.id= userCard.id;
            this.name = userCard.name;
            this.description = userCard.description;
            return this;
        }

        public UserCard build() {
            return new UserCard(this);
        }
    }



//    @Id
//    private Integer id;
//    @JoinColumn(name = "user_id")
//    private User user;
//    @JoinColumn(name="card_id")
//    private Card card;
}
