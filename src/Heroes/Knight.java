package Heroes;

import Constants.Constants;

public final class Knight extends Hero {
    public Knight(final int row, final int col) {
        super(row, col);
        this.hp = Constants.INITIAL_KNIGHT_HP;
        this.maxHp = Constants.INITIAL_KNIGHT_HP;
    }

    @Override
    public void fightBack(final Hero hero) {
        hero.fightWith(this);
    }

    @Override
    public void fightWith(final Pyromancer pyroHero) {
        float hpLimit = Constants.HP_LIMIT_COEF * pyroHero.maxHp;
        float executeActiveDamage = 0;
        float slamActiveDamage = Constants.SLAM_BASE_DAMAGE;
        float totalActiveDamage;

        if (this.level < Constants.LEVEL_LIMIT) {
            hpLimit += ((float) this.level / Constants.PERCENT) * pyroHero.maxHp;
        } else {
            hpLimit += Constants.KNIGHT_MAX_LEVEL_COEF * pyroHero.maxHp;
        }
        if ((float) pyroHero.hp < hpLimit && pyroHero.hp > 0) {
            executeActiveDamage = pyroHero.hp;
            pyroHero.getActiveDamage(Math.round(executeActiveDamage));
        } else {
            executeActiveDamage = Constants.EXECUTE_BASE_DAMAGE;
            executeActiveDamage += Constants.EXECUTE_LEVEL_DAMAGE * this.level;
            slamActiveDamage += Constants.SLAM_LEVEL_DAMAGE * this.level;

            if (Map.getInstance().map[rowPos][colPos] == 'L') {
                executeActiveDamage *= Constants.KNIGHT_MAP_MODIF;
                slamActiveDamage *= Constants.KNIGHT_MAP_MODIF;
            }

            executeActiveDamage *= Constants.PYRO_MODIF_EXECUTE;
            slamActiveDamage *= Constants.PYRO_MODIF_SLAM;

            totalActiveDamage = slamActiveDamage + executeActiveDamage;

            pyroHero.getActiveDamage(Math.round(totalActiveDamage));
            pyroHero.imobilized = 1;
        }
    }

    @Override
    public void fightWith(final Wizard wizardHero) {
        float hpLimit = Constants.HP_LIMIT_COEF * wizardHero.maxHp;
        float executeActiveDamage = 0;
        float slamActiveDamage = Constants.SLAM_BASE_DAMAGE;
        float totalActiveDamage;

        if (this.level < Constants.LEVEL_LIMIT) {
            hpLimit += ((float) this.level / Constants.PERCENT) * wizardHero.maxHp;
        } else {
            hpLimit += Constants.KNIGHT_MAX_LEVEL_COEF * wizardHero.maxHp;
        }
        if ((float) wizardHero.hp < hpLimit && wizardHero.hp > 0) {
            executeActiveDamage = wizardHero.hp;
            wizardHero.getActiveDamage(Math.round(executeActiveDamage));
        } else {
            executeActiveDamage = Constants.EXECUTE_BASE_DAMAGE;
            executeActiveDamage += Constants.EXECUTE_LEVEL_DAMAGE * this.level;
            slamActiveDamage += Constants.SLAM_LEVEL_DAMAGE * this.level;

            if (Map.getInstance().map[rowPos][colPos] == 'L') {
                executeActiveDamage *= Constants.KNIGHT_MAP_MODIF;
                slamActiveDamage *= Constants.KNIGHT_MAP_MODIF;
            }

            executeActiveDamage *= Constants.WIZARD_MODIF_EXECUTE;
            slamActiveDamage *= Constants.WIZARD_MODIF_SLAM;

            totalActiveDamage = slamActiveDamage + executeActiveDamage;

            wizardHero.getActiveDamage(Math.round(totalActiveDamage));
            wizardHero.imobilized = 1;
        }

    }

    @Override
    public void fightWith(final Knight knightHero) {
        float hpLimit = Constants.HP_LIMIT_COEF * knightHero.maxHp;
        float executeActiveDamage = 0;
        float slamActiveDamage = Constants.SLAM_BASE_DAMAGE;
        float totalActiveDamage;

        if (this.level < Constants.LEVEL_LIMIT) {
            hpLimit += ((float) this.level / Constants.PERCENT) * knightHero.maxHp;
        } else {
            hpLimit += Constants.KNIGHT_MAX_LEVEL_COEF * knightHero.maxHp;
        }
        if ((float) knightHero.hp < hpLimit && knightHero.hp > 0) {
            executeActiveDamage = knightHero.hp;
            knightHero.getActiveDamage(Math.round(executeActiveDamage));
        } else {
            executeActiveDamage = Constants.EXECUTE_BASE_DAMAGE;
            executeActiveDamage += Constants.EXECUTE_LEVEL_DAMAGE * this.level;
            slamActiveDamage += Constants.SLAM_LEVEL_DAMAGE * this.level;

            if (Map.getInstance().map[rowPos][colPos] == 'L') {
                executeActiveDamage *= Constants.KNIGHT_MAP_MODIF;
                slamActiveDamage *= Constants.KNIGHT_MAP_MODIF;
            }

            executeActiveDamage *= Constants.KNIGHT_MODIF_EXECUTE;
            slamActiveDamage *= Constants.KNIGHT_MODIF_SLAM;

            totalActiveDamage = slamActiveDamage + executeActiveDamage;

            knightHero.getActiveDamage((int) Math.round(totalActiveDamage));
            knightHero.imobilized = 1;
        }

    }

    @Override
    public void fightWith(final Rogue rogueHero) {
        float hpLimit = Constants.HP_LIMIT_COEF * rogueHero.maxHp;
        float executeActiveDamage = 0;
        float slamActiveDamage = Constants.SLAM_BASE_DAMAGE;
        float totalActiveDamage;

        if (this.level < Constants.LEVEL_LIMIT) {
            hpLimit += ((float) this.level / Constants.PERCENT) * rogueHero.maxHp;
        } else {
            hpLimit += Constants.KNIGHT_MAX_LEVEL_COEF * rogueHero.maxHp;
        }
        if ((float) rogueHero.hp < hpLimit && rogueHero.hp > 0) {
            executeActiveDamage = rogueHero.hp;
            rogueHero.getActiveDamage(Math.round(executeActiveDamage));
        } else {
            executeActiveDamage = Constants.EXECUTE_BASE_DAMAGE;
            executeActiveDamage += Constants.EXECUTE_LEVEL_DAMAGE * this.level;
            slamActiveDamage += Constants.SLAM_LEVEL_DAMAGE * this.level;

            if (Map.getInstance().map[rowPos][colPos] == 'L') {
                executeActiveDamage *= Constants.KNIGHT_MAP_MODIF;
                slamActiveDamage *= Constants.KNIGHT_MAP_MODIF;
            }

            executeActiveDamage *= Constants.ROGUE_MODIF_EXECUTE;
            slamActiveDamage *= Constants.ROGUE_MOFIF_SLAM;

            totalActiveDamage = slamActiveDamage + executeActiveDamage;

            rogueHero.getActiveDamage((int) Math.round(totalActiveDamage));
            rogueHero.imobilized = 1;
        }
    }

    @Override
    public String toString() {
        if (isAlive) {
            return "K" + " " + this.level + " " + this.xp + " " +  this.hp
                    + " " +  this.rowPos + " " + this.colPos;
        } else {
            return "K dead";
        }
    }
}
