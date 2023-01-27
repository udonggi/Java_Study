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

class PhoneBookManager{
    public static Scanner sc = new Scanner(System.in);
    final int MAX_CNT = 100;
    PhoneInfo[] infoArrays = new PhoneInfo[MAX_CNT];
    int curCNT=0;

    public void inputData(){
        System.out.println("데이터 입력을 시작합니다..");
        System.out.print("이름 : ");
        String name = sc.nextLine();
        System.out.print("전화번호 : ");
        String phone = sc.nextLine();
        System.out.print("생년월일 : ");
        String birth = sc.nextLine();

        infoArrays[curCNT++] = new PhoneInfo(name, phone, birth);
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
            if(name.compareTo(Info.name)==0){
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
        PhoneBookManager manager = new PhoneBookManager();
        int choice;

        while(true){
            MenuViewer.showMenu();
            choice = PhoneBookManager.sc.nextInt();
            PhoneBookManager.sc.nextLine();

            switch(choice){
                case 1:
                    manager.inputData();
                    break;
                case 2:
                    manager.searchData();
                    break;
                case 3:
                    manager.deleteData();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
            }
        }


    }
}