package src.constants;

public class Campaigns {
    public String campaignID;
    public String campaignName;
    public String campaigner;
    public String name;
    public String application;
    public double targetAmount;
    public String poster;
    public String files;
    public boolean approved;

    public Campaigns(String id, String campaignName, String campaigner, String name, String application, double targetAmount) {
        this.campaignID = id;
        this.campaignName = campaignName;
        this.campaigner = campaigner;
        this.name = name;
        this.application = application;
        this.targetAmount = targetAmount;
        this.poster = null;
        this.files = null;
        this.approved = false;
    }
    
    // set methodes
    public void setCampaignID(String campaignID) {
        this.campaignID = campaignID;
    }
    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }
    public void setCampaigner(String campaigner) {
        this.campaigner = campaigner;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setApplication(String application) {
        this.application = application;
    }
    public void setTargetAmount(double targetAmount) {
        this.targetAmount =targetAmount;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
    public void setFiles(String files) {
        this.files = files;
    }
    public void approveCampaign() {
        this.approved = true;
    }
    public void disapproveCampaign() {
        this.approved = false;
    }

    // get methodes
    public String setCampaignID() {
        return campaignID;
    }
    public String getCampaignName() {
        return campaignName;
    }
    public String getCampaigner() {
        return campaigner;
    }
    public String getName() {
        return name;
    }
    public String getApplication() {
        return application;
    }
    public double getTargetAmount() {
        return targetAmount;
    }
    public String getPoster() {
        return poster;
    }
    public String getFiles() {
        return files;
    }
    public boolean isApproved() {
        return approved;
    }
}
