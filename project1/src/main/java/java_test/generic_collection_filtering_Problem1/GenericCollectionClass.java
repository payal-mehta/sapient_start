package java_test.generic_collection_filtering_Problem1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenericCollectionClass<T, E> {

	Collection<T> collection;

	public Collection<T> getCollection() {
		return collection;
	}

	public void setCollection(Collection<T> collection) {
		this.collection = collection;
	}

	
	public Collection filter(LogicalFilter filter) {
		Collection filteredCollection = new ArrayList();
		for (T t : this.collection) {
			if(filter.apply(t)) {
				filteredCollection.add(t);
			}
		}
		return filteredCollection;
	}
	
	public Collection filterByProperty(PropertyFilter propertyFilter) {
		Collection filteredCollection = new ArrayList();
		for (T t : this.collection) {
			Object apply = propertyFilter.apply(t);
			if(apply != null) {
				filteredCollection.add(apply);
			}
		}
		return filteredCollection;
	}
	
	public E applyAggregation(SumAccumulatorFilterProvider<T, E> accumulatorFilterProvider) {
		for (T t : collection) {
			accumulatorFilterProvider.filterToAccumulate(t);
		}
		return accumulatorFilterProvider.applyAggregation();
	}

}
