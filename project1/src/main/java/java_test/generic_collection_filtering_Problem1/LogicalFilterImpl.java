package java_test.generic_collection_filtering_Problem1;

public class LogicalFilterImpl implements LogicalFilter<Trade> {

	@Override
	public boolean apply(Trade t) {
		if(t.getId() > 35)
			return true;
		return false;
	}

}
