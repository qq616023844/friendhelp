package tool;

import java.util.HashMap;
import java.util.Map;

public class MessageMap {

	private static Map<String, Integer> map = new HashMap();
	
	public static Integer searchMap(String l) {
		int geti = map.get(l);
		return geti;
	}
	public static void addMap(String l,Integer i) {
		map.put(l, i);
	}
	
	public static void removeMap(String l) {
		map.remove(l);
	}
}
