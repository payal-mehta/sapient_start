package java_test.generic_collection_filtering_Problem1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Tester {
	public static void main(String[] args) {
		GenericCollectionClass<Trade, Integer> collectionClass = new GenericCollectionClass<>();


		List<Trade> pojos = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			pojos.add(new Trade(i,  i*5));
		}

		collectionClass.setCollection(pojos);
		Integer sumOfIds = collectionClass.applyAggregation(new SumAccumulatorFilterProviderImpl());
		System.out.println(sumOfIds);
		
	}

}
