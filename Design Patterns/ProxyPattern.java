import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class Scratch {
    public static void main(String[] args) {
        Internet internet=new ProxyInternetProvider(new InternetProvider());

        try {
            internet.connect("google.com");
            System.out.println(internet.isConnected());
            internet.connect("stackoverflow.com");
            System.out.println(internet.isConnected());
            internet.connect("abc.com");
            System.out.println(internet.isConnected());
        }catch (IOException ioException){
            System.out.println(ioException.getMessage());
        }
    }


}
interface Internet {
    void connect(String website);
    boolean isConnected() throws IOException;
    String website();
}
class InternetProvider implements Internet{
    boolean isConnected;
    String website;
    @Override
    public void connect(String website) {
        if (website!=null){
            this.isConnected=true;
            this.website=website;
        }
    }

    @Override
    public boolean isConnected() {
        return this.isConnected;
    }

    @Override
    public String website() {
        return this.website;
    }
}
class ProxyInternetProvider implements Internet{
    private Internet internetProvider;
    private Set<String> inValidWebsites;
    public ProxyInternetProvider(InternetProvider internetProvider) {
        this.internetProvider = internetProvider;
        this.inValidWebsites=new HashSet<>();
        this.inValidWebsites.add("abc.com");
        this.inValidWebsites.add("cbc.com");
        this.inValidWebsites.add("remote.com");
        this.inValidWebsites.add("proxy.com");
    }

    @Override
    public void connect(String website) {
        this.internetProvider.connect(website);
    }

    @Override
    public boolean isConnected() throws IOException {
        if (inValidWebsites.contains(this.internetProvider.website())){
            throw new IOException("Website access is not allowed");
        }
        return this.internetProvider.isConnected();
    }

    @Override
    public String website() {
        return this.internetProvider.website();
    }
}