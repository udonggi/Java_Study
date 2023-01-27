import java.util.Scanner;

/**전화번호 정보 저장하는 부분 **/
class PhoneInfo{
    String name;
    String phoneNumber;
    String birthday;

    public PhoneInfo(String name, String phoneNumber, String birthday){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }
    public PhoneInfo(String name, String phoneNumber){
        this(name, phoneNumber, null);
    }
    public void showPhoneInfo(){
        System.out.println("이름 : "+name);
        System.out.println("폰번호 : "+phoneNumber);
        if(birthday!=null){
            System.out.println("생년월일 : "+birthday);
        }
        System.out.println(""); //한칸 띄우기
    }

}



public class FirstTest{
    static Scanner sc = new Scanner(System.in);

    public static void showMenu(){
        System.out.println("1 입력 -> 데이터 입력");
        System.out.println("0 입력 -> 프로그램 종료");
        System.out.print("선택 : ");
    }

    public static void inputData(){
        System.out.print("이름 : ");
        String name = sc.nextLine();

        System.out.print("전화번호 : ");
        String phone = sc.nextLine();

        System.out.print("생년월일 : ");
        String birth = sc.nextLine();

        PhoneInfo info = new PhoneInfo(name, phone, birth);
        System.out.println("\n입력된 정보");
        info.showPhoneInfo();

    }
    public static void main(String[] args){
        int choice;
        while(true){
            showMenu();
            choice = sc.nextInt();
            sc.nextLine();

            if (choice ==1 ){
                inputData();
            }
            else if(choice == 0){
                System.out.println("프로그램 종료");
                return ;
            }
        }


    }
}