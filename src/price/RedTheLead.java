package price;

import java.util.ArrayList;
import java.util.List;

public class RedTheLead implements ChartType {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getType() {
		List list = new ArrayList();
		list.add("HIPIC,COPIC");
		list.add(0);
		return list;
	}

}
