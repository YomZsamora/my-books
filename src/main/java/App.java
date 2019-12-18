import models.Authors;
import models.Books;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {

    public static void main(String[] args){
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Authors> allAuthors = Authors.getAllAuthors();
            ArrayList<Books> allBooks = Books.getAllBooks();
            model.put("allAuthors", allAuthors);
            model.put("allBooks", allBooks);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        post("/postNewAuthor", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String authorName = request.queryParams("authorName");
            Authors newAuthor = new Authors(authorName);
            model.put("authorName", authorName);
            return new ModelAndView(model, "successAuthor.hbs");
        }, new HandlebarsTemplateEngine());

        get("showAuthorbooks/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Authors thisAuthor = Authors.findAuthor(Integer.parseInt(request.params(":id")));
            List<Books> authorBooks = thisAuthor.getAllThisAuthorBooks();
            model.put("thisAuthor", thisAuthor);
            model.put("authorBooks", authorBooks);
            return new ModelAndView(model, "author.hbs");
        }, new HandlebarsTemplateEngine());

        post("/postNewBook", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String bookName = request.queryParams("bookName");
            String description = request.queryParams("description");
            int noOfPages = Integer.parseInt(request.queryParams("noOfPages"));
            String availability = request.queryParams("availability");
            String authorId = request.queryParams("bookAuthor");
            boolean isAvailable;
            if(availability == "yes"){ isAvailable = true; } else { isAvailable = false; }
            Authors newAuthorBook = Authors.findAuthor(Integer.parseInt(authorId));
            Books newBook = new Books(bookName, description, noOfPages, isAvailable);
            newAuthorBook.addBookToAuthor(newBook);
            return new ModelAndView(model, "successAuthor.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
