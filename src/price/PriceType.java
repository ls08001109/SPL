package price;

public interface PriceType {
	public String entityBody(String[] price, Integer typeNum, Integer days1, Integer days2);
	public String theLead(String[] price, Integer typeNum, Integer days1, Integer days2);
	public String underLead(String[] price, Integer typeNum, Integer days1, Integer days2);
}
