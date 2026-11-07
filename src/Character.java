public abstract class Character {
    public static final int MAX_HEALTH = 100;

    private final String id;
    private String name;
    private int health;
    private int level;

    public Character(String id, String name) {
        this(id, name, MAX_HEALTH, 1);
    }

    public Character(String id, String name, int health, int level) {
        this.id = id;
        this.name = name;
        this.health = Math.max(0, Math.min(health, MAX_HEALTH));
        this.level = Math.max(1, level);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, MAX_HEALTH));
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = Math.max(1, level);
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void receiveDamage(int damage) {
        setHealth(health - Math.max(0, damage));
    }

    public int getPower() {
        return 10 + (level * 3);
    }

    public void showStatus() {
        System.out.printf("%-12s | HP: %3d/%d | Level: %d%n", name, health, MAX_HEALTH, level);
    }

    public abstract void takeTurn(Character opponent);
}
