package at.ac.fhcampuswien;

import java.util.Scanner;

public class App {
    Scanner scan = new Scanner(System.in);
    //todo Task 1
    public void largestNumber() {
        double z = 1, max = 0;
        int n = 1;
        while (z > 0) {
            System.out.print("Number " + n + ": ");
            z = scan.nextDouble();
            if (n == 1 && z <= 0) {
                System.out.println("No number entered.");
            }
            else {
                if (z > max) {
                    max = z;
                }
                n++;
            }
        }
           if(n >= 2){System.out.println("The largest number is " + String.format("%.2f", max));}
    }

    //todo Task 2
    public void stairs(){
        System.out.print("n: ");
        int n = scan.nextInt(), z = 1;
        if(n<=0){
            System.out.println("Invalid number!");
        } else {
            for (int x = 1; x <= n; x++) {
                for (int y = 1; y <= x; y++) {
                    System.out.print(z + " ");
                    ++z;
                }
                System.out.println();
            }
        }
    }

    //todo Task 3
    public void printPyramid(){
        int r = 6, k = 0;

        for (int i = 1; i <= r; i++, k = 0) {
            for (int space = 1; space <= r - i; space++) {
                System.out.print(" ");
            }

            while (k != 2 * i - 1) {
                System.out.print("*");
                k++;
            }

            System.out.println();
        }
    }

    //todo Task 4
    public void printRhombus(){
        //scan die Höhe
        System.out.print("h: ");
        int h = scan.nextInt();
        //scan char in der Mitte der Raute
        System.out.print("c: ");
        char c = scan.next().charAt(0);
        //if Höhe keine ungerade Zahl dann error
        if(h%2 == 0) {
            System.out.println("Invalid number!");
        }
        else {	//if Höhe eine gerade zahl
            int h2 = h/2 +1;	//rechne Höhe von oberen hälte von Raute (+Mittlere linie)
            //create char array für Raute (Selbe Anzahl von char wie die halbe Höhe)
            char[] ch = new char[h2];
            ch[0] = c;	//erste char ist die in der Mitte der Raute
            //fülle den Rest vom array amit nächstfolgenden chars (nächste nach ch[0])
            for(int a = 1; a < h2; a++) {
                ch[a] = (char) (c-a);
            }
            //main printing loop
            for(int i = 0; i < h2; i++) {   //erste hälfte (+mittlere Reihe)
                //space loop
                for(int j = 0; j < (h/2 -i); j++) {
                    System.out.print(" ");
                }
                System.out.print(ch[i]);	//print erste char (äußerste char der Reihe)
                if(ch[i] != ch[0]) {	//if erste char nicht der char in der mitte
                    //print jede char welches zum mittleren Charakter führt (minus erste char)
                    for(int n = i-1; n>-1; n--) {
                        System.out.print(ch[n]);
                    }
                    //print jede char welche nach dem mittleren kommt (bis zum erstsen char der liste)
                    for(int m = 1; m <= i; m++) {
                        System.out.print(ch[m]);
                    }
                }
                System.out.println();	//print neue reihe
            }
            //print loop 2te Hälfte
            for(int i = 0; i < h/2; i++) {
                //spaces loop
                for(int j = 0; j <= i; j++) {
                    System.out.print(" ");
                }
                int x = h/2-1-i;    //ende von array pointer (welche char zum printen)
                System.out.print(ch[x]);	//print erste char
                //selbe prinzip wie oben
                if(ch[x] != ch[0]) {
                    for(int n = x-1; n>-1; n--) {
                        System.out.print(ch[n]);
                    }
                    for(int m = 1; m <= x; m++) {
                        System.out.print(ch[m]);
                    }
                }
                System.out.println();
            }
        }
    }

    //todo Task 5
    public void marks(){
        float d, n=1, sum=0;
        int m = 1, f=0;
        while (n != 0) {
            System.out.print("Mark " + m + ": ");
            m++;
            n = scan.nextInt();
            if(n==5)
                f++;
            if (0 > n || n >= 6) {
                System.out.println("Invalid mark!");
                m--;
            } else {
                sum = sum + n;
            }
        }
        if(sum==0)
            d=0;
        else
            d = sum / (m - 2);
        System.out.println("Average: " + String.format("%.2f", d));
        System.out.println("Negative marks: " + f);

    }

    //todo Task 6
    public void happyNumbers(){
        System.out.print("n: ");
        int num = scan.nextInt(), r=1, sum=0;

        while (num > 9)
        {
            while (num > 0)
            {
                r = num % 10;
                sum = sum + (r * r);
                num = num / 10;
            }
            num = sum;
            sum = 0;
        }
        if (num == 1)
        {
            System.out.println("Happy number!");
        }
        else
        {
            System.out.println("Sad number!");
        }
    }

    public static void main(String[] args){
        App exercise2 = new App();

        System.out.println("Task 1: Largest Number");
        exercise2.largestNumber();

        System.out.println("\nTask 2: Stairs");
        exercise2.stairs();

        System.out.println("\nTask 3: Pyramide");
        exercise2.printPyramid();

        System.out.println("\nTask 4: Raute");
        exercise2.printRhombus();


        System.out.println("\nTask 5: Notendurchschnitt");
        exercise2.marks();

        System.out.println("\nTask 6: Fröhliche Zahlen");
        exercise2.happyNumbers();
    }
}