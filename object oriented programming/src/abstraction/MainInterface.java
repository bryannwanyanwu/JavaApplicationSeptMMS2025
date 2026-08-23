
package abstraction;


public interface MainInterface {
    public static void main(String[] args){
        SmartPhone smartphone = new SmartPhone();
        
        
    Nokia3310 nokia = new Nokia3310();
    System.out.println("Smartphone interface\n");
    
        smartphone.makeCall();
        smartphone.playGame ();
        smartphone.playMusic();
        smartphone.playMovie();
        smartphone.takePicture();
        smartphone.connectToWifi ();
        
        System.out.println("\nNokia3310 interface");
        nokia.makeCall ();
        nokia.playGame();
        nokia.playMusic();
    }
    
}

