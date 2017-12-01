package java_test.generic_collection_filtering_Problem1;

public interface SumAccumulatorFilterProvider<T, E> {
	public void filterToAccumulate(T t);
	public E applyAggregation();
}
