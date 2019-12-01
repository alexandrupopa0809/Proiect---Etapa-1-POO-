package Heroes;

import Constants.Constants;

public class Pyromancer extends Hero {
    public Pyromancer(final int rowPos, final int colPos) {
        super(rowPos, colPos);
        this.hp = 500;
        this.maxHp = 500;
    }

    @Override
    public  void fightBack(Hero hero){
        hero.fightWith(this);
    }

    @Override
    public void fightWith(Pyromancer pyroHero) {
        float fireblastActiveDamage = 350 + 50 * this.level;
        float igniteActiveDamage = 150 + 20 * this.level;
        float igniteOvertimeDamage = 50 + 30 * this.level;

        if (Map.getInstance().map[rowPos][colPos] == 'V') {
            fireblastActiveDamage *=  Constants.PYROMAPMODIF;
            igniteOvertimeDamage *= Constants.PYROMAPMODIF;
        }

        final float pyromancerModifier = 0.9f;
        fireblastActiveDamage *= pyromancerModifier;
        igniteActiveDamage *= pyromancerModifier;
        igniteOvertimeDamage *= pyromancerModifier;

        pyroHero.hp -= fireblastActiveDamage;
        pyroHero.hp -= igniteActiveDamage;
        pyroHero.overtimeDamage = igniteOvertimeDamage;
        pyroHero.damageOvertimeRounds = 2;
    }

    @Override
    public void fightWith(Rogue rogueHero) {
        float fireblastActiveDamage = 350 + 50 * this.level;
        float igniteActiveDamage = 150 + 20 * this.level;
        float igniteOvertimeDamage = 50 + 30 * this.level;

        if (Map.getInstance().map[rowPos][colPos] == 'V') {
            fireblastActiveDamage *=  Constants.PYROMAPMODIF;
            igniteOvertimeDamage *= Constants.PYROMAPMODIF;
        }

        final float rogueModifier = 0.8f;
        fireblastActiveDamage *= rogueModifier;
        igniteActiveDamage *= rogueModifier;
        igniteOvertimeDamage *= rogueModifier;

        rogueHero.hp -= fireblastActiveDamage;
        rogueHero.hp -= igniteActiveDamage;
        rogueHero.overtimeDamage = igniteOvertimeDamage;
        rogueHero.damageOvertimeRounds = 2;
    }

    @Override
    public void fightWith(Knight knightHero) {
        float fireblastActiveDamage = 350 + 50 * this.level;
        float igniteActiveDamage = 150 + 20 * this.level;
        float igniteOvertimeDamage = 50 + 30 * this.level;

        if (Map.getInstance().map[rowPos][colPos] == 'V') {
            fireblastActiveDamage *=  Constants.PYROMAPMODIF;
            igniteOvertimeDamage *= Constants.PYROMAPMODIF;
        }

        final float knightModifier = 1.2f;
        fireblastActiveDamage *= knightModifier;
        igniteActiveDamage *= knightModifier;
        igniteOvertimeDamage *= knightModifier;

        knightHero.hp -= fireblastActiveDamage;
        knightHero.hp -= igniteActiveDamage;
        knightHero.overtimeDamage = igniteOvertimeDamage;
        knightHero.damageOvertimeRounds = 2;
    }

    @Override
    public void fightWith(Wizard wizardHero) {
        float fireblastActiveDamage = 350 + 50 * this.level;
        float igniteActiveDamage = 150 + 20 * this.level;
        float igniteOvertimeDamage = 50 + 30 * this.level;

        if (Map.getInstance().map[rowPos][colPos] == 'V') {
            fireblastActiveDamage *=  Constants.PYROMAPMODIF;
            igniteOvertimeDamage *= Constants.PYROMAPMODIF;
        }

        final float wizardModifier = 1.05f;
        fireblastActiveDamage *= wizardModifier;
        igniteActiveDamage *= wizardModifier;
        igniteOvertimeDamage *= wizardModifier;

        wizardHero.hp -= fireblastActiveDamage;
        wizardHero.hp -= igniteActiveDamage;
        wizardHero.overtimeDamage = igniteOvertimeDamage;
        wizardHero.damageOvertimeRounds = 2;
    }

    @Override
    public String toString() {
        if (isAlive) {
            return "P" + " " + this.level + " " + this.xp + " " +  this.hp + " " +  this.rowPos + " " + this.colPos;
        } else {
            return "P dead";
        }
    }
}
