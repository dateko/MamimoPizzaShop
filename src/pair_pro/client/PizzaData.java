package pair_pro.client;

import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class PizzaData {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	
	 @Persistent
	 private String number; 
	 
	 @Persistent
	 private String topping; 
	 
	 
	  @Persistent
	  private Date date;

	  
	  public PizzaData(){}
	  
	  public PizzaData(String topping ,String number, Date date){
	   this.topping = topping;
	   this.number = number;
	   this.date = date;

	  }

	public Long getId() {
		    return id;
		    }
	  
	 public String getNumber() {
		 return number;
		    }
	 
	 public String getTopping() {
		 return topping;
		    }
	 
	  public void setNumber(String number) {  
		  this.number = number;
		  }
	  
	  public void Topping(String topping) {  
		  this.topping = topping;
		  }
	  
	 public Date getDate() {
		    return date;
		  }


	  
	 
}
