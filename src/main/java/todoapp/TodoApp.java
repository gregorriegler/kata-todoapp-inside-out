package todoapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Spark;

import static org.eclipse.jetty.http.HttpStatus.NOT_IMPLEMENTED_501;
import static spark.Spark.*;

public class TodoApp {

    private static Logger logger = LoggerFactory.getLogger(TodoApp.class);

    private static final String INTERNAL_SERVER_ERROR = "Internal server error.";

    private Routes routes = new Routes();

    public void start() {
        start(8080);
    }

    public void start(int port) {
        port(port);
        enableCORS();
        setLog();
        routes.create();
        configureInternalServerError();
    }

    public void stop() {
        Spark.stop();
    }

    public void awaitInitialization() {
        Spark.awaitInitialization();
    }

    private void configureInternalServerError() {
        internalServerError((req, res) -> {
            res.status(NOT_IMPLEMENTED_501);
            logger.error(INTERNAL_SERVER_ERROR + ": " + req.pathInfo());
            return INTERNAL_SERVER_ERROR;
        });
    }

    private void enableCORS() {
        // Enable Cross Origin Resource Sharing.
        before((request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Headers", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, OPTIONS");
        });
    }

    private void setLog() {
        before((request, response) -> {
            logger.info("URL request: " + request.requestMethod() + " " + request.uri() + " - headers: " + request.headers());
        });
    }

}