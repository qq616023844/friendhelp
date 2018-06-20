package tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class JWT {

	private static List<String> list = new ArrayList<String>();
	
	public static void addToken(String token) {
		list.add(token);
	}
	
	public static boolean hasToken(String token) {
		return list.contains(token);
	}
	
	public static boolean removeToken(String token) {
		return list.remove(token);
	}
}
