package java_test.generic_collection_filtering_Problem1;

public interface LogicalFilter<T> {
	public boolean apply(T t);
}
