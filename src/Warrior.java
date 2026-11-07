public class Warrior extends Character implements SkillUser, Defensible {
    private int armor;

    public Warrior(String id, String name) {
        super(id, name);
        this.armor = 5;
    }

    public Warrior(String id, String name, int health, int level, int armor) {
        super(id, name, health, level);
        this.armor = Math.max(0, armor);
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = Math.max(0, armor);
    }

    @Override
    public void takeTurn(Character opponent) {
        super.showStatus();
        if (getHealth() > 0 && opponent.isAlive()) {
            int damage = getPower() + armor;
            opponent.receiveDamage(damage);
            System.out.println(getName() + " menebas " + opponent.getName() + " sebesar " + damage + " damage.");
        } else {
            System.out.println(getName() + " tidak dapat menyerang karena status tidak aktif.");
        }
    }

    @Override
    public void useSkill(Character target) {
        if (isAlive() && target.isAlive()) {
            int damage = getPower() + 8;
            target.receiveDamage(damage);
            System.out.println(getName() + " memakai Heavy Slash kepada " + target.getName() + " (" + damage + " damage).");
        } else {
            System.out.println("Skill Warrior tidak dapat digunakan.");
        }
    }

    @Override
    public void defend() {
        setArmor(getArmor() + 3);
        System.out.println(getName() + " bertahan. Armor sekarang: " + getArmor());
    }
}
