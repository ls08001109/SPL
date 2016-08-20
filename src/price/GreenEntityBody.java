package price;

import java.util.ArrayList;
import java.util.List;

public class GreenEntityBody implements ChartType {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getType() {
		List list = new ArrayList();
		list.add("OPPIC,COPIC");
		list.add(1);
		return list;
	}

}
