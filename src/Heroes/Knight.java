package Heroes;

import Constants.Constants;

public class Knight extends Hero {
    public Knight(int row, int col) {
        super(row, col);
        this.hp = 900;
        this.maxHp = 900;
    }

    @Override
    public void fightBack(Hero hero) {
        hero.fightWith(this);
    }

    @Override
    public void fightWith(Pyromancer pyroHero) {
        final float hpLimitCoef = 0.2f;
        float hpLimit = hpLimitCoef * pyroHero.maxHp;
        float executeActiveDamage = 0;
        float slamActiveDamage = 100;
        float totalActiveDamage;

        if (this.level < 40) {
            hpLimit += ((float) this.level/100) * pyroHero.maxHp;
        }
        else {
            hpLimit += 0.4f * pyroHero.maxHp;
        }

        if ((float) pyroHero.hp < hpLimit && pyroHero.hp > 0) {
            executeActiveDamage = pyroHero.hp;
            pyroHero.getActiveDamage((int)Math.round(executeActiveDamage));
        }
        else {
            executeActiveDamage = 200;
            executeActiveDamage += 30 * this.level;
            slamActiveDamage += 40 * this.level;

            if (Map.getInstance().map[rowPos][colPos] == 'L') {
                executeActiveDamage *= Constants.knightMapModif;
                slamActiveDamage *= Constants.knightMapModif;
            }

            executeActiveDamage *= Constants.pyroModifExecute;
            slamActiveDamage *= Constants.pyroModifSlam;

            totalActiveDamage = slamActiveDamage + executeActiveDamage;

            pyroHero.getActiveDamage((int) Math.round(totalActiveDamage));
            pyroHero.imobilized = 1;
        }
    }

    @Override
    public void fightWith(Wizard wizardHero) {
        final float hpLimitCoef = 0.2f;
        float hpLimit = hpLimitCoef * wizardHero.maxHp;
        float executeActiveDamage = 0;
        float slamActiveDamage = 100;
        float totalActiveDamage;

        if (this.level < 40) {
            hpLimit += ((float) this.level/100) * wizardHero.maxHp;
        }
        else {
            hpLimit += 0.4f * wizardHero.maxHp;
        }

        if ((float) wizardHero.hp < hpLimit && wizardHero.hp > 0) {
            executeActiveDamage = wizardHero.hp;
            wizardHero.getActiveDamage((int)Math.round(executeActiveDamage));
        }
        else {
            executeActiveDamage = 200;
            executeActiveDamage += 30 * this.level;
            slamActiveDamage += 40 * this.level;

            if (Map.getInstance().map[rowPos][colPos] == 'L') {
                executeActiveDamage *= Constants.knightMapModif;
                slamActiveDamage *= Constants.knightMapModif;
            }

            executeActiveDamage *= Constants.wizardModifExecute;
            slamActiveDamage *= Constants.wizardModifSlam;

            totalActiveDamage = slamActiveDamage + executeActiveDamage;

            wizardHero.getActiveDamage((int) Math.round(totalActiveDamage));
            wizardHero.imobilized = 1;
        }

    }

    @Override
    public void fightWith(Knight knightHero) {
        final float hpLimitCoef = 0.2f;
        float hpLimit = hpLimitCoef * knightHero.maxHp;
        float executeActiveDamage = 0;
        float slamActiveDamage = 100;
        float totalActiveDamage;

        if (this.level < 40) {
            hpLimit += ((float) this.level/100) * knightHero.maxHp;
        }
        else {
            hpLimit += 0.4f * knightHero.maxHp;
        }

        if ((float) knightHero.hp < hpLimit && knightHero.hp > 0) {
            executeActiveDamage = knightHero.hp;
            knightHero.getActiveDamage((int)Math.round(executeActiveDamage));
        }
        else {
            executeActiveDamage = 200;
            executeActiveDamage += 30 * this.level;
            slamActiveDamage += 40 * this.level;

            if (Map.getInstance().map[rowPos][colPos] == 'L') {
                executeActiveDamage *= Constants.knightMapModif;
                slamActiveDamage *= Constants.knightMapModif;
            }

            executeActiveDamage *= Constants.knightModifExecute;
            slamActiveDamage *= Constants.knightModifSlam;

            totalActiveDamage = slamActiveDamage + executeActiveDamage;

            knightHero.getActiveDamage((int) Math.round(totalActiveDamage));
            knightHero.imobilized = 1;
        }

    }

    @Override
    public void fightWith(Rogue rogueHero) {
        final float hpLimitCoef = 0.2f;
        float hpLimit = hpLimitCoef * rogueHero.maxHp;
        float executeActiveDamage = 0;
        float slamActiveDamage = 100;
        float totalActiveDamage;

        if (this.level < 40) {
            hpLimit += ((float) this.level/100) * rogueHero.maxHp;
        }
        else {
            hpLimit += 0.4f * rogueHero.maxHp;
        }

        if ((float) rogueHero.hp < hpLimit && rogueHero.hp > 0) {
            executeActiveDamage = rogueHero.hp;
            rogueHero.getActiveDamage((int)Math.round(executeActiveDamage));
        }
        else {
            executeActiveDamage = 200;
            executeActiveDamage += 30 * this.level;
            slamActiveDamage += 40 * this.level;

            if (Map.getInstance().map[rowPos][colPos] == 'L') {
                executeActiveDamage *= Constants.knightMapModif;
                slamActiveDamage *= Constants.knightMapModif;
            }

            executeActiveDamage *= Constants.rogueModifExecute;
            slamActiveDamage *= Constants.rogueMofifSlam;

            totalActiveDamage = slamActiveDamage + executeActiveDamage;

            rogueHero.getActiveDamage((int) Math.round(totalActiveDamage));
            rogueHero.imobilized = 1;
        }
    }

    @Override
    public String toString() {
        if (isAlive) {
            return "K" + " " + this.level + " " + this.xp + " " +  this.hp + " " +  this.rowPos + " " + this.colPos;
        } else {
            return "K dead";
        }
    }
}
