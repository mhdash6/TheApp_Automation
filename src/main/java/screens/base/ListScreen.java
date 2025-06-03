package screens.base;




public  abstract class ListScreen {
     protected String cloudName;


    public abstract void tapLearnMore();

    public abstract String getLearnMoreText();

    public abstract void acceptAlert() ;

    public abstract void scrollAndTapCloudName(String cloudName, String direction);

    public abstract void scrollAndTapCloudName(String cloudName);

}
