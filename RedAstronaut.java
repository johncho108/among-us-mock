import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    private String skill; 
    private static final int DEFAULT_SUSLEVEL = 15;
    private static final String DEFAULT_SKILL = "experienced";

    public RedAstronaut(String name) {
        super(name, DEFAULT_SUSLEVEL);
        this.skill = DEFAULT_SKILL;
    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }

    public void emergencyMeeting() {
        if(this.isFrozen()) {
            return;
        }
        Player[] currentPlayers = Player.getPlayers();
        Arrays.sort(currentPlayers);
        for(int i = currentPlayers.length-1; i > -1; i--) {
            if(!currentPlayers[i].isFrozen() && !this.equals(currentPlayers[i])) {
                if(i == 0) {
                    currentPlayers[i].setFrozen(true);
                } else if(currentPlayers[i].compareTo(currentPlayers[i-1]) == 1) {
                    currentPlayers[i].setFrozen(true);
                }
                break;
            }
        }
        this.gameOver();
    }

    public void freeze(Player p) {
        if(this.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }
        if(this.getSusLevel() < p.getSusLevel()) {
            p.setFrozen(true);
        } else {
            this.setSusLevel(this.getSusLevel()*2);
        }
        this.gameOver();
    }
    
    public void sabotage(Player p) {
        if(this.isFrozen() || p instanceof Impostor || p.isFrozen()) {
            return;
        }
        if(this.getSusLevel() < 20) {
            int newSusLevel = (int) Math.floor(p.getSusLevel()*1.5);
            p.setSusLevel(newSusLevel);
        } else {
            int newSusLevel = (int) Math.floor(p.getSusLevel()*1.25);
            p.setSusLevel(newSusLevel);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut r = (RedAstronaut) o;
            return this.getName().equals(r.getName()) && this.isFrozen() == r.isFrozen()
                    && this.getSusLevel() == r.getSusLevel();
        }
        return false;
    }

    public String toString() {
        String frozenString = this.isFrozen() ? "frozen" : "not frozen";
        String output = "My name is " + this.getName() + ", and I have a susLevel of "
                + this.getSusLevel() + ". I am currently " + frozenString + "." + " I am an " + this.skill + " player!";
        if(this.getSusLevel() > 15) {
            return output.toUpperCase();
        } else {
            return output;
        }
    }
}
