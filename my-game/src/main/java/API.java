import static spark.Spark.*;

public class API {
    public static void main(String[] args) {
        get("/hello/:username", (req, res) -> {
        	return "Hello " + req.params(":username");
        });
    }
}