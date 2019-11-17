package Main;

public class Config {
    public static String GAME_NAME = "TOWER DEFENCE";
    public static int GRID_HEIGHT = 80;
    public static int GRID_WIDTH = 80;

    public static int ROW = 7;
    public static int COLUMN = 10;

    public static int FIELD_WIDTH = COLUMN * GRID_WIDTH;
    public static int FIELD_HEIGHT = ROW * GRID_HEIGHT;

    public static int SCREEN_WIDTH = FIELD_WIDTH + 150;
    public static int SCREEN_HEIGHT = FIELD_HEIGHT;

    public static int COUNTER_NORMAL_ENEMY = 30;
    public static int COUNTER_TANKER_ENEMY = 40;
    public static int COUNTER_SMALLER_ENEMY = 55;
    public static int COUNTER_BOSS_ENEMY = 155;

    // public static final int GAME_FPS = 30;
    //  public static final double COUNT = 1000000000.0/GAME_FPS;
    public static int NORMAL_TOWER_COST = 200;
    public static int SMALLER_TOWER_COST = 500;
    public static int SNIPER_TOWER_COST = 550;

    public static int COUNTER_ENEMY_MAX=500;

}
