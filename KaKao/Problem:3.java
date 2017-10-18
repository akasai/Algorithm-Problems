import java.util.Queue;
import java.util.LinkedList;

public class Main{
	static final int HIT = 1;
	static final int MISS = 5;
	
	public static void main(String[] args){
		/* input  고정 */
		int cacheSize[] = {3, 3, 2, 5, 2, 0};
		String cities[][] = {{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}
							,{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}
							,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
							,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}
							,{"Jeju", "Pangyo", "NewYork", "newyork"}
							,{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}};
		
		System.out.println("----- Stack -----");
		for(int i = 0; i < cacheSize.length; i++)
			System.out.println(LRU_Array(cacheSize[i], cities[i]));
		
		System.out.println("----- Queue -----");
		for(int i = 0; i < cacheSize.length; i++)
			System.out.println(LRU_Queue(cacheSize[i], cities[i]));
	}
	/* LRU 알고리즘 : Queue */
	private static int LRU_Queue(int cache, String city[]){
		//cache크기에 따른 예외처리
		if(cache == 0 || cache >= city.length)
			return 5*city.length;
		
		Queue<String> cache_mem = new LinkedList<String>(); 	//Cache메모리
		int ret_time = 0;					//소요시간
		
		for(String c : city){
			if(cache_mem.contains(c.toLowerCase())){	//Cache에 있을 경우
				cache_mem.remove(c.toLowerCase());
				cache_mem.add(c.toLowerCase());
				ret_time += HIT;
			}else{						//Cache에 없을 경우
				if(cache_mem.size() < cache){	//CacheSize보다 작을 경우
					cache_mem.add(c.toLowerCase());
				}else{				//CacheSize보다 크거나 같을 경우
					cache_mem.poll();
					cache_mem.add(c.toLowerCase());
				}
				ret_time += MISS;
			}
		}
		return ret_time;
	}
	/* LRU 알고리즘 : Array */
	private static int LRU_Array(int cache, String city[]){
		//cache크기에 따른 예외처리
		if(cache == 0 || cache >= city.length)
			return MISS*city.length;
		
		String cache_mem[] = new String[cache];		//Cache메모리
		int ret_time = 0;				//소요시간
		
		/* Cache Size만큼 우선 저장 */
		for(int i = 0; i < cache; i++){
			cache_mem[i] = city[i];
			ret_time += MISS;
		}
		
		/* 나머지List 스케줄링 */
		for(int i = cache; i < city.length; i++)
			ret_time = LRU(city[i], cache_mem, ret_time);
		
		return ret_time;
	}
	/* Cache에 존재 확인 */
	private static int LRU(String target, String[] array, int time){
		int ret = time;
		
		if(isInArray(target, array)){	//Cache에 있을 경우
			changeQueue(getStringIndex(target, array), target, array);
			ret += HIT;
		}else{				//Cache에 없을 경우
			changeQueue(0, target, array);
			ret += MISS;
		}
		
		return ret;
	}
	/* Cache index return */
	private static int getStringIndex(String target, String[] cache){
		int idx = 0;
		for(int i = 0; i < cache.length; i++)
			if(cache[i].toLowerCase().equals(target.toLowerCase()))
				idx = i;
		return idx;
	}
	/* Cache 존재 return */
	private static boolean isInArray(String target, String[] cache){
		for(int i = 0; i < cache.length; i++)
			if(cache[i].toLowerCase().equals(target.toLowerCase()))
				return true;
		return false;
	}
	/* Cache 스케줄링 */
	private static void changeQueue(int idx, String target, String[] q){
		for(int i = idx; i < q.length-1; i++)
			q[i] = q[i+1];
		q[q.length-1] = target;
	}
}
