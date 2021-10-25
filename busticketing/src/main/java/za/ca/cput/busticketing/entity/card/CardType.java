package za.ca.cput.busticketing.entity.card;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author Honest Mpungu
 * Student No:215072081
 * Group:Part Time
 * 20/10/2021
 */
@Entity
public class CardType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    protected CardType() {

    }

    private CardType(CardType.Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
    }

    //remove getters please.

    public static class Builder {
        private Integer id;
        private String name;
        private String description;

        public CardType.Builder setId(Integer id) {
            this.id = id;
            return this;
        }

        public CardType.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public CardType.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public CardType.Builder copy(CardType cardType) {

            return this;
        }

        public CardType build() {
            return new CardType(this);
        }

    }
}