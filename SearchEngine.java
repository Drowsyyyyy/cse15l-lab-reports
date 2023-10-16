import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
    // The one bit of state on the server: a number that will be manipulated by
    // various requests.
    ArrayList<String> search = new ArrayList<String>();
    int count = 1; 
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format("Search's total list: %s", search);
        }  else if (url.getPath().contains("/search")) {
                ArrayList<String> search2 = new ArrayList<String>();
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")){
                    for(int i = 0; i<search.size(); i++){
                        if(search.get(i).contains(parameters[1])){
                        search2.add(search.get(i));
                        }
                    }
                    return String.format("%s", search2);
                } 
                return "404 Not Found!"; 
        } else {
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    search.add(String.valueOf(count)+ "." + parameters[1]+ "\n");
                    return String.format(search);
                }
            }
            return "404 Not Found!";
        }
    }
}

class SearchEngine {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
