import java.util.HashMap;
import java.util.Set;

class HashMapPractice {
    public static void main(String[] args){
        HashMap<String, String> trackList = new HashMap<String, String>();

        trackList.put("Hello", "Hello from the other side.");
        trackList.put("Another Love", "If somebody hurts you I wanna fight but my hands been broken one too many times.");
        trackList.put("Unstoppable", "I'm unstoppable I'm a Porsche with no brakes I'm invincible Yeah, I win every single game.");
        trackList.put("The Greatest", " I work hard, pray hard, pay dues, I transform with pressure, I'm hands-on with effort, I fell twice before, my bounce back was special.");

        String track1 = trackList.get("Hello");
        System.out.println(track1);


        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key + ":" + trackList.get(key));
        }


    }
}