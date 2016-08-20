package price;

import java.util.ArrayList;
import java.util.List;

public class RedUnderLead implements ChartType {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List getType() {
		List list = new ArrayList();
		list.add("OPPIC,LOPIC");
		list.add(0);
		return list;
	}

}
