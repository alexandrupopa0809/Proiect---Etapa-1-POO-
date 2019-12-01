package Heroes;

import Constants.Constants;

public class Rogue extends Hero {
    public int backstabAttacks;
    public Rogue(int row, int col) {
        super(row, col);
        this.hp = 600;
        this.maxHp = 600;
        backstabAttacks = 0;
    }

    @Override
    public void fightBack(Hero hero) {
        hero.fightWith(this);
    }

    @Override
    public void fightWith(Rogue rogueHero) {
        float backstabActiveDamage = Constants.backstabBaseDamage +
                Constants.backstabLevelDamage * this.level;
        if (backstabAttacks % 3 == 0) {
            if(Map.getInstance().map[rowPos][colPos] == 'W') {
                backstabActiveDamage *= Constants.backstabAmplifier;
            }
        }
        //incrementez atacurile pentru a vedea cand rogue va da critical hit
        backstabAttacks++;
        float paralysisActiveDamage = Constants.paralysisBaseDamage +
                Constants.paralysisLevelDamage * this.level;
        float paralysisOvertimeDamage = Constants.paralysisBaseDamage +
                Constants.paralysisLevelDamage * this.level;
        int rounds = 3;
        if(Map.getInstance().map[rowPos][colPos] == 'W') {
            rounds = 6;
        }
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            backstabActiveDamage *= Constants.rogueMapModif;
            paralysisActiveDamage *= Constants.rogueMapModif;
            paralysisOvertimeDamage *= Constants.rogueMapModif;
        }

        backstabActiveDamage *= Constants.rogueModifBackstab;
        paralysisActiveDamage *= Constants.rogueModifParal;
        paralysisOvertimeDamage *= Constants.rogueModifParal;

        float totalActiveDamage = Math.round(backstabActiveDamage) +
                Math.round(paralysisActiveDamage);
        rogueHero.getActiveDamage(Math.round(totalActiveDamage));
        rogueHero.overtimeDamage = Math.round(paralysisOvertimeDamage);
        rogueHero.damageOvertimeRounds = rounds;
    }

    @Override
    public void fightWith(Knight knightHero) {
        float backstabActiveDamage = Constants.backstabBaseDamage +
                Constants.backstabLevelDamage * this.level;
        if (backstabAttacks % 3 == 0) {
            if(Map.getInstance().map[rowPos][colPos] == 'W') {
                backstabActiveDamage *= Constants.backstabAmplifier;
            }
        }
        //incrementez atacurile pentru a vedea cand rogue va da critical hit
        backstabAttacks++;
        float paralysisActiveDamage = Constants.paralysisBaseDamage +
                Constants.paralysisLevelDamage * this.level;
        float paralysisOvertimeDamage = Constants.paralysisBaseDamage +
                Constants.paralysisLevelDamage * this.level;
        int rounds = 3;
        if(Map.getInstance().map[rowPos][colPos] == 'W') {
            rounds = 6;
        }
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            backstabActiveDamage *= Constants.rogueMapModif;
            paralysisActiveDamage *= Constants.rogueMapModif;
            paralysisOvertimeDamage *= Constants.rogueMapModif;
        }

        backstabActiveDamage *= Constants.knightModifBackstab;
        paralysisActiveDamage *= Constants.knightModifParal;
        paralysisOvertimeDamage *= Constants.knightModifParal;

        float totalActiveDamage = Math.round(backstabActiveDamage) +
                Math.round(paralysisActiveDamage);
        knightHero.getActiveDamage(Math.round(totalActiveDamage));
        knightHero.overtimeDamage = Math.round(paralysisOvertimeDamage);
        knightHero.damageOvertimeRounds = rounds;
    }

    @Override
    public void fightWith(Wizard wizardHero) {
        float backstabActiveDamage = Constants.backstabBaseDamage +
                Constants.backstabLevelDamage * this.level;
        if (backstabAttacks % 3 == 0) {
            if(Map.getInstance().map[rowPos][colPos] == 'W') {
                backstabActiveDamage *= Constants.backstabAmplifier;
            }
        }
        //incrementez atacurile pentru a vedea cand rogue va da critical hit
        backstabAttacks++;
        float paralysisActiveDamage = Constants.paralysisBaseDamage +
                Constants.paralysisLevelDamage * this.level;
        float paralysisOvertimeDamage = Constants.paralysisBaseDamage +
                Constants.paralysisLevelDamage * this.level;
        int rounds = 3;
        if(Map.getInstance().map[rowPos][colPos] == 'W') {
            rounds = 6;
        }
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            backstabActiveDamage *= Constants.rogueMapModif;
            paralysisActiveDamage *= Constants.rogueMapModif;
            paralysisOvertimeDamage *= Constants.rogueMapModif;
        }

        backstabActiveDamage *= Constants.wizardModifBackstab;
        paralysisActiveDamage *= Constants.wizardModifParal;
        paralysisOvertimeDamage *= Constants.wizardModifParal;

        float totalActiveDamage = Math.round(backstabActiveDamage) +
                Math.round(paralysisActiveDamage);
        wizardHero.getActiveDamage(Math.round(totalActiveDamage));
        wizardHero.overtimeDamage = Math.round(paralysisOvertimeDamage);
        wizardHero.damageOvertimeRounds = rounds;
    }

    @Override
    public void fightWith(Pyromancer pyroHero) {
        float backstabActiveDamage = Constants.backstabBaseDamage +
                Constants.backstabLevelDamage * this.level;
        if (backstabAttacks % 3 == 0) {
            if(Map.getInstance().map[rowPos][colPos] == 'W') {
                backstabActiveDamage *= Constants.backstabAmplifier;
            }
        }
        //incrementez atacurile pentru a vedea cand rogue va da critical hit
        backstabAttacks++;
        float paralysisActiveDamage = Constants.paralysisBaseDamage +
                Constants.paralysisLevelDamage * this.level;
        float paralysisOvertimeDamage = Constants.paralysisBaseDamage +
                Constants.paralysisLevelDamage * this.level;
        int rounds = 3;
        if(Map.getInstance().map[rowPos][colPos] == 'W') {
            rounds = 6;
        }
        if (Map.getInstance().map[rowPos][colPos] == 'W') {
            backstabActiveDamage *= Constants.rogueMapModif;
            paralysisActiveDamage *= Constants.rogueMapModif;
            paralysisOvertimeDamage *= Constants.rogueMapModif;
        }

        backstabActiveDamage *= Constants.pyroModifBackstab;
        paralysisActiveDamage *= Constants.pyroModifParal;
        paralysisOvertimeDamage *= Constants.pyroModifParal;

        float totalActiveDamage = Math.round(backstabActiveDamage) +
                Math.round(paralysisActiveDamage);
        pyroHero.getActiveDamage(Math.round(totalActiveDamage));
        pyroHero.overtimeDamage = Math.round(paralysisOvertimeDamage);
        pyroHero.damageOvertimeRounds = rounds;
    }

    @Override
    public String toString() {
        if (isAlive) {
            return "R" + " " + this.level + " " + this.xp + " " +  this.hp + " " +  this.rowPos + " " + this.colPos;
        } else {
            return "R dead";
        }
    }
}
