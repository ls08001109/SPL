package price;

import java.util.ArrayList;
import java.util.List;

public class GreenUnderLead implements ChartType {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getType() {
		List list = new ArrayList();
		list.add("COPIC,LOPIC");
		list.add(1);
		return list;
	}

}
