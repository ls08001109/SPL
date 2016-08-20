package price;

import java.util.ArrayList;
import java.util.List;

public class GreenTheLead implements ChartType {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getType() {
		List list = new ArrayList();
		list.add("HIPIC,OPPIC");
		list.add(1);
		return list;
	}

}
