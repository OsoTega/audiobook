package audiobook;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.staticFiles;
import static spark.Spark.port;

import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;

import paths.Path;
import spark.ModelAndView;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

public class MainServer {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		staticFiles.location("/public");
		get("/", (req, res) -> {
			HashMap<String, Object> model = new HashMap<>();
			return Path.Templates.INDEX;
		});
		
		get("/result", (req, res) -> {
			HashMap<String, Object> model = new HashMap<>();
			return Path.Templates.SEARCHRESULT;
		});
		
		post("/", (req, res) -> {
			String name = req.queryParams("name");
			System.out.println("The Search ITEM IS "+name);
			return "That was funny";
		});
	}

}
