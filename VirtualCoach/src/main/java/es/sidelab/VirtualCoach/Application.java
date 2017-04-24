package es.sidelab.VirtualCoach;

import java.util.Collections;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
@EnableCaching
@EnableHazelcastHttpSession
@SpringBootApplication
public class Application 
{
	private static final Log LOG = LogFactory.getLog(Application.class);
    public static void main( String[] args ) throws Exception 
    {
     SpringApplication.run(Application.class,args);
    }
    @Bean
    public Config config() {
    Config config = new Config();
    JoinConfig joinConfig = config.getNetworkConfig().getJoin();
    
    joinConfig.getMulticastConfig().setEnabled(false);
    joinConfig.getTcpIpConfig().addMember( "100.79.252.95" ).addMember( "100.79.180.38" )
    .setEnabled( true );
    return config;
    }

     @Bean 
     public CacheManager cacheManager(){
    	 LOG.info("Activando Caché...");
    	 return new ConcurrentMapCacheManager("VirtualCoach");
     }
  }
