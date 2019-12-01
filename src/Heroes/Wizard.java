package Heroes;

import Constants.Constants;

import java.util.Collection;

public class Wizard extends Hero {
    public Wizard (int row, int col) {
        super(row, col);
        this.hp = 400;
        this.maxHp = 400;
    }

    @Override
    public void fightBack(Hero hero) {
        hero.fightWith(this);
    }

    @Override
    public void fightWith(Pyromancer pyroHero) {
        float drainPercent = Constants.initialDrainPercent +
                Constants.levelDrainPercent * this.level;
        float wizardHp = (float) Math.min(Constants.wizardBaseHpCoef *
                (float) pyroHero.maxHp, (float) pyroHero.hp);

        float pyroHeroDamage = 0;

        drainPercent *= Constants.pyroModifDrain;


        float drainDamage = drainPercent * wizardHp;
        if (Map.getInstance().map[rowPos][colPos] == 'D') {
            drainDamage *= Constants.wizardMapModif;
        }

        float deflectPercent = Constants.initialDeflectPercent +
            Constants.levelDeflectPercent * this.level;
        if (deflectPercent > Constants.levelDeflectMaxPercent) {
            deflectPercent = Constants.levelDeflectMaxPercent;
        }
        float fireblast = Constants.fireblastBaseDamage +
                Constants.fireblastLevelDamage * pyroHero.level;

        float ignite = Constants.igniteBaseDamage +
                Constants.igniteLevelDamage * pyroHero.level;

        if(Map.getInstance().map[pyroHero.rowPos][pyroHero.colPos] == 'V') {
            fireblast *= Constants.pyroMapModif;
            ignite *= Constants.pyroMapModif;
        }
        pyroHeroDamage = Math.round(fireblast) + Math.round(ignite);

        deflectPercent *= Constants.pyroModifDeflect;

        float totalDeflectDamage = deflectPercent * pyroHeroDamage;
        if (Map.getInstance().map[rowPos][colPos] == 'D') {
            totalDeflectDamage *= Constants.wizardMapModif;
        }
        totalDeflectDamage = Math.round(totalDeflectDamage);
        pyroHero.getActiveDamage((int) Math.round(totalDeflectDamage + drainDamage));
    }

    @Override
    public void fightWith(Wizard wizardHero) {

    }

    @Override
    public void fightWith(Knight knightHero) {

    }

    @Override
    public void fightWith(Rogue rogueHero) {

    }

    @Override
    public void fight(Hero otherHero) {
        float drainPercent = Constants.initialDrainPercent +
                Constants.levelDrainPercent * this.level;
        float wizardHp = (float) Math.min(Constants.wizardBaseHpCoef *
                (float) otherHero.maxHp, (float) otherHero.hp);
        float otherHeroDamage = 0;

        if (otherHero instanceof Rogue) {
            drainPercent *= Constants.rogueModifDrain;
        }
        if (otherHero instanceof Knight) {
            drainPercent *= Constants.knightModifDrain;
        }
        if (otherHero instanceof Wizard) {
            drainPercent *= Constants.wizardModifDrain;
        }
        if (otherHero instanceof Rogue) {
            drainPercent *= Constants.rogueModifDrain;
        }

        float drainDamage = drainPercent * wizardHp;
        if (Map.getInstance().map[rowPos][colPos] == 'D') {
            drainDamage *= Constants.wizardMapModif;
        }

        float deflectPercent = Constants.initialDeflectPercent +
                Constants.levelDeflectPercent * this.level;
        if (deflectPercent > Constants.levelDeflectMaxPercent) {
            deflectPercent = Constants.levelDeflectMaxPercent;
        }

        if (otherHero instanceof Pyromancer) {
            float fireblast = Constants.fireblastBaseDamage +
                    Constants.fireblastLevelDamage * otherHero.level;
            float ignite = Constants.igniteBaseDamage +
                    Constants.igniteLevelDamage * otherHero.level;
            if(Map.getInstance().map[otherHero.rowPos][otherHero.colPos] == 'V') {
                fireblast *= Constants.pyroMapModif;
                ignite *= Constants.pyroMapModif;
            }
            otherHeroDamage = Math.round(fireblast) + Math.round(ignite);
        }

        if (otherHero instanceof Knight) {
            float hpLimit = Constants.knightHpLimitModif * (float) this.maxHp;
            if(otherHero.level < Constants.knightMaxLevel) {
                hpLimit += ((float) otherHero.level/ 100) * (float) this.maxHp;
            }
            else {
                hpLimit += Constants.knightMaxHpDamageModif * (float) this.maxHp;
            }
            int isExecuted = 0;
            if ((float) this.hp < hpLimit && this.hp > 0) {
                otherHeroDamage = this.hp;
                isExecuted = 1;
            }
            else {
                otherHeroDamage = Constants.executeBaseDamage + Constants.executeLevelDamage * this.level;
                otherHeroDamage = Constants.slamBaseDamage + Constants.slamLevelDamage;
            }
            if (Map.getInstance().map[otherHero.rowPos][otherHero.colPos] == 'L' && isExecuted == 0) {
                otherHeroDamage *= Constants.knightMapModif;
            }
        }

        if (otherHero instanceof Rogue) {
            otherHeroDamage = Constants.backstabBaseDamage + Constants.backstabLevelDamage * otherHero.level;
            if (Map.getInstance().map[otherHero.rowPos][otherHero.colPos] == 'W' &&
                    (((Rogue) otherHero).backstabAttacks - 1) % 3 == 0 ) {
                otherHeroDamage *= Constants.backstabAmplifier;
            }
            otherHeroDamage = Constants.paralysisBaseDamage + Constants.paralysisLevelDamage * otherHero.level;
            if (Map.getInstance().map[otherHero.rowPos][otherHero.colPos] == 'W') {
                otherHeroDamage *= Constants.rogueMapModif;
            }
        }

        if (otherHero instanceof Rogue) {
            deflectPercent *= Constants.rogueModifDeflect;
        }
        if (otherHero instanceof Knight) {
            deflectPercent *= Constants.knightModifDeflect;
        }
        if (otherHero instanceof Pyromancer) {
            deflectPercent *= Constants.pyroModifDeflect;
        }

        float totalDeflectDamage = deflectPercent * otherHeroDamage;
        if (Map.getInstance().map[rowPos][colPos] == 'D') {
            totalDeflectDamage *= Constants.wizardMapModif;
        }
        totalDeflectDamage = Math.round(totalDeflectDamage);
        otherHero.getActiveDamage((int) Math.round(totalDeflectDamage + drainDamage));
    }

    @Override
    public String toString() {
        if (isAlive) {
            return "W" + " " + this.level + " " + this.xp + " " +  this.hp + " " +  this.rowPos + " " + this.colPos;
        } else {
            return "W dead";
        }
    }
}
