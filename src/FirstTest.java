import java.util.Scanner;

/**인터페이스 기반의 상수표현**/
interface INIT_MENU{
    int INPUT=1, SEARCH=2, DELETE=3, EXIT=4;
}
interface INPUT_SELECT{
    int NORMAL=1, UNIV=2, COMPANY=3;
}

/**전화번호 정보 저장하는 부분 **/
class PhoneInfo{
    String name;
    String phoneNumber;

    public PhoneInfo(String name, String phoneNumber, String birthday){
        this.name = name;
        this.phoneNumber = phoneNumber;

    }
    public PhoneInfo(String name, String phoneNumber){
        this(name, phoneNumber, null);
    }
    public void showPhoneInfo(){
        System.out.println("이름 : "+name);
        System.out.println("폰번호 : "+phoneNumber);
    }

} //birthday 부분 삭제

class PhoneUnivInfo extends PhoneInfo{
    String major;
    int year;

    public PhoneUnivInfo(String name, String phoneNumber, String major, int year) {
        super(name, phoneNumber);
        this.major = major;
        this.year = year;
    }

    public void showPhoneInfo(){
        super.showPhoneInfo();
        System.out.println("major : "+major);
        System.out.println("year : "+year);
    }
}

class PhoneCompanyInfo extends PhoneInfo{
    String company;

    public PhoneCompanyInfo(String name, String phoneNumber, String company){
        super(name, phoneNumber);
        this.company = company;
    }

    public void showPhoneInfo(){
        super.showPhoneInfo();
        System.out.println("company : "+company);
    }

}

class PhoneBookManager{
    public static Scanner sc = new Scanner(System.in);
    final int MAX_CNT = 100;
    PhoneInfo[] infoArrays = new PhoneInfo[MAX_CNT];
    int curCNT=0;

    private PhoneBookManager(){}

    static PhoneBookManager inst = null;
    public static PhoneBookManager createManagerInst(){
        if(inst ==null)
            inst = new PhoneBookManager();
        return inst;
    }

    /**PhoneInfo 인스턴스 참조 값 반환**/
    private PhoneInfo readFriendInfo(){
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("전화번호 : ");
        String phone = sc.nextLine();
        return new PhoneInfo(name, phone);
    }

    private PhoneInfo readUnivFriendInfo(){
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("전화번호 : ");
        String phone = sc.nextLine();
        System.out.print("전공 : ");
        String major = sc.nextLine();
        System.out.print("학년 : ");
        int year = sc.nextInt();
        sc.nextLine(); //Int 다음 엔터를 다음에서 인식하므로 없애준다.
        return new PhoneUnivInfo(name, phone, major, year);

    }

    private PhoneInfo readCompanyFriendInfo(){
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("전화번호 : ");
        String phone = sc.nextLine();
        System.out.print("회사 : ");
        String company = sc.nextLine();
        return new PhoneCompanyInfo(name, phone, company);

    }

    public void inputData(){
        System.out.println("데이터 입력을 시작합니다..");
        System.out.println("1. 일반, 2. 대학, 3. 회사");
        System.out.print("선택 >> ");
        int choice = sc.nextInt();
        sc.nextLine();
        PhoneInfo info = null;

        switch (choice){
            case INPUT_SELECT.NORMAL:
                info = readFriendInfo();
                break;
            case INPUT_SELECT.UNIV:
                info = readUnivFriendInfo();
                break;
            case INPUT_SELECT.COMPANY:
                info = readCompanyFriendInfo();
                break;
        }

        infoArrays[curCNT++] = info; // 4번째 수정으로 바뀐 부분
        System.out.println("데이터 입력이 완료되었습니다. \n");
    }

    public void searchData(){
        System.out.println("데이터 검색을 시작합니다..");

        System.out.print("이름 : ");
        String name = sc.nextLine();
        int index = search(name);
        if(index < 0){
            System.out.println("해당하는 데이터가 존재하지 않습니다.\n");
        }
        else{
            infoArrays[index].showPhoneInfo();
            System.out.println("데이터 검색이 완료되었습니다.\n");
        }
    }


    public void deleteData(){
        System.out.println("데이터 삭제를 시작합니다..");

        System.out.print("이름 : ");
        String name = sc.nextLine();

        int index = search(name);

        /**해당 데이터 없이 한칸씩 당기기**/
        if(index < 0){
            System.out.println("해당 데이터가 존재하지 않습니다.\n");
        }
        else{
            for(int i = index; i<(curCNT-1); i++ ){ // 맨끝에 하나 없으니 -1
                infoArrays[i]=infoArrays[i+1];
            }
            curCNT --; //삭제 후 맨 끝 자리 삭제
            System.out.println("데이터 삭제가 완료되었습니다\n");
        }

    }

    /**이름을 통해 위치 찾는 메소드**/
    private int search(String name){
        for(int i=0; i<curCNT; i++){
            PhoneInfo Info = infoArrays[i];
            if(name.equals(Info.name)){ //compareTo == 0 이용해도 된다.
                return i;
            }
        }
        return -1;
    }

}

class MenuViewer{
    public static void showMenu(){
        System.out.println("선택하세요...");
        System.out.println("1. 데이터 입력");
        System.out.println("2. 데이터 검색");
        System.out.println("3. 데이터 삭제");
        System.out.println("4. 프로그램 종료");
        System.out.print("선택 : ");
    }
}



public class FirstTest{

    public static void main(String[] args){
        PhoneBookManager manager =PhoneBookManager.createManagerInst();
        int choice;

        while(true){
            MenuViewer.showMenu();
            choice = PhoneBookManager.sc.nextInt();
            PhoneBookManager.sc.nextLine();

            switch(choice){
                case INIT_MENU.INPUT:
                    manager.inputData();
                    break;
                case INIT_MENU.SEARCH:
                    manager.searchData();
                    break;
                case INIT_MENU.DELETE:
                    manager.deleteData();
                    break;
                case INIT_MENU.EXIT:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }


    }
}