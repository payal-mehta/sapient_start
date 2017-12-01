package hash.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class MapTest {

public static void main(String[] args) {
	HashMap<Integer,Integer> map=new HashMap<Integer,Integer>(); 
	Map<Integer,Integer> syncMap=Collections.synchronizedMap(map);
	Map<Integer,Integer> conHash=new ConcurrentHashMap<Integer, Integer>();

	for(int i=0;i<5;i++){
	Thread th=new Thread(new Runnable() {
		
		@Override
		public void run() {
			for(int i=0;i<10000;i++){
				map.put(i, i);
				System.out.println(Thread.currentThread().getName()+i);

			}
			
		}
	},"Map "+i);
	th.start();
	}
	for(int i=0;i<5;i++){
		Thread th2=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<100000;i++){
					syncMap.put(i, i);
					System.out.println(Thread.currentThread().getName()+i);
				}
				
			}
		},"sync Map "+i);
		th2.start();
		}
	for(int i=0;i<5;i++){
		Thread th3=new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<100000;i++){
					conHash.put(i, i);
					System.out.println(Thread.currentThread().getName()+i);

				}
				
			}
		},"Conc Map "+i);
		th3.start();
		}
}

}

