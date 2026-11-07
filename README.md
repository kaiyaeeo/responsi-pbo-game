# Arena Nusantara — Game PBO Java

## Identitas

- **Nama:** Balqis Safitri
- **NIM:** H1D025070
- **Tema:** Game

## Deskripsi

Arena Nusantara adalah game console sederhana berbasis Java. Pemain dapat melihat simulasi pertarungan antara `Warrior` dan `Mage`.

## Struktur proyek

```text
pbo-game-balqis-safitri/
├── src/
│   ├── Character.java
│   ├── Warrior.java
│   ├── Mage.java
│   ├── SkillUser.java
│   ├── Defensible.java
│   └── Main.java
├── docs/
│   └── output.txt
├── .gitignore
└── README.md
```

## Konsep PBO yang diterapkan

1. **State dan behavior:** atribut `health`, `level`, dan `mana`; prosedur `showStatus()`; fungsi `isAlive()` dan `getPower()`.
2. **Immutability:** konstanta global `public static final int MAX_HEALTH` dan atribut kekal `private final String id`.
3. **Enkapsulasi dan overloading:** seluruh atribut private dengan getter/setter; penggunaan `this`; dua konstruktor pada `Character`, `Warrior`, dan `Mage`.
4. **Inheritance:** `Warrior` dan `Mage` mewarisi `Character`; `Main` dipisahkan dari class lainnya.
5. **Super chaining:** konstruktor subclass memanggil `super(...)`; method overriding memanggil `super.showStatus()`.
6. **Method overriding:** `Warrior` dan `Mage` menimpa `takeTurn()` dengan anotasi `@Override`.
7. **Abstract class:** `Character` berstatus abstract dan memiliki abstract method `takeTurn()`.
8. **Logika state dan percabangan:** implementasi `takeTurn()` memakai `if/else`, membaca health/mana, lalu mengubah health/mana objek.
9. **Polimorfisme interface:** `SkillUser skillUser = new Warrior(...)` kemudian memanggil `skillUser.useSkill(mage)`.
10. **Multiple interface:** `Warrior implements SkillUser, Defensible`.
