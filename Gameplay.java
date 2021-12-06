public class Gameplay {
    
    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);

        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut suspicious = new RedAstronaut("Suspicious Person", 100, "expert");

        liam.sabotage(bob);
        System.out.println(bob.toString());
        liam.freeze(suspicious);
        System.out.println(suspicious.toString());
        liam.freeze(albert);
        System.out.println(liam.toString());
        System.out.println(albert.toString());
        albert.emergencyMeeting();
        suspicious.emergencyMeeting();
        bob.emergencyMeeting();
        System.out.println(suspicious.toString());
        heath.completeTask();
        System.out.println(heath.toString());
        heath.completeTask();
        System.out.println(heath.toString());
        heath.completeTask();
        liam.freeze(angel);
        System.out.println(angel.toString());
        System.out.println(liam.toString());
        liam.sabotage(bob);
        System.out.println(bob.toString());
        liam.sabotage(bob);
        liam.freeze(bob);
        System.out.println(bob.toString());

        // Two options

        // angel.emergencyMeeting();
        // System.out.println(liam.toString());
        
        liam.sabotage(heath);
        System.out.println(heath.toString());
        liam.sabotage(heath);
        System.out.println(heath.toString());
        liam.sabotage(heath);
        System.out.println(heath.toString());
        liam.sabotage(heath);
        System.out.println(heath.toString());
        liam.sabotage(heath);
        System.out.println(heath.toString());
        liam.freeze(heath);
        System.out.println(heath.toString());



        
    }
}