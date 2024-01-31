package unimet.saman_productions.studios;

public class CartoonNetwork extends Studio {
  private static int SCRIPTS = 1;
  private static int SCENES = 2;
  private static int ANIMATIONS = 6;
  private static int DUBS = 5;
  private static int PROFIT = 300000;
  private static int PLOT_TWIST_GAP = 3;
  private static int PLOT_TWIST_AMOUNT = 1;
  private static int PLOT_TWIST_PROFIT = 650000;

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
  public int getProfit() {
    return PROFIT;
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