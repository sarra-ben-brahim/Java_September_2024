import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    Random randMachine = new Random();
    ArrayList<Integer> getTenRolls(){
        int max = 10;
        ArrayList<Integer> randomNums = new ArrayList<Integer>();
        for(int i = 0; i < max; i++){
            int low = 1;
            int high = 20;
            randomNums.add(randMachine.nextInt(high-low) + low);
        }
        return randomNums;
    }

    Character getRandomLetter(){
        char rand;
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        rand = alphabet[new Random().nextInt(alphabet.length)];
        System.out.print(rand);
        return rand;
    }

    String generatePassword(){
        String pwd = "";
        for(int i = 0; i < 8; i++){
            pwd += getRandomLetter();
        }
        return pwd;
    }

    String[] getNewPasswordSet(int len){
        String[] pwdArray = new String[len];
        for(int i = 0; i < len; i++){
            pwdArray[i] = generatePassword();
            System.out.println("\n");
        }
        return pwdArray;
    }
     
}