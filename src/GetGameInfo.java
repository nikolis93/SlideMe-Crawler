package nikos.slidemecrawler;

import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetGameInfo {

    public static App getGameInfo(String url) {
        System.out.println("url: " + url);
        Document doc = null;
        doc = Connect.connect(url);
        if (doc == null) {
            System.out.println("ERROR: null doc");
        }

        String appName = getAppName(doc);
        String appVersion = getAppVersion(doc);
        String appPrice = getAppPrice(doc);
        String appDeveloper = getAppDeveloper(doc);
        String developerUrl = getDeveloperUrl(doc);
        String lastSubmitionDate = getLastSubmissionDate(doc);
        String averageRating = getAverageRating(doc);
        String imageUrl = getImageUrl(doc);
        String apkUrl = getApkUrl(doc);
        String numberOfReviews = getNumberOfReviews(doc);
        String categories = getCategories(doc);
        String totalDownloads = getTotalDownloads(doc);
        String reviewsUrlTemp = doc.getElementsByClass("tabs primary").html();
        String reviewsUrl = getReviewsUrl(doc);
        String hasADvertisements = getHasAdvertisements(doc);
        String ratingsPerStar = getRatingsByStar(doc);
        String discussionsUrl = getDiscussionsUrl(doc);
        ArrayList<String> supportedLanguages = getSupportedLanguages(doc);
        String language = getLanguage(doc);
        String parentalRating = getParentalRating(doc);
        String tags = getTags(doc);

        System.out.println("appName: " + appName);
        System.out.println("appVersion: " + appVersion);
        System.out.println("price: " + appPrice);
        System.out.println("appDeveloper: " + appDeveloper);
        System.out.println("developerUrl: " + developerUrl);
        System.out.println("last submition: " + lastSubmitionDate);
        System.out.println("averageRating: " + averageRating);
        System.out.println("ratingsPerStar: " + ratingsPerStar);
        System.out.println("total downloads: " + totalDownloads);
        System.out.println("number of reviews: " + numberOfReviews);
        System.out.println("categories: " + categories);
        System.out.println("tags: " + tags);
        System.out.println("imageUrl: " + imageUrl);
        System.out.println("apkUrl: " + apkUrl);
        System.out.println("reviewsUrl: " + reviewsUrl);
        System.out.println("Parental Rating: " + parentalRating);
        System.out.println("Language: " + language);
        System.out.println("has advertisements: " + hasADvertisements);
        System.out.println("DiscussionsUrl: " + discussionsUrl);

        App app = new App(url, appName, appVersion, appPrice, appDeveloper, lastSubmitionDate, averageRating, ratingsPerStar,
                numberOfReviews, categories, parentalRating, language, hasADvertisements, imageUrl, apkUrl, reviewsUrl, discussionsUrl, tags, totalDownloads);

        return app;
    }

    private static String getHasAdvertisements(Document doc) {
        String hasAdvertisments = "Unknown";
        Elements els = doc.getElementsByClass("fieldgroup group-application");
        
        for (Element e : els) {
            if (e.text().contains("With advertisements")) {
                String temp = e.text();
                hasAdvertisments = temp.substring(temp.indexOf("With advertisements") + 22, temp.length());

            }
        }
        return hasAdvertisments;
    }

    private static String getReviewsUrl(Document doc) {
        String reviewsUrl = "Unknown";
        String reviewsUrlTemp = doc.getElementsByClass("tabs primary").html();
        reviewsUrl = "http://slideme.org" + reviewsUrlTemp.substring(reviewsUrlTemp.indexOf("<li><a href="), reviewsUrlTemp.indexOf(">Reviews")).replace("<li><a href=", "").replace("\"", "");
        return reviewsUrl;
    }

    private static String getTotalDownloads(Document doc) {
        String totalDownloads = "Unknown";
        totalDownloads = doc.getElementsByClass("downloads").text();
        return totalDownloads;
    }

    private static String getCategories(Document doc) {
        String categories = "Unknown";
        categories = doc.getElementsByClass("category").text();
        return categories;
    }

    private static String getNumberOfReviews(Document doc) {
        String numberOfReviews = "Unknown";
        numberOfReviews = doc.getElementsByClass("reviews").text();
        return numberOfReviews;
    }

    private static String getApkUrl(Document doc) {
        String apkUrl = "Unknown";
        String apkUrlTemp = doc.getElementsByClass("download-button").first().html();
        apkUrl = apkUrlTemp.substring(apkUrlTemp.indexOf("href=") + 5, apkUrlTemp.indexOf("title")).replace("\"", "");
        return apkUrl;
    }

    private static String getImageUrl(Document doc) {
        String imageUrl = "Unknown";
        imageUrl = doc.getElementsByClass("imagecache imagecache-icon").first().attr("src");
        return imageUrl;
    }

    private static String getAverageRating(Document doc) {
        String averageRating = "Unknown";
        String averageRatingTemp = doc.getElementsByClass("average-rating").first().html();
        averageRating = averageRatingTemp.substring(averageRatingTemp.indexOf("<span>") + 6, averageRatingTemp.indexOf("</span>"));
        return averageRating;
    }

    private static String getLastSubmissionDate(Document doc) {
        String lastSubmitionDate = "Unknown";
        String appDeveloperTemp = doc.getElementsByClass("submitted").get(0).html();
        lastSubmitionDate = appDeveloperTemp.substring(appDeveloperTemp.indexOf("</a>") + 6, appDeveloperTemp.length());
        return lastSubmitionDate;
    }

    private static String getDeveloperUrl(Document doc) {
        String developerUrl = "Unknown";
        String appDeveloperTemp = doc.getElementsByClass("submitted").get(0).html();
        developerUrl = "http://slideme.org" + appDeveloperTemp.substring(appDeveloperTemp.indexOf("href="), appDeveloperTemp.indexOf(" title")).replace("href=", "").replace("\"", "");
        return developerUrl;
    }

    private static String getAppDeveloper(Document doc) {
        String appDeveloper = "Unknown";
        String appDeveloperTemp = doc.getElementsByClass("submitted").get(0).html();
        appDeveloper = appDeveloperTemp.substring(appDeveloperTemp.indexOf(">") + 1, appDeveloperTemp.indexOf("</a>"));
        return appDeveloper;
    }

    private static String getAppPrice(Document doc) {
        String appPrice = "Unknown";
        appPrice = doc.getElementsByClass("price").first().html();
        return appPrice;

    }

    private static String getAppVersion(Document doc) {
        String appVersion = "Unknown";
        appVersion = doc.getElementsByClass("version").html();
        return appVersion;
    }

    private static String getRatingsByStar(Document doc) {
        String ratingsByStar = "Unknown";
        Elements els = doc.getElementsByClass("rating-bars-wrapper");
        Elements spans = els.first().getElementsByTag("span");
        Elements starNumber = els.first().getElementsByClass("star-count");
        String[] ratingsPerStar = new String[5];
        for (int i = 0; i < 5; i++) {
            ratingsPerStar[i] = starNumber.get(i).text();
        }

        ratingsByStar = ratingsPerStar[0] + "-@-" + ratingsPerStar[1] + "-@-" + ratingsPerStar[2] + "-@-" + ratingsPerStar[3] + "-@-" + ratingsPerStar[4];
        return ratingsByStar;
    }

    private static String getDiscussionsUrl(Document doc) {
        String discussionsUrl = "Unknown";
        Elements els = doc.getElementsByClass("tabs primary");
        Elements elmnts = null;
        for (Element e : els) {
            //System.out.println(e);
            elmnts = e.getElementsByTag("a");
        }
        if (elmnts != null) {
            for (Element el : elmnts) {
                if (el.toString().contains("Discussion")) {
                    discussionsUrl = "http://slideme.org" + el.attr("href");
                }
            }
        }
        return discussionsUrl;
    }

    private static ArrayList<String> getSupportedLanguages(Document doc) {
        ArrayList<String> supportedLanguages = new ArrayList<String>();
        Elements els = doc.getElementsByClass("fieldgroup group-application");
        for (Element e : els) {
            if (e.text().contains("Supported languages")) {
                String temp = e.text();
                temp = temp.substring(temp.indexOf("Supported languages") + 21, temp.length());
                String[] parts = temp.split(",");
                for (int i = 0; i < parts.length - 1; i++) {
                    supportedLanguages.add(parts[i]);
                }
            }
        }
        return supportedLanguages;
    }

    private static String getLanguage(Document doc) {
        String language = "Unknown";
        Elements els = doc.getElementsByClass("fieldgroup group-application");
        for (Element e : els) {
            if (e.text().contains("Default language:")) {
                //System.out.println(e.text());
                String temp = e.text();
                temp = temp.substring(temp.indexOf("Default language:"), temp.length());
                String[] parts = temp.split(" ");
                language = parts[2];

            }
        }
        return language;
    }

    private static String getParentalRating(Document doc) {
        String parentalRating = "Unknown";
        Elements els = doc.getElementsByClass("fieldgroup group-application");
        for (Element e : els) {
            if (e.text().contains("Parental rating")) {
                String temp = e.text();
                parentalRating = temp.substring(temp.indexOf("Parental rating:") + 17, temp.indexOf(")") + 1).trim();
            }

        }
        return parentalRating;
    }

    private static String getTags(Document doc) {
        ArrayList<String> tags = new ArrayList<String>();
        Elements elmts = null;
        Elements els = doc.getElementsByClass("links inline");
        Elements elmnts = null;
        for (Element e : els) {
            if (e.toString().contains("rel=\"tag\"")) {
                elmnts = e.getElementsByTag("li");
            }
        }
        for (Element el : elmnts) {
            tags.add(el.text());
        }

        String tagsFinal = "";
        for (String tag : tags) {
            tagsFinal += tag + "-@-";
        }

        if (!tagsFinal.isEmpty()) {
            tagsFinal = tagsFinal.substring(0, tagsFinal.lastIndexOf("-@-"));
        } else {
            tagsFinal = "Unknown";
        }
        return tagsFinal;
    }

    private static ArrayList<String> getRightTags(Document doc) {
        ArrayList<String> tags = new ArrayList<String>();
        Elements elmts = null;
        Elements els = doc.getElementsByClass("block-wrapper");
        for (Element e : els) {
            if (e.html().contains("/applications/tag/")) {
                elmts = e.getElementsByTag("a");
            }
        }
        if (elmts != null) {
            System.out.println("1");
            for (Element el : elmts) {
                if (el.toString().contains("/applications/tag/")) {
                    tags.add(el.text());
                }
            }
        }
        return tags;
    }

    private static String getAppName(Document doc) {
        String appName = "Unknown";
        Element el = doc.getElementsByTag("h1").get(1);
        String temp = el.html();
        appName = temp.substring(temp.indexOf("</span>") + 7, temp.indexOf("<span class=\"version\">")).trim();
        return appName;
    }

    public static void main(String[] args) {
        ArrayList<String> gameUrls = new ArrayList<String>();
        gameUrls = DBTools.getStoredGamesFromDB();
        System.out.println("gameUrls.size(): " + gameUrls.size());
        int counter = 0;
        String finalString = "";
        for (String gameUrl : gameUrls) {          
            System.out.println("counter: " + counter);
            System.out.println(gameUrl);
            App app = getGameInfo(gameUrl);
            System.out.println(app.toString());

            finalString = app.getAppUrl() + "\", \"" + app.getAppName().replaceAll("\"", "'") + "\", \"" + app.getAppVersion()
                    + "\", \"" + app.getPrice() + "\", \"" + app.getDeveloper()
                    + "\", \"" + app.getLastSubmision() + "\", \"" + app.getAverageRating()
                    + "\", \"" + app.getRatingsPerStar() + "\", \"" + app.getNumberOfReviews() + "\", \"" + app.getCategories()
                    + "\", \"" + app.getTags() + "\", \"" + app.getLanguage() + "\", \"" + app.getHasAdvertisments()
                    + "\", \"" + app.getImageUrl() + "\", \"" + app.getApkUrl() + "\", \"" + app.getReviewsUrl()
                    + "\", \"" + app.getDiscussionsUrl() + "\", \"" + app.getParentalRating()
                    + "\", \"" + app.getTotalDownloads();
            DBTools.insertToTable(finalString, "appinfos");
            counter++;
            System.out.println("\n#########################NEXT GAME#########################");

        }
    }
}
