package price;

public class CandlestickChart implements PriceType {
	
	@SuppressWarnings("unused")
	private String price [] = {"COPIC", "OPPIC", "HIPIC" ,"OPPIC"};
	private String type [] = {"R", "G"};

	@Override
	public String entityBody(String[] price, Integer typeNum, Integer days1, Integer days2) {
		this.price = price;
		String spl ="";
		if (days1 > 0 && days2 > 0) {
			spl += price[0] + "["+ days1 + "] / " + price[1] + "[" + days2 + "]";
			spl += " AS REALBODY"+ type[typeNum] + days1;
		} else if (days1 > 0) {
			spl += price[0] + "["+ days1 + "] / " + price[1];
			spl += " AS REALBODY"+ type[typeNum] + days1;
		} else if (days2 > 0) {
			spl += price[0] + " / + price[1] +[" + days2 + "]";
			spl += " AS REALBODY"+ type[typeNum] + days1;			
		} else {
			spl += price[0] + " / " + price[1];
			spl += " AS REALBODY" + type[typeNum];
		}
		return spl;
	}

	@Override
	public String theLead(String[] price, Integer typeNum, Integer days1, Integer days2) {
		return entityBody(price, typeNum, days1, days2).replace("REALBODY", "UPPERS");
	}

	@Override
	public String underLead(String[] price, Integer typeNum, Integer days1, Integer days2) {
		// TODO Auto-generated method stub
		return entityBody(price, typeNum, days1, days2).replace("REALBODY", "LOWERS");
	}

}
