
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
    public static void main(String[] args){
        PhoneInfo person1 = new PhoneInfo("차은우","111-1111","97.02.22");
        PhoneInfo person2 = new PhoneInfo("김은우","111-2222");
        person1.showPhoneInfo();
        person2.showPhoneInfo();

    }
}