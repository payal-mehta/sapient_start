package phone.number.range;

public class Range implements Comparable<Range>{
int min;
int max;
@Override
public int compareTo(Range o) {
	
	if(this.min<o.getMin() )
		return -1;
	if(this.min>o.getMin() )
		return 1;
	else
		return 0;
	
}
public int getMin() {
	return min;
}
public Range(int min, int max) {
	super();
	this.min = min;
	this.max = max;
}
public void setMin(int min) {
	this.min = min;
}
public int getMax() {
	return max;
}
public void setMax(int max) {
	this.max = max;
}
}
