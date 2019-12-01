package Heroes;

import Constants.Constants;

public final class Wizard extends Hero {
    public Wizard(final int row, final int col) {
        super(row, col);
        this.hp = Constants.INITIAL_WIZARD_HP;
        this.maxHp = Constants.INITIAL_WIZARD_HP;
    }

    @Override
    public void fightBack(final Hero hero) {
        hero.fightWith(this);
    }

    @Override
    public void fightWith(final Pyromancer pyroHero) {
        float drainPercent = Constants.INITIAL_DRAIN_PERCENT
                + Constants.LEVEL_DRAIN_PERCENT * this.level;
        float wizardHp = Math.min(Constants.WIZARD_BASE_HP_COEF
                * (float) pyroHero.maxHp, (float) pyroHero.hp);

        float pyroHeroDamage = 0;

        drainPercent *= Constants.PYRO_MODIF_DRAIN;


        float drainDamage = drainPercent * wizardHp;
        if (Map.getInstance().map[rowPos][colPos] == 'D') {
            drainDamage *= Constants.WIZARD_MAP_MODIF;
        }

        float deflectPercent = Constants.INITIAL_DEFLECT_PERCENT
                + Constants.LEVEL_DEFLECT_PERCENT * this.level;
        if (deflectPercent > Constants.LEVEL_DEFLECT_MAX_PERCENT) {
            deflectPercent = Constants.LEVEL_DEFLECT_MAX_PERCENT;
        }
        float fireblast = Constants.FIREBLAST_BASE_DAMAGE
                + Constants.FIREBLAST_LEVEL_DAMAGE * pyroHero.level;

        float ignite = Constants.IGNITE_BASE_DAMAGE
                + Constants.IGNITE_LEVEL_DAMAGE * pyroHero.level;

        if (Map.getInstance().map[pyroHero.rowPos][pyroHero.colPos] == 'V') {
            fireblast *= Constants.PYRO_MAP_MODIF;
            ignite *= Constants.PYRO_MAP_MODIF;
        }
        pyroHeroDamage = Math.round(fireblast) + Math.round(ignite);

        deflectPercent *= Constants.PYRO_MODIF_DEFLECT;

        float totalDeflectDamage = deflectPercent * pyroHeroDamage;
        if (Map.getInstance().map[rowPos][colPos] == 'D') {
            totalDeflectDamage *= Constants.WIZARD_MAP_MODIF;
        }
        totalDeflectDamage = Math.round(totalDeflectDamage);
        pyroHero.getActiveDamage((int) Math.round(totalDeflectDamage + drainDamage));

    }

    @Override
    public void fightWith(final Wizard wizardHero) {
        float drainPercent = Constants.INITIAL_DRAIN_PERCENT
                + Constants.LEVEL_DRAIN_PERCENT * this.level;
        float wizardHp = Math.min(Constants.WIZARD_BASE_HP_COEF
                * (float) wizardHero.maxHp, (float) wizardHero.hp);

        drainPercent *= Constants.WIZARD_MODIF_DRAIN;

        float drainDamage = drainPercent * wizardHp;
        if (Map.getInstance().map[rowPos][colPos] == 'D') {
            drainDamage *= Constants.WIZARD_MAP_MODIF;
        }
        wizardHero.getActiveDamage(Math.round(drainDamage));
    }

    @Override
    public void fightWith(final Knight knightHero) {
        float drainPercent = Constants.INITIAL_DRAIN_PERCENT
                + Constants.LEVEL_DRAIN_PERCENT * this.level;
        float wizardHp = Math.min(Constants.WIZARD_BASE_HP_COEF
                * (float) knightHero.maxHp, (float) knightHero.hp);

        float knightHeroDamage = 0;

        drainPercent *= Constants.KNIGHT_MODIF_DRAIN;


        float drainDamage = drainPercent * wizardHp;
        if (Map.getInstance().map[rowPos][colPos] == 'D') {
            drainDamage *= Constants.WIZARD_MAP_MODIF;
        }

        float deflectPercent = Constants.INITIAL_DEFLECT_PERCENT
                + Constants.LEVEL_DEFLECT_PERCENT * this.level;
        if (deflectPercent > Constants.LEVEL_DEFLECT_MAX_PERCENT) {
            deflectPercent = Constants.LEVEL_DEFLECT_MAX_PERCENT;
        }
        float hpLimit = Constants.KNIGHT_HP_LIMIT_MODIF * (float) this.maxHp;

        if (knightHero.level < Constants.KNIGHT_MAX_LEVEL) {
            hpLimit += ((float) knightHero.level / Constants.PERCENT)
                    * (float) this.maxHp;
        } else {
            hpLimit += Constants.KNIGHT_MAX_HP_DAMAGE_MODIF * (float) this.maxHp;
        }
        int isExecuted = 0;
        if ((float) this.hp < hpLimit && this.hp > 0) {
            knightHeroDamage = this.hp;
            isExecuted = 1;
        } else {
            knightHeroDamage = Constants.EXECUTE_BASE_DAMAGE
                    + Constants.EXECUTE_LEVEL_DAMAGE * this.level;
            knightHeroDamage = Constants.SLAM_BASE_DAMAGE + Constants.SLAM_LEVEL_DAMAGE;
        }
        if (Map.getInstance().map[knightHero.rowPos][knightHero.colPos] == 'L'
                && isExecuted == 0) {
            knightHeroDamage *= Constants.KNIGHT_MAP_MODIF;
        }

        deflectPercent *= Constants.KNIGHT_MODIF_DEFLECT;

        float totalDeflectDamage = deflectPercent * knightHeroDamage;
        if (Map.getInstance().map[rowPos][colPos] == 'D') {
            totalDeflectDamage *= Constants.WIZARD_MAP_MODIF;
        }
        totalDeflectDamage = Math.round(totalDeflectDamage);
        knightHero.getActiveDamage(Math.round(totalDeflectDamage + drainDamage));
    }

    @Override
    public void fightWith(final Rogue rogueHero) {
        float drainPercent = Constants.INITIAL_DRAIN_PERCENT
                + Constants.LEVEL_DRAIN_PERCENT * this.level;
        float wizardHp = Math.min(Constants.WIZARD_BASE_HP_COEF
                * (float) rogueHero.maxHp, (float) rogueHero.hp);

        float rogueHeroDamage = 0;

        drainPercent *= Constants.ROGUE_MODIF_DRAIN;

        float drainDamage = drainPercent * wizardHp;
        if (Map.getInstance().map[rowPos][colPos] == 'D') {
            drainDamage *= Constants.WIZARD_MAP_MODIF;
        }

        float deflectPercent = Constants.INITIAL_DEFLECT_PERCENT
                + Constants.LEVEL_DEFLECT_PERCENT * this.level;
        if (deflectPercent > Constants.LEVEL_DEFLECT_MAX_PERCENT) {
            deflectPercent = Constants.LEVEL_DEFLECT_MAX_PERCENT;
        }

        rogueHeroDamage = Constants.BACKSTAB_BASE_DAMAGE
                + Constants.BACKSTAB_LEVEL_DAMAGE * rogueHero.level;
        if (Map.getInstance().map[rogueHero.rowPos][rogueHero.colPos] == 'W'
                && ((rogueHero).backstabAttacks - 1)
                % Constants.BACKSTABBS_DIVIDER == 0) {
            rogueHeroDamage *= Constants.BACKSTAB_AMPLIFIER;
        }
        rogueHeroDamage = Constants.PARALYSIS_BASE_DAMAGE
                + Constants.PARALYSIS_LEVEL_DAMAGE * rogueHero.level;
        if (Map.getInstance().map[rogueHero.rowPos][rogueHero.colPos] == 'W') {
            rogueHeroDamage *= Constants.ROGUE_MAP_MODIF;
        }

        deflectPercent *= Constants.ROGUE_MODIF_DEFLECT;

        float totalDeflectDamage = deflectPercent * rogueHeroDamage;
        if (Map.getInstance().map[rowPos][colPos] == 'D') {
            totalDeflectDamage *= Constants.WIZARD_MAP_MODIF;
        }
        totalDeflectDamage = Math.round(totalDeflectDamage);
        rogueHero.getActiveDamage(Math.round(totalDeflectDamage + drainDamage));
    }

    @Override
    public String toString() {
        if (isAlive) {
            return "W" + " " + this.level + " " + this.xp + " " +  this.hp
                    + " " +  this.rowPos + " " + this.colPos;
        } else {
            return "W dead";
        }
    }
}
