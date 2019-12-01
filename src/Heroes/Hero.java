package Heroes;

import Constants.Constants;

public class Hero {
    public int xp;
    public int level;
    public int hp;
    public int maxHp;
    public boolean isAlive;
    public int rowPos;
    public int colPos;
    public float overtimeDamage;
    public int imobilized;
    public String moves;
    public int iterator;
    public int damageOvertimeRounds;

    public Hero(final int rowPos, final int colPos) {
        this.xp = 0;
        this.level = 0;
        this.hp = 0;
        this.maxHp = 0;
        this.isAlive = true;
        this.rowPos = rowPos;
        this.colPos = colPos;
        this.moves = "";
        this.iterator = 0;
        this.overtimeDamage = 0;
        this.damageOvertimeRounds = 0;
        this.imobilized = 0;
    }

    //experienta si level up
    public final void getXpPoints(final int opponentLevel) {
        //se calculeaza cine castiga xp-ul
        this.xp += Math.max(0, Constants.MAX_XP_POINTS - (this.level - opponentLevel)
                * Constants.MAX_XP_COEF);

        int currentXp = this.xp;

        int currentLevel = 0;

        while (currentXp >= Constants.XP_LEVEL_UP_COEF) {
            if (currentLevel == 0) {
                if (currentXp >= Constants.XP_LEVEL_UP) {
                    currentXp -= Constants.XP_LEVEL_UP;
                    currentLevel++;
                } else {
                    currentXp = 0;
                }
            } else {
                currentXp -= Constants.XP_LEVEL_UP_COEF;
                currentLevel++;
            }
        }
        /* se ia pentru fiecare erou in parte hp-ul per level */
        if (currentLevel > this.level) {
            if (this instanceof Pyromancer) {
                this.hp = this.maxHp
                        + Constants.PYRO_MODIF_PER_LEVEL * currentLevel;
            }
            if (this instanceof Knight) {
                this.hp = this.maxHp
                        + Constants.KNIGHT_MODIF_PER_LEVEL * currentLevel;
            }
            if (this instanceof Wizard) {
                this.hp = this.maxHp
                        + Constants.WIZARD_MODIF_PER_LEVEL * currentLevel;
            }
            if (this instanceof Rogue) {
                this.hp = this.maxHp
                        + Constants.ROGUE_MODIF_PER_LEVEL * currentLevel;
            }
        }
        this.level = currentLevel;
    }

    //daca trebuie sa ia hp pe parcurs
    public final void takeOvertimeDamage() {
        if (this.damageOvertimeRounds != 0) {
            //se scade hp-ul
            this.hp -= overtimeDamage;
            //scade numarul de runde pentru care trebuie sa i se scada hp
            damageOvertimeRounds--;
        }
        //daca nu mai e in viata
        if (this.hp <= 0) {
            this.isAlive = false;
        }
    }

    public final void move() {
        //daca este in viata si nu este imobilizat
        if (this.isAlive) {
            //face mutarea respectiva pentru inputul primit
            if (this.moves.charAt(iterator) == 'U') {
                if (this.imobilized == 0) {
                    rowPos--;
                }
            }
            if (this.moves.charAt(iterator) == 'D') {
                if (this.imobilized == 0) {
                    rowPos++;
                }
            }
            if (this.moves.charAt(iterator) == 'L') {
                if (this.imobilized == 0) {
                    colPos--;
                }
            }
            if (this.moves.charAt(iterator) == 'R') {
                if (this.imobilized == 0) {
                    colPos++;
                }
            }
            iterator++;
            if (this.imobilized != 0) {
                iterator--;
            }
            //ia damage dupa ce se misca
            takeOvertimeDamage();
        }
    }

    //cate o metoda de tip "interactWith" pentru fiecare erou in parte
    public void fightWith(final Wizard wizardHero) {

    }

    public void fightWith(final Pyromancer pyroHero) {

    }

    public void fightWith(final Rogue rogueHero) {

    }

    public void fightWith(final Knight knightHero) {

    }

    public void fightBack(final Hero hero) {

    }

    //se scade damage-ul instant si se verifica daca este in viata
    public void getActiveDamage(final int activeDamage) {
        this.hp -= activeDamage;
        if (this.hp <= 0) {
            this.isAlive = false;
        }
    }

}
