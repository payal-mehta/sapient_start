package java_test.generic_collection_filtering_Problem1;

public class PropertyFilterImpl implements PropertyFilter<Trade, Integer> {

	@Override
	public Integer apply(Trade t) {
		if (t.getId() > 65)
			return t.getAmount();
		return null;
	}

}
