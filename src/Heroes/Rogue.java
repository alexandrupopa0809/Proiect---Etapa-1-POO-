package Heroes;

import Constants.Constants;

public final class Rogue extends Hero {
    int backstabAttacks;

    public Rogue(final int row, final int col) {
        super(row, col);
        this.hp = Constants.INITIAL_ROGUE_HP;
        this.maxHp = Constants.INITIAL_ROGUE_HP;
        backstabAttacks = 0;
    }

    @Override
    public void fightBack(final Hero hero) {
        hero.fightWith(this);
    }

    @Override
    public void fightWith(final Rogue rogueHero) {
        float backstabActiveDamage = Constants.BACKSTAB_BASE_DAMAGE
                + Constants.BACKSTAB_LEVEL_DAMAGE * this.level;
        if (backstabAttacks % Constants.BACKSTABBS_DIVIDER == 0) {
            if (Map.getInstance().map[rowPos][colPos] == 'W') {
                backstabActiveDamage *= Constants.BACKSTAB_AMPLIFIER;
            }
        }
        //incrementez atacurile pentru a vedea cand rogue va da critical hit
        backstabAttacks++;
        float paralysisActiveDamage = Constants.PARALYSIS_BASE_DAMAGE
                + Constants.PARALYSIS_LEVEL_DAMAGE * this.level;
        float paralysisOvertimeDamage = Constants.PARALYSIS_BASE_DAMAGE
                + Constants.PARALYSIS_LEVEL_DAMAGE * this.level;
        int rounds = Constants.ROUNDS_NORMAL;
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            rounds = Constants.ROUNDS_MAX;
        }
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            backstabActiveDamage *= Constants.ROGUE_MAP_MODIF;
            paralysisActiveDamage *= Constants.ROGUE_MAP_MODIF;
            paralysisOvertimeDamage *= Constants.ROGUE_MAP_MODIF;
        }

        backstabActiveDamage *= Constants.ROGUE_MODIF_BACKSTAB;
        paralysisActiveDamage *= Constants.ROGUE_MODIF_PARAL;
        paralysisOvertimeDamage *= Constants.ROGUE_MODIF_PARAL;

        float totalActiveDamage = Math.round(backstabActiveDamage)
                + Math.round(paralysisActiveDamage);
        rogueHero.getActiveDamage(Math.round(totalActiveDamage));
        rogueHero.overtimeDamage = Math.round(paralysisOvertimeDamage);
        rogueHero.damageOvertimeRounds = rounds;
    }

    @Override
    public void fightWith(final Knight knightHero) {
        float backstabActiveDamage = Constants.BACKSTAB_BASE_DAMAGE
                + Constants.BACKSTAB_LEVEL_DAMAGE * this.level;
        if (backstabAttacks % Constants.BACKSTABBS_DIVIDER == 0) {
            if (Map.getInstance().map[rowPos][colPos] == 'W') {
                backstabActiveDamage *= Constants.BACKSTAB_AMPLIFIER;
            }
        }
        //incrementez atacurile pentru a vedea cand rogue va da critical hit
        backstabAttacks++;

        float paralysisActiveDamage = Constants.PARALYSIS_BASE_DAMAGE
                + Constants.PARALYSIS_LEVEL_DAMAGE * this.level;
        float paralysisOvertimeDamage = Constants.PARALYSIS_BASE_DAMAGE
                + Constants.PARALYSIS_LEVEL_DAMAGE * this.level;

        int rounds = Constants.ROUNDS_NORMAL;
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            rounds = Constants.ROUNDS_MAX;
        }
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            backstabActiveDamage *= Constants.ROGUE_MAP_MODIF;
            paralysisActiveDamage *= Constants.ROGUE_MAP_MODIF;
            paralysisOvertimeDamage *= Constants.ROGUE_MAP_MODIF;
        }

        backstabActiveDamage *= Constants.KNIGHT_MODIF_BACKSTAB;
        paralysisActiveDamage *= Constants.KNIGHT_MODIF_PARAL;
        paralysisOvertimeDamage *= Constants.KNIGHT_MODIF_PARAL;

        float totalActiveDamage = Math.round(backstabActiveDamage)
                + Math.round(paralysisActiveDamage);
        knightHero.getActiveDamage(Math.round(totalActiveDamage));
        knightHero.overtimeDamage = Math.round(paralysisOvertimeDamage);
        knightHero.damageOvertimeRounds = rounds;
    }

    @Override
    public void fightWith(final Wizard wizardHero) {
        float backstabActiveDamage = Constants.BACKSTAB_BASE_DAMAGE
                + Constants.BACKSTAB_LEVEL_DAMAGE * this.level;
        if (backstabAttacks % Constants.BACKSTABBS_DIVIDER == 0) {
            if (Map.getInstance().map[rowPos][colPos] == 'W') {
                backstabActiveDamage *= Constants.BACKSTAB_AMPLIFIER;
            }
        }
        //incrementez atacurile pentru a vedea cand rogue va da critical hit
        backstabAttacks++;
        float paralysisActiveDamage = Constants.PARALYSIS_BASE_DAMAGE
                + Constants.PARALYSIS_LEVEL_DAMAGE * this.level;
        float paralysisOvertimeDamage = Constants.PARALYSIS_BASE_DAMAGE
                + Constants.PARALYSIS_LEVEL_DAMAGE * this.level;
        int rounds = Constants.ROUNDS_NORMAL;
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            rounds = Constants.ROUNDS_MAX;
        }
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            backstabActiveDamage *= Constants.ROGUE_MAP_MODIF;
            paralysisActiveDamage *= Constants.ROGUE_MAP_MODIF;
            paralysisOvertimeDamage *= Constants.ROGUE_MAP_MODIF;
        }

        backstabActiveDamage *= Constants.WIZARD_MODIF_BACKSTAB;
        paralysisActiveDamage *= Constants.WIZARD_MODIF_PARAL;
        paralysisOvertimeDamage *= Constants.WIZARD_MODIF_PARAL;

        float totalActiveDamage = Math.round(backstabActiveDamage)
                + Math.round(paralysisActiveDamage);
        wizardHero.getActiveDamage(Math.round(totalActiveDamage));
        wizardHero.overtimeDamage = Math.round(paralysisOvertimeDamage);
        wizardHero.damageOvertimeRounds = rounds;
    }

    @Override
    public void fightWith(final Pyromancer pyroHero) {
        float backstabActiveDamage = Constants.BACKSTAB_BASE_DAMAGE
                + Constants.BACKSTAB_LEVEL_DAMAGE * this.level;
        if (backstabAttacks % Constants.BACKSTABBS_DIVIDER == 0) {
            if (Map.getInstance().map[rowPos][colPos] == 'W') {
                backstabActiveDamage *= Constants.BACKSTAB_AMPLIFIER;
            }
        }
        //incrementez atacurile pentru a vedea cand rogue va da critical hit
        backstabAttacks++;

        float paralysisActiveDamage = Constants.PARALYSIS_BASE_DAMAGE
                + Constants.PARALYSIS_LEVEL_DAMAGE * this.level;
        float paralysisOvertimeDamage = Constants.PARALYSIS_BASE_DAMAGE
                + Constants.PARALYSIS_LEVEL_DAMAGE * this.level;

        int rounds = Constants.ROUNDS_NORMAL;
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            rounds = Constants.ROUNDS_MAX;
        }
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            backstabActiveDamage *= Constants.ROGUE_MAP_MODIF;
            paralysisActiveDamage *= Constants.ROGUE_MAP_MODIF;
            paralysisOvertimeDamage *= Constants.ROGUE_MAP_MODIF;
        }

        backstabActiveDamage *= Constants.PYRO_MODIF_BACKSTAB;
        paralysisActiveDamage *= Constants.PYRO_MODIF_PARAL;
        paralysisOvertimeDamage *= Constants.PYRO_MODIF_PARAL;

        float totalActiveDamage = Math.round(backstabActiveDamage)
                + Math.round(paralysisActiveDamage);
        pyroHero.getActiveDamage(Math.round(totalActiveDamage));
        pyroHero.overtimeDamage = Math.round(paralysisOvertimeDamage);
        pyroHero.damageOvertimeRounds = rounds;
    }

    @Override
    public String toString() {
        if (isAlive) {
            return "R" + " " + this.level + " " + this.xp + " " +  this.hp
                    + " " +  this.rowPos + " " + this.colPos;
        } else {
            return "R dead";
        }
    }
}
