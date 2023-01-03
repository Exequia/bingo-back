package are.bingo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import lombok.extern.log4j.Log4j2;

@Configuration
@EnableWebSocketMessageBroker
@Log4j2
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

  // @Override
  // public void configureMessageBroker(MessageBrokerRegistry config) {
  //   log.info("configureMessageBroker");
  //   config.enableSimpleBroker("/topic", "/queue");
  //   config.setApplicationDestinationPrefixes("/app");
  // }
  @Override
  public void configureMessageBroker(MessageBrokerRegistry config) {
      config.enableSimpleBroker("/topic/", "/queue/");                // 1
      config.setApplicationDestinationPrefixes("/app");               // 2
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {
    log.info("registerStompEndpoints");
    // registry.addEndpoint("/bingo-websocket").withSockJS();
    // registry.addEndpoint("/bingo-websocket").setAllowedOrigins("*").withSockJS();
    registry.addEndpoint("/bingo-websocket").setAllowedOrigins("http://localhost:4200").withSockJS();
  }
}