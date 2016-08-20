package price;

import java.util.ArrayList;
import java.util.List;

public class RedEntityBody implements ChartType {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List getType() {
		List list = new ArrayList();
		list.add("COPIC,OPPIC");
		list.add(0);
		return list;
	}

}
