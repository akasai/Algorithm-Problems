import java.util.Queue;
import java.util.LinkedList;

public class Main{
public static void main(String[] args){
		//Scanner sc = new Scanner(System.in);
		int cacheSize[] = {3, 3, 2, 5, 2, 0};
		String cities[][] = {{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
							,{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}
							,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
							,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
							,{"Jeju", "Pangyo", "NewYork", "newyork"}
							,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}};
		
		System.out.println("----- Stack -----");
		for(int i = 0; i < cacheSize.length; i++)
			System.out.println(Schedualing(cacheSize[i], cities[i]));
		
		System.out.println("----- Queue -----");
		for(int i = 0; i < cacheSize.length; i++)
			System.out.println(LRUSchedualing(cacheSize[i], cities[i]));
	}
	private static int LRUSchedualing(int cache, String city[]){
		if(cache == 0 || cache >= city.length)
			return 5*city.length;
		
		Queue<String> cache_mem = new LinkedList<String>(); 
		int ret_time = 0;
		
		for(String c : city){
			if(cache_mem.contains(c.toLowerCase())){	//있을 경우
				cache_mem.remove(c.toLowerCase());
				cache_mem.add(c.toLowerCase());
				ret_time += 1;
			}else{	//없을 경우
				if(cache_mem.size() < cache){	//캐시크기보다 작을 경우
					cache_mem.add(c.toLowerCase());
				}else{		//캐시크기보다 크거나 같을 경우
					cache_mem.poll();
					cache_mem.add(c.toLowerCase());
				}
				ret_time += 5;
			}
		}
		return ret_time;
	}
	private static int Schedualing(int cache, String city[]){
		if(cache == 0 || cache >= city.length)
			return 5*city.length;
		
		String cache_mem[] = new String[cache];
		int ret_time = 0;
		
		for(int i = 0; i < cache; i++){
			cache_mem[i] = city[i];
			ret_time += 5;
		}
		
		for(int i = cache; i < city.length; i++)
			ret_time = LRU(city[i], cache_mem, ret_time);
		
		return ret_time;
	}
	private static int LRU(String target, String[] array, int time){
		int ret = time;
		
		if(isInArray(target, array)){	//캐시에 있으면
			changeQueue(getStringIndex(target, array), target, array);
			ret += 1;
		}else{	//캐시에 없으면
			changeQueue(0, target, array);
			ret += 5;
		}
		
		return ret;
	}
	private static int getStringIndex(String target, String[] cache){
		int idx = 0;
		for(int i = 0; i < cache.length; i++)
			if(cache[i].toLowerCase().equals(target.toLowerCase()))
				idx = i;
		return idx;
	}
	private static boolean isInArray(String target, String[] cache){
		for(int i = 0; i < cache.length; i++)
			if(cache[i].toLowerCase().equals(target.toLowerCase()))
				return true;
		return false;
	}
	private static void changeQueue(int idx, String target, String[] q){
		for(int i = idx; i < q.length-1; i++){
			q[i] = q[i+1];
		}
		q[q.length-1] = target;
	}
}
