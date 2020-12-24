package com.redhat.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start() {
       Router router=Router.router(vertx);
       router.get("/api/v1/hello").handler(this::helloVertex);
       router.get("/api/v1/hello/:name").handler(this::helloName);
       vertx.createHttpServer().requestHandler(router).listen(8080);
    }

    void helloVertex(RoutingContext ctx){
        ctx.request().response().end("Hello vertx world!");
    }
    void helloName(RoutingContext ctx){
        String name=ctx.pathParam("name");
        ctx.request().response().end(String.format("Hello %s!",name));
    }

}
