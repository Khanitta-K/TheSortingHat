import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Home {

    private ArrayList<String> Gryffindor = new ArrayList<>();
    private ArrayList<String> Hafflepuff = new ArrayList<>();
    private ArrayList<String> Ravenclaw = new ArrayList<>();
    private ArrayList<String> Slytherin = new ArrayList<>();
    private int numSInHome; // number of student in home

    public Home(int n) {
        setNumSOfHome(n);
    }

    public void add(int n, String name) { // add student to home (number of home,name of student)
        if (n == 1) {
            Gryffindor.add(name);
            System.out.println(name + " : " + getNameOfHome(n));
            System.out.println("-----------------------------------------------------------------------");

        } else if (n == 2) {
            Hafflepuff.add(name);
            System.out.println(name + " : " + getNameOfHome(n));
            System.out.println("-----------------------------------------------------------------------");

        } else if (n == 3) {
            Ravenclaw.add(name);
            System.out.println(name + " : " + getNameOfHome(n));
            System.out.println("-----------------------------------------------------------------------");

        } else if (n == 4) {
            Slytherin.add(name);
            System.out.println(name + " : " + getNameOfHome(n));
            System.out.println("-----------------------------------------------------------------------");

        }
    }

    public String getNameOfHome(int n) {
        if (n == 1) {
            return "Gryffindor";
        } else if (n == 2) {
            return "Hafflepuff";
        } else if (n == 3) {
            return "Ravenclaw";
        } else if (n == 4) {
            return "Slytherin";
        }
        return null;
    }

    public Boolean isEmpty(int n) {
        if (n == 1) {
            if (Gryffindor.size() == 0) {
                return true;
            }
        } else if (n == 2) {
            if (Hafflepuff.size() == 0) {
                return true;
            }
        } else if (n == 3) {
            if (Ravenclaw.size() == 0) {
                return true;
            }
        } else if (n == 4) {
            if (Slytherin.size() == 0) {
                return true;
            }
        }
        return false;
    }

    public Boolean isFull(int n) {
        if (n == 1) {
            if (Gryffindor.size() == numSInHome) {
                System.out.println("  Gryffindor is full.");
                return true;
            }
        } else if (n == 2) {
            if (Hafflepuff.size() == numSInHome) {
                System.out.println("  Hafflepuff is full.");
                return true;
            }
        } else if (n == 3) {
            if (Ravenclaw.size() == numSInHome) {
                System.out.println("  Ravenclaw is full.");
                return true;
            }
        } else if (n == 4) {
            if (Slytherin.size() == numSInHome) {
                System.out.println("  Slytherin is full.");
                return true;
            }
        }
        return false;
    }

    void reset(){
        Gryffindor.clear();
        Hafflepuff.clear();
        Ravenclaw.clear();
        Slytherin.clear();
    }

    public void setNumSOfHome(int n) {
        if (n % 4 == 0) {
            this.numSInHome = n / 4;
        } else {

            this.numSInHome = (n / 4) + 1;
        }

    }

    void showStudentInHome() {
        System.out.println(" Gryffindor " + Gryffindor.size() + " people");
        for (int i = 0; i < Gryffindor.size(); i++) {
            System.out.println("   -> " + Gryffindor.get(i));
        }
        System.out.println("-----------------------------------------------------------------------");

        System.out.println(" Hafflepuff " + Hafflepuff.size() + " people");
        for (int i = 0; i < Hafflepuff.size(); i++) {
            System.out.println("   ->" + Hafflepuff.get(i));
        }
        System.out.println("-----------------------------------------------------------------------");


        System.out.println(" Ravenclaw " + Ravenclaw.size() + " people");
        for (int i = 0; i < Ravenclaw.size(); i++) {
            System.out.println("   ->" + Ravenclaw.get(i));
        }
        System.out.println("-----------------------------------------------------------------------");


        System.out.println(" Slytherin " + Slytherin.size() + " people");
        for (int i = 0; i < Slytherin.size(); i++) {
            System.out.println("   ->" + Slytherin.get(i));
        }
        System.out.println("-----------------------------------------------------------------------");

    }

}

public class SortingHat {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random r = new Random();

        System.out.println("                     Welcome to Welcome to Hogwarts                    ");
        System.out.println(" Placement of new students into housing by the sorting hat begins now. ");
        System.out.println("-----------------------------------------------------------------------");
        
        while (true) {
            System.out.print(" Please input number of student : ");
            int N = scan.nextInt();// number of student.
            System.out.println();
            System.out.println("-----------------------------------------------------------------------");

            Home h = new Home(N);

            int countS = 1;// count number of student.
            while (true) {
                System.out.print(" Please input name of student : ");
                String name = scan.next();
                System.out.println();


                if (countS > N) {
                    System.out.println("                      Complete the student's name.                     ");
                    System.out.println("-----------------------------------------------------------------------");
                    

                    break;
                }

                int nOfhome = r.nextInt(1, 5);
                if (countS <= 4) {
                    while (true) {
                        if (h.isEmpty(nOfhome)) {
                            break;
                        } else {
                            if (nOfhome == 4) {
                                nOfhome = 0;
                            }
                            nOfhome++;
                        }
                    }
                } else if (countS > 4) {
                    while (true) {
                        if (!h.isFull(nOfhome)) {
                            break;
                        } else {
                            if (nOfhome == 4) {
                                nOfhome = 0;
                            }
                            nOfhome++;
                        }
                    }
                }

                h.add(nOfhome, name);
                countS++;
                // System.out.println(nOfhome);
            }

            h.showStudentInHome();

            System.out.print(" Do you want to reset? (Y/N) : ");
            System.out.println();
            String reset = scan.next();
            System.out.println("-----------------------------------------------------------------------");

            if (reset.equals("Y")) {
                h.reset();
            } else {
                return;
            }
        }

    }
}