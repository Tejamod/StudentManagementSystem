
import java.sql.SQLException;
import java.util.Scanner;

public class StudentProfile {
    private int id;
    private String name;
    private String domain;
    private String address;
    public StudentProfile(){
    }
    public StudentProfile(int id, String name, String domain, String address) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.address = address;
    }

    public StudentProfile(String name, String domain, String address) {
        this.name = name;
        this.domain = domain;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return " Student id ->" + id + "\n"+
                " name ->" + name + '\n' +
                " domain ->" + domain + '\n' +
                " address ->" + address + '\n';
    }
    public static void main(String[] args) throws SQLException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("The student profile portal");
        Addaction aa = new Addaction();
        while(true){
            System.out.println("\n Press 1 for adding a profile " +
                    "\n Press 2 for displaying profiles " +
                    "\n Press 3 for displaying profile with ID " +
                    "\n Press 4 for deleting profile " +
                    "\n Press 5 for updating profile " +
                    "\n Press 6 to exit \n");
            System.out.println("What do you want to do?");

            int i =sc.nextInt();
            switch(i){
                case 1:
                    System.out.println("Enter Name");
                    String name = sc.next();
                    System.out.println("Enter Domain");
                    String domain = sc.next();
                    System.out.println("Enter Address");
                    String address = sc.next();
                    StudentProfile student = new StudentProfile(name,domain,address);

                    boolean valid = aa.add(student);
                    if(valid){
                        System.out.println("** Profile Added **");
                    }
                    else{
                        System.out.println("Hmm, that's not right, an error occurred, please try again");
                    }
                    break;
                case 2:
                    System.out.println("Display");
                    aa.display();
                    break;
                case 3:
                    System.out.println("Enter id");
                    int id = sc.nextInt();
                    boolean v = aa.DisplaybyID(id);
                    if (!v){
                        System.out.println("An entry with that ID doesn't exist, try again!");
                    }
                    break;
                case 4:
                    System.out.println("Enter ID to delete");
                    int i1 = sc.nextInt();
                    boolean d = aa.delete(i1);
                    if (d){
                        System.out.println("Record with ID: " + i1+ " has been deleted");
                    }
                    else{
                        System.out.println("Hmm, a record with that ID doesn't seem to exist, try again!");
                    }
                    break;
                case 5:
                    System.out.println("What do you want to update?" +"\n"+
                            "Press 1 to change Domain" + "\n"+
                            "Press 2 to change Address");
                    int i2 = sc.nextInt();
                    boolean u = false;
                    if (i2 == 1){
                        System.out.println("Enter the ID for the record you want to change the domain for");
                        int id1 = sc.nextInt();;
                        System.out.println("Enter new domain");
                        String dom = sc.next();
                        u = aa.update(i2,id1 ,dom);
                    }
                    if (i2 == 2){
                        System.out.println("Enter the ID for the record you want to change the domain for");
                        int id1 = sc.nextInt();;
                        System.out.println("Enter new address");
                        String dom = sc.next();
                        u = aa.update(i2,id1 ,dom);
                    }
                    else{
                        System.out.println("Do you see an option with the number "+i2+"? Do you? I don't think so! Try again!");
                        Thread.sleep(2500);
                        u = true;
                    }
                    if (u){
                        if (i2 == 1) {
                            System.out.println("********* Domain Updated ********");
                        }
                        if (i2 == 2){
                            System.out.println("********* Address Updated ********");
                        }

                    }
                    else{
                        System.out.println("Something went wrong, try again!");
                    }

                    break;
                case 6:
                    System.out.println("bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("you messed up!");
            }
        }
    }

}
