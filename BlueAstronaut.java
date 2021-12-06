import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;
    private static final int DEFAULT_SUSLEVEL = 15;
    private static final int DEFAULT_NUMTASKS = 6;
    private static final int DEFAULT_TASKSPEED = 10;

    public BlueAstronaut(String name) {
        super(name, DEFAULT_SUSLEVEL);
        this.numTasks = DEFAULT_NUMTASKS;
        this.taskSpeed = DEFAULT_TASKSPEED;
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    public void emergencyMeeting() {
        if(this.isFrozen()) {
            return;
        }
        Player[] currentPlayers = Player.getPlayers();
        Arrays.sort(currentPlayers);
        for(int i = currentPlayers.length-1; i > -1; i--) {
            if(!currentPlayers[i].isFrozen()) {
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

    public void completeTask() {
        if(this.isFrozen() || this.numTasks == 0) {
            return;
        }
        if(this.taskSpeed > 20) {
            this.numTasks -= 2;
        } else {
            this.numTasks -= 1;
        }
        if(this.numTasks < 0) {
            this.numTasks = 0;
        }
        if(this.numTasks == 0) {
            System.out.println("I have completed all my tasks");
            int newSusLevel = (int) Math.floor(this.getSusLevel()*0.5);
            this.setSusLevel(newSusLevel);
        }
    }

    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut b = (BlueAstronaut) o;
            return this.getName().equals(b.getName()) && this.isFrozen() == b.isFrozen()
                    && this.getSusLevel() == b.getSusLevel();
        }
        return false;
    }

    public String toString() {
        String frozenString = this.isFrozen() ? "frozen" : "not frozen";
        String output = "My name is " + this.getName() + ", and I have a susLevel of "
                + this.getSusLevel() + ". I am currently " + frozenString + "." + " I have " + this.numTasks + " left over.";
        if(this.getSusLevel() > 15) {
            return output.toUpperCase();
        } else {
            return output;
        }
    }
}
