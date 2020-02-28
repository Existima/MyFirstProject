import java.util.ArrayList;

public class Test {
    public static void main(String... args) {
//        for (String arg : args) {
//            System.out.println(arg);
//        }
        for (int i = 0; args.length > i; i = i + 2) {
            System.out.println(i);
            System.out.println(args[1]);
        }
        System.out.println(printName("lastName"));

    }

    public static String printName(String command) {
        String result;
        switch (command) {
            case "firstName":
                result = "wasia";
                break;
            case "lastName":
                result = "perun";
                break;
            default:
                result = "huj";
                break;
        }
        return result;
    }

    byte x = Byte.MAX_VALUE;
    int y = Integer.MAX_VALUE;
    float z = 3.4f;
    double t = 3.5;
    char s = 'f';
    boolean D = false;

}
