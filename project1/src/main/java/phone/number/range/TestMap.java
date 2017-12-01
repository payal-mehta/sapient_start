package phone.number.range;

import java.util.TreeMap;

public class TestMap {
	public static void main(String[] args) {
		Range r1=new Range(1,10);
		Range r2=new Range(11,20);
		Range r3=new Range(21,30);
		Range r4=new Range(31,40);
		TreeMap<Range,String> map = new TreeMap<Range, String>();
		map.put(r1, "AP");
		map.put(r2, "Karnataka");
		map.put(r3, "Haryana");
		map.put(r4, "Delhi");
		find(41,map);
	}

	 public  static void find(int number,TreeMap<Range, String> map){
		 Range request = new Range( number, number);
         Range result = (Range) map.floorKey(request);
         System.out.println(result.getMax()+"  " +result.getMin()+"  "+map.get(result));
     }


}
