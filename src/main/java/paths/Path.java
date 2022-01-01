package paths;

public class Path {
	
	public static class Templates{
		
		public static final String INDEX = "<!DOCTYPE HTML>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<title>AnyBody</title>\r\n" + 
				"		<meta charset=\"utf-8\" />\r\n" + 
				"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"		<link href=\"https://fonts.googleapis.com/css2?family=Piedra&display=swap\" rel=\"stylesheet\">\r\n" + 
				"		<link type=\"text/css\" rel=\"stylesheet\" href=\"http://localhost:4567/assets/css/maiFile.css\" />\r\n" + 
				"		<script defer src=\"https://use.fontawesome.com/releases/v5.0.6/js/all.js\"></script>\r\n" + 
				"		<script src=\"https://code.jquery.com/jquery-3.5.1.min.js\" integrity=\"sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=\" crossorigin=\"anonymous\"></script>\r\n" + 
				"		<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js\" integrity=\"sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo\" crossorigin=\"anonymous\"></script>\r\n" + 
				"		<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\" integrity=\"sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI\" crossorigin=\"anonymous\"></script>\r\n" + 
				"		<script type=\"text/javascript\">\r\n" + 
				"		\r\n" + 
				"			function submit(el)\r\n" + 
				"			{\r\n" + 
				"				var name = document.getElementById(el).value;\r\n" + 
				"				$.post(\"/\", {name: name}, function(result){\r\n" + 
				"					alert($(result.text));\r\n" + 
				"				});\r\n" + 
				"			}\r\n" + 
				"			function request()\r\n" + 
				"			{\r\n" + 
				"				if(document.getElementById('searchtext').value == \"\")\r\n" + 
				"					{\r\n" + 
				"						alert(\"please enter a name\");\r\n" + 
				"						return false;\r\n" + 
				"					}\r\n" + 
				"				else{\r\n" + 
				"					submit('searchtext');\r\n" + 
				"				}\r\n" + 
				"			}\r\n" + 
				"		</script>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"	<div class=\"wrapper\">\r\n" + 
				"		<h2 class=\"title\">Anybody</h2>\r\n" + 
				"		<div class=\"search-box\">\r\n" + 
				"		<input class=\"search\" id=\"searchtext\" type=\"text\" name=\"\" placeholder=\"Search for Person\">\r\n" + 
				"		<a class=\"search-btn\" id=\"search-btn\" onclick=\"return request()\">\r\n" + 
				"			<i class=\"fas fa-search\"></i>\r\n" + 
				"		</a>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	</body>\r\n" + 
				"</html>";
		public static final String SEARCHRESULT = "<!DOCTYPE HTML>\r\n" + 
				"<html>\r\n" + 
				"	<head>\r\n" + 
				"		<title>AnyBody</title>\r\n" + 
				"		<meta charset=\"utf-8\" />\r\n" + 
				"		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"		<link href=\"https://fonts.googleapis.com/css2?family=Piedra&display=swap\" rel=\"stylesheet\">\r\n" + 
				"		<link rel=\"stylesheet\" href=\"assets/css/maiFile.css\" />\r\n" + 
				"		<script defer src=\"https://use.fontawesome.com/releases/v5.0.6/js/all.js\"></script>\r\n" + 
				"	</head>\r\n" + 
				"	<body>\r\n" + 
				"	<div class=\"wrapper\">\r\n" + 
				"		<h2 class=\"title1\">Anybody</h2>\r\n" + 
				"		<div class=\"div\"></div>\r\n" + 
				"		<div class=\"results\">\r\n" + 
				"			<div class=\"card-container\">\r\n" + 
				"				<div class=\"upper\">\r\n" + 
				"				<div class=\"pro\">\r\n" + 
				"						<img src=\"images/pic07.jpg\">\r\n" + 
				"					</div>\r\n" + 
				"					<div class=\"image-pro\">\r\n" + 
				"						<img src=\"images/pic09.jpg\">\r\n" + 
				"					</div>\r\n" + 
				"					<h1>Tega Osowa</h1>\r\n" + 
				"				</div>\r\n" + 
				"				<div class=\"next\">\r\n" + 
				"				<div>\r\n" + 
				"					<p>Nunc lacinia ante nunc ac lobortis. Interdum adipiscing gravida odio porttitor sem non mi integer non faucibus ornare mi ut ante amet placerat aliquet..</p>\r\n" + 
				"				</div>\r\n" + 
				"				<div>\r\n" + 
				"					<a class=\"view-btn\" href=\"#\">View</a>				\r\n" + 
				"				</div>\r\n" + 
				"				</div>\r\n" + 
				"			</div>\r\n" + 
				"			<div class=\"card-container-loading\">\r\n" + 
				"				<div class=\"loading-result\"></div>\r\n" + 
				"			</div>\r\n" + 
				"		</div>\r\n" + 
				"		<div class=\"search-box1\">\r\n" + 
				"		<input class=\"search\" type=\"text\" name=\"\" placeholder=\"Search for Person\">\r\n" + 
				"		<a class=\"search-btn\" href=\"#\">\r\n" + 
				"		<i class=\"fas fa-search\"></i>\r\n" + 
				"		</a>\r\n" + 
				"		</div>\r\n" + 
				"	</div>\r\n" + 
				"	</body>\r\n" + 
				"</html>";
		public static final String PROFILE = "";
		public static final String IMAGES = "";
		public static final String VIDEOS = "";
		public static final String SOCIALMEDIAPOST = "";
		public static final String SEARCHING = "";
	}
	
}
