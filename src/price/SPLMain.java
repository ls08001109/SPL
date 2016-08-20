package price;

import java.util.ArrayList;
import java.util.List;

public class SPLMain {

	public static void main(String[] args) {
		
		String SPL = "";
		
		Integer days = 5; //天數
		Integer typeNum[] = {1,1,2,2,2}; //紅K = 1, 綠K = 2
		
		double line = 1.03;
		double entity = 1.025;
		double entity2 = 1.01;
		//百分比 設置量 為天 的 三倍
		double percentage[] = {entity,line,line,
							   entity2,line,line,
							   entity2,line,line,
							   entity2,line,line,
							   entity,line,line,
							   }; 
		int fr = 20160601; //起始天數
		int to = 20160804; //結束天數
		
		List<String> condition = new ArrayList<String>();
		
		SPL += chartBuilder(SPL, days, fr, to, typeNum, percentage, condition);
		
		System.out.println(SPL);
	}

	/**
	 * SPL K線語法組合
	 * @param SPL
	 * @param day
	 * @param to 
	 * @param fr 
	 * @param typeNum
	 * @param percentage 
	 * @param condition
	 * @return
	 */
	private static String chartBuilder(String SPL, Integer day, int fr, int to, 
			Integer[] typeNum, double[] percentage, List<String> condition) {
		
		List<ChartType> ctListR = ctListR();
		List<ChartType> ctListG = ctListG();

		PriceType pt = new CandlestickChart();
		
		int j = 0;

		SPL = "SELECT " + "\n";
		for (int i = 0 ; i < day ; i++) {
			String [] type ;
			for (ChartType ct : typeNum[i] == 1 ? ctListR : ctListG) {
				List chartList = ct.getType();
				type = ((String)chartList.get(0)).split(",");
				String note = "";
				if (ct instanceof GreenEntityBody || ct instanceof RedEntityBody) {
					note = pt.entityBody(type, (Integer)chartList.get(1), i, i) + ",\n";
				} else if (ct instanceof GreenTheLead || ct instanceof RedTheLead) {
					note = pt.theLead(type, (Integer)chartList.get(1), i, i) + ",\n";
				} else if (ct instanceof GreenUnderLead || ct instanceof RedUnderLead) {
					note = pt.underLead(type, (Integer)chartList.get(1), i, i) + ",\n";
				}
				
				condition.add((j == 0 ? "WHERE " : "AND ") + note.substring(note.indexOf("AS")+3)
						.replace(",\n", "") + (note.indexOf("REALBOD") != -1 ? " > ": " < ") 
						+ percentage[j] + "\n");
				
				SPL += note;
				j ++;
			}
		}
		SPL = SPL.substring(0, SPL.lastIndexOf(",")) + "\n" ;
		SPL += "FROM " + fr + " TO " + to + "\n";
		
		for (String c : condition) {
			SPL += c;
		}
		return SPL;
	}

	/**
	 * 紅K
	 * @return
	 */
	private static List<ChartType> ctListG() {
		List<ChartType> ctListG = new ArrayList<ChartType>();
		ctListG.add(new GreenEntityBody());
		ctListG.add(new GreenTheLead());
		ctListG.add(new GreenUnderLead());
		return ctListG;
	}

	/**
	 * 綠K
	 * @return
	 */
	private static List<ChartType> ctListR() {
		List<ChartType> ctListR = new ArrayList<ChartType>();
		ctListR.add(new RedEntityBody());
		ctListR.add(new RedTheLead());
		ctListR.add(new RedUnderLead());
		return ctListR;
	}

}
