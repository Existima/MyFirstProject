import java.util.Scanner;

public class test1 {
    static int l = 7;
    {
        System.out.println(l);
    }

    public static void main(String[] args) {
        System.out.println(l);
        int l = 8;
        System.out.println(l);




        //method
        System.out.println("u mienia poluchilos?");

        //type identifier = new type();
        Scanner ssscanner = new Scanner(System.in);
        String name = ssscanner.nextLine();
        if ("yes".equals(name)) {
            System.out.println("yes");
        }else if ("no".equals(name)) {
            System.out.println("no");
        }else {
            System.out.println("niher nie poluchaetsa s " + name);
        }
    }
}