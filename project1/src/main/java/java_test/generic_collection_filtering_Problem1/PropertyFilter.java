package java_test.generic_collection_filtering_Problem1;

public interface PropertyFilter<T, E> {
	
	public E apply(T t);

}
