package nikos.slidemecrawler;

public class App {

    private String appUrl;
    private String appName;
    private String appVersion;
    private String price;
    private String developer; // (mazi me to url)
    private String lastSubmision;
    private String averageRating;
    private String ratingsPerStar;
    private String numberOfReviews;
    private String categories;
    private String parentalRating;
    private String language;
    private String hasAdvertisments;
    private String imageUrl;
    private String apkUrl;
    private String reviewsUrl;
    private String DiscussionsUrl;
    private String tags;
    private String totalDownloads;
    
    public App(String appUrl, String appName, String appVersion, String price, String developer, String lastSubmision,
            String averageRating, String ratingsPerStar, String numberOfReviews, String categories,
            String parentalRating, String language, String hasAdvertisments, String imageUrl, String apkUrl,
            String reviewsUrl, String DiscussionsUrl, String tags, String totalDownloads) {
        this.appUrl = appUrl;
        this.appName = appName;
        this.appVersion = appVersion;
        this.price = price;
        this.developer = developer;
        this.lastSubmision = lastSubmision;
        this.averageRating = averageRating;
        this.ratingsPerStar = ratingsPerStar;
        this.numberOfReviews = numberOfReviews;
        this.categories = categories;
        this.parentalRating = parentalRating;
        this.language = language;
        this.hasAdvertisments = hasAdvertisments;
        this.imageUrl = imageUrl;
        this.apkUrl = apkUrl;
        this.reviewsUrl = reviewsUrl;
        this.DiscussionsUrl = DiscussionsUrl;
        this.tags = tags;
        this.totalDownloads = totalDownloads;

    }

    public String getTotalDownloads() {
        return totalDownloads;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public String getPrice() {
        return price;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getLastSubmision() {
        return lastSubmision;
    }

    public String getAverageRating() {
        return averageRating;
    }

    public String getRatingsPerStar() {
        return ratingsPerStar;
    }

    public String getNumberOfReviews() {
        return numberOfReviews;
    }

    public String getCategories() {
        return categories;
    }

    public String getParentalRating() {
        return parentalRating;
    }

    public String getLanguage() {
        return language;
    }

    public String getHasAdvertisments() {
        return hasAdvertisments;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getApkUrl() {
        return apkUrl;
    }

    public String getReviewsUrl() {
        return reviewsUrl;
    }

    public String getDiscussionsUrl() {
        return DiscussionsUrl;
    }

    public String getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "App{" + "\n  appUrl=" + appUrl + "\n  appName=" + appName + "\n  appVersion=" + appVersion + "\n  price=" + price + "\n  developer=" + developer + "\n  lastSubmision=" + lastSubmision + "\n  averageRating=" + averageRating + "\n  ratingsPerStar=" + ratingsPerStar +  "\n  totalDownloads=" + totalDownloads +"\n  numberOfReviews=" + numberOfReviews + "\n  categories=" + categories + "\n  tags=" + tags + "\n  parentalRating=" + parentalRating + "\n  language=" + language + "\n  hasAdvertisments=" + hasAdvertisments + "\n  imageUrl=" + imageUrl + "\n  apkUrl=" + apkUrl + "\n  reviewsUrl=" + reviewsUrl + "\n  DiscussionsUrl=" + DiscussionsUrl + "\n}";
    }

}
