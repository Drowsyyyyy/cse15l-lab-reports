import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> search = new ArrayList<String>();
    String result = "";
    int count = 1;
    public String handleRequest(URI url) {
        if (url.getPath().contains("/add-message")) {
             String[] parameters = url.getQuery().split("=");
            if (parameters[0].equals("s")) {
                search.add(String.valueOf(count)+ "." + parameters[1]+ "\n");
                count += 1; 
               
                    result += search.get(count-2);
                
                 return String.format("%s", result);
                }
                return "404 Not Found!";
            }
        else {
            return "404 Not Found!";
        }
}
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}

