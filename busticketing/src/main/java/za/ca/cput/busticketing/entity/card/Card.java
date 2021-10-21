package za.ca.cput.busticketing.entity.card;

import javax.persistence.*;
import java.util.Date;
/**
 * @author Honest Mpungu
 * Student No:215072081
 * Group:Part Time
 * 20/10/2021
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
