package nikos.slidemecrawler;

import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetAllGames {

    public static void crawlAllGames() {
        int pageNumber = 0;
        String url = "http://slideme.org/applications?page=" + String.valueOf(pageNumber) + "&filters=tid%3A19&solrsort=created%20desc";
        System.out.println("url: " + url);
        Document doc = null;
        doc = Connect.connect(url);
        if (doc == null) {
            System.out.println("ERROR: null doc");
        }

        int lastPage = getLastPage(doc);
        String finalString = "";
        String gameUrl = "";
        String gameName = "";
        String [] parts;
        for (int i = 0; i <= lastPage; i++) {
            if(i<=7){continue;}
            System.out.println("i:" + i);
            Elements els = doc.getElementsByClass("node node-mobileapp");

            ArrayList<String> appNames = getAppsOfThePage(els);
            for (String s : appNames) {
                parts = s.split("-@-");
                gameUrl = parts[0];
                gameName = parts[1];
                finalString = gameUrl + "\", \""  + gameName.replaceAll("\"","'");
                DBTools.insertToTable(finalString, "gameurlandname");
            }
            
             url = "http://slideme.org/applications?page=" + String.valueOf(i+1) + "&filters=tid%3A19&solrsort=created%20desc";
             System.out.println("\n \nnewUrl: " + url);
             doc = Connect.connect(url);

        }
    }

    private static int getLastPage(Document doc) {
        Element lastPageElement = doc.getElementsByClass("pager-last last").first();
        String lastPageString = String.valueOf(lastPageElement);
        String[] tempArray = lastPageString.split("page=");
        return Integer.valueOf(tempArray[1].split("&amp")[0]);//to max page gia to vima 1
    }

    private static ArrayList<String> getAppsOfThePage(Elements els) {
        ArrayList<String> appNames = new ArrayList<String>();
        for (Element e : els) {
            String temp1 = e.getElementsByClass("title").html();

            String temp2 = temp1.split("href=")[1];
            String appUrl = "http://slideme.org"+temp2.substring(1, temp2.indexOf(">") - 1);
            String appName = temp2.substring(temp2.indexOf("</span>"), temp2.indexOf("</a>")).replace("</span>", "");
            //System.out.println("gameUrl: " + gameUrl + "  gameName: " + gameName );
            appNames.add(appUrl + "-@-" + appName.trim());

        }
        return appNames;
    }

    public static void main(String[] args) {
        GetAllGames.crawlAllGames();
    }

}
