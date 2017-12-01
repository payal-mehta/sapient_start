package java_test.generic_collection_filtering_Problem1;

import java.util.ArrayList;
import java.util.List;

public class SumAccumulatorFilterProviderImpl implements
		SumAccumulatorFilterProvider<Trade, Integer> {
	List<Trade> list = new ArrayList<Trade>();
	Integer sum = 0;

	@Override
	public void filterToAccumulate(Trade t) {
		if(t.getId() > 55) {//any condition to apply filter on
			list.add(t);
		}
	}

	@Override
	public Integer applyAggregation() {
		for (Trade pojo : list) {
			sum += pojo.getAmount();
		}
		return sum;
	}

}
