import src.*;

public class Application implements IApplication {
    public static void main(String[] args) {
        new FundMe();
    }

    @Override
    public void register() {}

    @Override
    public void login() {}

    @Override
    public void exaractInfo() {}

    @Override
    public void runFundraisingCampaign() {}

    @Override
    public void donate() {}
}