package za.ca.cput.busticketing.entity.card;

import javax.persistence.*;
import java.util.Date;

/**
 * Honest Mpungu
 * Part -Time Class
 * Student Number 215072081
 */
@Entity
public class Card
{
	@Id
	@Column(name="card_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String cardColor;
	private double balance;
	private Date issueDate;

	public Integer getId()
	{
		return id;
	}

	public void setId( Integer id )
	{
		this.id = id;
	}

	public String getCardColor()
	{
		return cardColor;
	}

	public void setCardColor( String cardColor )
	{
		this.cardColor = cardColor;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance( double balance )
	{
		this.balance = balance;
	}

	public Date getIssueDate()
	{
		return issueDate;
	}

	public void setIssueDate( Date issueDate )
	{
		this.issueDate = issueDate;
	}
}
