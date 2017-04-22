package es.sidelab.VirtualCoach;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheController {
	@Autowired
	private CacheManager cacheManager;
	
	public Map<Object, Object> getCacheContent(){
		ConcurrentMapCacheManager cacheMangr = (ConcurrentMapCacheManager) cacheManager;
		ConcurrentMapCache cache = (ConcurrentMapCache) cacheMangr.getCache("VirtualCoach(baseDeDatos)");
		return cache.getNativeCache();
		
	}

}
