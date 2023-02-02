# java_Study
전화번호 관리 프로그램을 배우는 단계에 따라 추가해보기

두 번째 수정 -> 프로그램 사용자로부터 데이터 입력 받기

세 번째 수정 -> 사용자가 입력하는 정보를 최대 100개까지 바꾸고 
저장하고 검색하고 삭제 할 수 있는 기능을 넣는다. (배열의 중간에 저장된 데이터 삭제할 경우 뒤에 저장된 요소들을 한 칸씩 앞으로 이동)
기능 담당 클래스를 PhoneBookManager로 한다.

main 클래스 안에 두었던 것을 MenuViewer로 빼두었다.

네 번째 수정 -> birth 변수 삭제, PhoneUnivInfo, PhoneCompanyInfo 추가하여 대학 및 회사 정보 입력 받고 출력
이전에는 inputdata에서 inforStorage 배열에 바로 인스턴스 생성해 정보 넣었다면 이제는 info 라는 참조변수 만들고 초기화 시키고 다른 메소드 통해서 인스턴스 생성하여
정보를 넣어준다.

다섯 번째 수정 -> 코드 구성 보다 좋은 형태로 변경
Manager 클래스의 인스턴스 수가 하나 넘지 않도록 구성할 것이다.
메뉴에 대한 정보가 이름이 부여된 상수가 아닌 숫자로 처리되는데 interface 기반의 상수표현을
바탕으로 메뉴 선택과 그에 따른 처리가 부여된 상수를 기반으로 진행되게 변경한다.

추가된 인터페이스 - INIT_MENU, INPUT_SELECT

static PhoneBookManager inst = null;
public static PhoneBookManager createManagerInst(){
if(inst ==null)
inst = new PhoneBookManager();
return inst;
}

이 부분과 main의 인스턴스 생성 부분이 변경 되었다 (인스턴스 하나만 생성 위해)
메소드를 통해 인스턴스 생성하는데 null이면 생성하도록 한다.
