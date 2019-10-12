package rough;

import java.util.HashMap;
import java.util.Set;

public class Test {
	
	public static void main(String[] args) {
		HashMap<String , String> map= new HashMap<String, String>();
		map.put("first", "1");
		Set<String> setOfKey=map.keySet();
		for(String key:setOfKey)
		{
			System.out.println(key);
		}
	}

}
