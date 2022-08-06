package com.crackbyte.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    public static final String[] ALLOWED_WEBSOCKET_ORIGINS = {"http://localhost:3000", "http://localhost:8081"};

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/connect")
                /*
                 * custom interceptors can be used to handle the websocket request before handshake such as security handling
                 */
//                .addInterceptors(new CustomHandShakeInterceptor())
                .setAllowedOrigins(ALLOWED_WEBSOCKET_ORIGINS)
                /*
                 * if '*' is allowed then allowed credentials must be handled at request header
                 */
//                .setAllowedOrigins("*")
                .withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.setApplicationDestinationPrefixes("/app");
        registry.enableSimpleBroker("/room");

        /*
         * you can use this for a custom broker relay configuration to implement a better setup
         * registry.enableStompBrokerRelay("/room")
         *      .setRelayHost("localhost")
         *      .setRelayPort(port)
         *      .setClientLogin("guest")
         *      .setClientPasscode("guest");
         */
    }
}
