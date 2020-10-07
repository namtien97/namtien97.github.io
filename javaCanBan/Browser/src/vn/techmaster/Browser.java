package vn.techmaster;

public class Browser {
    public String navigate(String url){
       String ipAddress =  findIP(url);
       String content= sendHttpRequest(ipAddress);
       return content;
    }

    private String sendHttpRequest(String ipAdd){
        System.out.println("<html></html>");
    }

    private String findIP(String domainName){
    System.out.println("Dia chi IP: 127.0.0.1");
    }
}
