public class Main {
    public static void main(String[] args) {
        printHeader();

        Warrior warrior = new Warrior("W-01", "Arjuna", 90, 2, 7);
        Mage mage = new Mage("M-01", "Astra", 85, 3, 30);

        System.out.println("[1] State dan Behavior");
        warrior.showStatus();
        System.out.println("Power " + warrior.getName() + ": " + warrior.getPower());
        warrior.setName("Arjuna Sang Penjaga");
        System.out.println("Nama setelah setter: " + warrior.getName());

        System.out.println("\n[2] Polimorfisme melalui interface");
        SkillUser skillUser = new Warrior("W-02", "Bima");
        skillUser.useSkill(mage);
        Defensible defensible = warrior;
        defensible.defend();

        System.out.println("\n[3] Simulasi pertarungan");
        System.out.println("ID karakter immutable: " + warrior.getId());
        for (int ronde = 1; ronde <= 3 && warrior.isAlive() && mage.isAlive(); ronde++) {
            System.out.println("\n-- Ronde " + ronde + " --");
            warrior.takeTurn(mage);
            if (mage.isAlive()) {
                mage.takeTurn(warrior);
            }
            warrior.showStatus();
            mage.showStatus();
        }

        System.out.println("\n[4] Hasil akhir");
        if (warrior.isAlive() && mage.isAlive()) {
            System.out.println("Pertarungan berakhir seri setelah batas ronde.");
        } else if (warrior.isAlive()) {
            System.out.println("Pemenang: " + warrior.getName());
        } else if (mage.isAlive()) {
            System.out.println("Pemenang: " + mage.getName());
        } else {
            System.out.println("Kedua karakter tumbang.");
        }

        System.out.println("\nSemua 10 persyaratan PBO telah ditunjukkan melalui kode dan alur pengujian Main.");
    }

    private static void printHeader() {
        System.out.println("                                             ");
        System.out.println("        ARENA NUSANTARA - GAME PBO");
        System.out.println("        Nama: Balqis Safitri | NIM: H1D025070");
        System.out.println("                                             ");
    }
}
