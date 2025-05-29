package com.r2dbcsample.websocket;



import com.r2dbcsample.services.PersonaService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Configuration
public class WebSocketConfig {

    @Bean
    public HandlerMapping webSocketMapping(PersonaWebSocketHandler handler) {
        return new SimpleUrlHandlerMapping(Map.of("/ws/persona", handler), -1);
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }

    @Bean
    public PersonaWebSocketHandler personaWebSocketHandler(PersonaService service) {
        return new PersonaWebSocketHandler(service.getUpdates());
    }

    public static class PersonaWebSocketHandler implements WebSocketHandler {
        private final Flux<String> updates;

        public PersonaWebSocketHandler(Flux<String> updates) {
            this.updates = updates;
        }

        @Override
        public Mono<Void> handle(org.springframework.web.reactive.socket.WebSocketSession session) {
            return session.send(
                    updates.map(session::textMessage)
            );
        }
    }
}
