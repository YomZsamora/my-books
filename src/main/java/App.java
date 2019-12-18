import models.Authors;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args){
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Authors> allAuthors = Authors.getAllAuthors();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
