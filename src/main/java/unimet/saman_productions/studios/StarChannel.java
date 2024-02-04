package unimet.saman_productions.studios;

public class StarChannel extends Studio {
  private static int SCRIPTS = 2;
  private static int SCENES = 3;
  private static int ANIMATIONS = 4;
  private static int DUBS = 6;
  private static int STANDARD_PROFIT = 350000;
  private static int PLOT_TWIST_GAP = 6;
  private static int PLOT_TWIST_AMOUNT = 5;
  private static int PLOT_TWIST_PROFIT = 800000;

  public StarChannel(int deadline, String name) {
    super(deadline, name);
  }

  @Override
  public int getScripts() {
    return SCRIPTS;
  }

  @Override
  public int getScenes() {
    return SCENES;
  }

  @Override
  public int getAnimations() {
    return ANIMATIONS;
  }

  @Override
  public int getDubs() {
    return DUBS;
  }

  @Override
  public int getStandardProfit() {
    return STANDARD_PROFIT;
  }

  @Override
  public int getPlotTwistGap() {
    return PLOT_TWIST_GAP;
  }

  @Override
  public int getPlotTwistAmount() {
    return PLOT_TWIST_AMOUNT;
  }

  @Override
  public int getPlotTwistProfit() {
    return PLOT_TWIST_PROFIT;
  }
}
