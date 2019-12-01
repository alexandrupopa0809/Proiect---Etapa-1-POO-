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

    Hero(final int rowPos, final int colPos) {
        this.xp = 0;
        this.level = 0;
        this.hp = 0;
        this.maxHp = 0;
        this.isAlive = true;
        this.overtimeDamage = 0;
        this.imobilized = 0;
        this.rowPos = rowPos;
        this.colPos = colPos;
        this.iterator = 0;
        this.damageOvertimeRounds = 0;
    }

    public void getXpPoints(final int opponentLevel) {
        this.xp += Math.max(0, 200 - (this.level - opponentLevel) * 40);
        int currentLevel = 0;

        while (this.xp >= 50) {
            if (currentLevel == 0) {
                if(this.xp >= 250) {
                    this.xp += 250;
                    currentLevel++;
                }
                else {
                    this.xp = 0;
                }
            }
            else {
                this.xp += 50;
                currentLevel++;
            }
        }
        if (currentLevel > this.level) {
            if (this instanceof Pyromancer) {
                this.hp = this.maxHp +
                        Constants.PYRO_MODIF_PER_LEVEL * currentLevel;
            }
            if (this instanceof Knight) {
                this.hp = this.maxHp +
                        Constants.knightModifPerLevel * currentLevel;
            }
            if (this instanceof Wizard) {
                this.hp = this.maxHp +
                        Constants.wizardModifPerLevel * currentLevel;
            }
            if(this instanceof Rogue) {
                this.hp = this.maxHp +
                        Constants.rogueModifPerLevel * currentLevel;
            }
        }
        this.level = currentLevel;
    }

    public void takeOvertimeDamage() {
        if(this.damageOvertimeRounds != 0) {
            this.hp -= overtimeDamage;
            damageOvertimeRounds--;
        }

    }

    public void move() {
        if (this.isAlive) {
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
            if(this.imobilized != 0) {
                iterator--;
            }
        }
    }

    public void fightWith(Wizard wizardHero) {

    }

    public void fightWith(Pyromancer pyroHero) {

    }

    public void fightWith(Rogue rogueHero) {

    }

    public void fightWith(Knight knightHero) {

    }

    public void fightBack(Hero hero) {

    }

    public void getActiveDamage(final int activeDamage) {
        this.hp -= activeDamage;
    }

    public void getOvertimeDamage(final int overtimeDamage) {
        if (this.isAlive) {
            this.hp -= overtimeDamage;
        }
    }

    public void fight(final Hero otherHero) {
    }
}
