package Heroes;

import Constants.Constants;

public final class Pyromancer extends Hero {
    public Pyromancer(final int rowPos, final int colPos) {
        super(rowPos, colPos);
        this.hp = Constants.INITIAL_PYROMANCER_HP;
        this.maxHp = Constants.INITIAL_PYROMANCER_HP;
    }

    @Override
    public void fightBack(final Hero hero) {
        hero.fightWith(this);
    }

    @Override
    public void fightWith(final Pyromancer pyroHero) {
        float fireblastActiveDamage = Constants.FIREBLAST_BASE_DAMAGE
                + Constants.FIREBLAST_LEVEL_DAMAGE * this.level;
        float igniteActiveDamage = Constants.IGNITE_BASE_DAMAGE
                + Constants.IGNITE_LEVEL_BASE_DAMAGE * this.level;
        float igniteOvertimeDamage = Constants.IGNITE_OVERTIME_DAMAGE
                + Constants.IGNITE_LEVEL_DAMAGE * this.level;

        if (Map.getInstance().map[rowPos][colPos] == 'V') {
            fireblastActiveDamage *=  Constants.PYRO_MAP_MODIF;
            igniteOvertimeDamage *= Constants.PYRO_MAP_MODIF;
        }

        fireblastActiveDamage *= Constants.PYROMANCER_MODIF;
        igniteActiveDamage *= Constants.PYROMANCER_MODIF;
        igniteOvertimeDamage *= Constants.PYROMANCER_MODIF;

        pyroHero.hp -= fireblastActiveDamage;
        pyroHero.hp -= igniteActiveDamage;
        pyroHero.overtimeDamage = igniteOvertimeDamage;
        pyroHero.damageOvertimeRounds = 2;
    }

    @Override
    public void fightWith(final Rogue rogueHero) {
        float fireblastActiveDamage = Constants.FIREBLAST_BASE_DAMAGE
                + Constants.FIREBLAST_LEVEL_DAMAGE * this.level;
        float igniteActiveDamage = Constants.IGNITE_BASE_DAMAGE
                + Constants.IGNITE_LEVEL_BASE_DAMAGE * this.level;
        float igniteOvertimeDamage = Constants.IGNITE_OVERTIME_DAMAGE
                + Constants.IGNITE_LEVEL_DAMAGE * this.level;

        if (Map.getInstance().map[rowPos][colPos] == 'V') {
            fireblastActiveDamage *=  Constants.PYRO_MAP_MODIF;
            igniteOvertimeDamage *= Constants.PYRO_MAP_MODIF;
        }

        fireblastActiveDamage *= Constants.ROGUE_MODIF;
        igniteActiveDamage *= Constants.ROGUE_MODIF;
        igniteOvertimeDamage *= Constants.ROGUE_MODIF;

        rogueHero.hp -= fireblastActiveDamage;
        rogueHero.hp -= igniteActiveDamage;
        rogueHero.overtimeDamage = igniteOvertimeDamage;
        rogueHero.damageOvertimeRounds = 2;
    }

    @Override
    public void fightWith(final Knight knightHero) {
        float fireblastActiveDamage = Constants.FIREBLAST_BASE_DAMAGE
                + Constants.FIREBLAST_LEVEL_DAMAGE * this.level;
        float igniteActiveDamage = Constants.IGNITE_BASE_DAMAGE
                + Constants.IGNITE_LEVEL_BASE_DAMAGE * this.level;
        float igniteOvertimeDamage = Constants.IGNITE_OVERTIME_DAMAGE
                + Constants.IGNITE_LEVEL_DAMAGE * this.level;

        if (Map.getInstance().map[rowPos][colPos] == 'V') {
            fireblastActiveDamage *=  Constants.PYRO_MAP_MODIF;
            igniteOvertimeDamage *= Constants.PYRO_MAP_MODIF;
        }

        fireblastActiveDamage *= Constants.KNIGHT_MODIF;
        igniteActiveDamage *= Constants.KNIGHT_MODIF;
        igniteOvertimeDamage *= Constants.KNIGHT_MODIF;

        knightHero.hp -= fireblastActiveDamage;
        knightHero.hp -= igniteActiveDamage;
        knightHero.overtimeDamage = igniteOvertimeDamage;
        knightHero.damageOvertimeRounds = 2;
    }

    @Override
    public void fightWith(final Wizard wizardHero) {
        float fireblastActiveDamage = Constants.FIREBLAST_BASE_DAMAGE
                + Constants.FIREBLAST_LEVEL_DAMAGE * this.level;
        float igniteActiveDamage = Constants.IGNITE_BASE_DAMAGE
                + Constants.IGNITE_LEVEL_BASE_DAMAGE * this.level;
        float igniteOvertimeDamage = Constants.IGNITE_OVERTIME_DAMAGE
                + Constants.IGNITE_LEVEL_DAMAGE * this.level;

        if (Map.getInstance().map[rowPos][colPos] == 'V') {
            fireblastActiveDamage *=  Constants.PYRO_MAP_MODIF;
            igniteOvertimeDamage *= Constants.PYRO_MAP_MODIF;
        }

        fireblastActiveDamage *= Constants.WIZ_MODIF;
        igniteActiveDamage *= Constants.WIZ_MODIF;
        igniteOvertimeDamage *= Constants.WIZ_MODIF;

        wizardHero.hp -= fireblastActiveDamage;
        wizardHero.hp -= igniteActiveDamage;
        wizardHero.overtimeDamage = igniteOvertimeDamage;
        wizardHero.damageOvertimeRounds = 2;
    }

    @Override
    public String toString() {
        if (isAlive) {
            return "P" + " " + this.level + " " + this.xp + " " +  this.hp
                    + " " +  this.rowPos + " " + this.colPos;
        } else {
            return "P dead";
        }
    }
}
