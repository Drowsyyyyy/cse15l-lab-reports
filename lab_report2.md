import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

class Handler implements URLHandler {
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

1. ![Image](SS1.png)
   
        - handleRequest method and main method are called.
   
        - relevant arguments: URI url, String[] args | relevant fields: ArrayList<String> search, String result, int count, String[] parameters
   
        - URI url -> https://0-0-0-0-4000-vl2ne1fp7f2ddbc7iilvb972rk.us.edusercontent.com/add-message?s=Hello
   
        - String[] args -> [4000]
   
        - ArrayList<String> search -> ["1. Hello " + "\n"]
   
        - String result -> "1. Hello" + "\n"
   
        - String[] parameters -> ["s", "Hello"]
   
2. ![Image](ss2.png)
   
        - handleRequest method and main method are called.
   
        - relevant arguments: URI url, String[] args | relevant fields: ArrayList<String> search, String result, int count, String[] parameters
   
        - URI url -> https://0-0-0-0-4000-vl2ne1fp7f2ddbc7iilvb972rk.us.edusercontent.com/add-message?s=How are you
   
        - String[] args -> [4000]
   
        - ArrayList<String> search -> ["1. Hello " + "\n", "2. How+are+you" + "\n"]
   
        - String result -> "1. Hello" + "\n" + "2. How+are+you" +"\n"
   
        - String[] parameters -> ["s", "How+are+you"]
   

3. ![Image](private.PNG)


4. ![Image](public.PNG)


5. ![Image](login.PNG)


6. In week 2, I learned how to remotely connect to the server, build and run the server. Also, I learned the structure of URL and how URL works. Especially, path, query and fragment. In week 3, the main thing I learned was SSH keys. Especially, private and public keys.
Also, I learend new cmd commands, which are scp and mkdir. 
