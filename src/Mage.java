public class Mage extends Character implements SkillUser {
    private int mana;

    public Mage(String id, String name) {
        super(id, name);
        this.mana = 40;
    }

    public Mage(String id, String name, int health, int level, int mana) {
        super(id, name, health, level);
        this.mana = Math.max(0, mana);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.max(0, mana);
    }

    @Override
    public void takeTurn(Character opponent) {
        super.showStatus();
        if (getHealth() > 0 && opponent.isAlive()) {
            if (mana >= 10) {
                useSkill(opponent);
            } else {
                int damage = getPower();
                opponent.receiveDamage(damage);
                System.out.println(getName() + " menyerang dengan tongkat sebesar " + damage + " damage.");
            }
        } else {
            System.out.println(getName() + " tidak dapat mengambil giliran.");
        }
    }

    @Override
    public void useSkill(Character target) {
        if (mana >= 10 && isAlive() && target.isAlive()) {
            int damage = getPower() + 12;
            target.receiveDamage(damage);
            setMana(mana - 10);
            System.out.println(getName() + " merapal Fireball kepada " + target.getName() + " (" + damage + " damage).");
        } else {
            System.out.println("Mana tidak cukup atau target tidak aktif.");
        }
    }
}
