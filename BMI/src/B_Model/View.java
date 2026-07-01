package B_Model;


import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
	private Controller controller; // 👈 Controller를 장착함
    private Scanner sc;

    public View(Controller controller) {
        this.controller = controller;
        this.sc = new Scanner(System.in);
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\n===== 헬스장 회원 관리 프로그램 =====");
            System.out.println("1. 회원 추가");
            System.out.println("2. 회원 목록");
            System.out.println("3. 특별관리 대상");
            System.out.println("0. 프로그램 종료");
            System.out.print("👉 메뉴 번호를 선택하세요: ");
            
            int menu = -1;
            try {
                menu = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("❌ 숫자로만 입력해주세요.");
                sc.nextLine();
                continue;
            }

            switch (menu) {
                case 1: addNewMemberMenu(); break;
                case 2: printAllMembers(); break;
                case 3: printSpecialCareMembers(); break;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    controller.saveToFile(); // 저장 명령만 컨트롤러에 내림
                    return;
                default:
                    System.out.println("❌ 없는 메뉴 번호입니다.");
            }
        }
    }

    private void addNewMemberMenu() {
        if (controller.getMemberCount() >= controller.getCapacity()) {
            System.out.println("⚠️ 헬스장 정원이 가득 찼습니다.");
            return;
        }

        System.out.println("\n--- [ 1. 회원 추가 모드 ] ---");
        System.out.print("이름을 입력하세요: ");
        String name = sc.next();

        String gender = "";
        while (true) {
            System.out.print("성별을 입력하세요 (남/여): ");
            gender = sc.next();
            if (gender.equals("남") || gender.equals("여") || gender.equals("남자") || gender.equals("여자")) break;
            System.out.println("❌ '남' 또는 '여'로 입력해주세요.");
        }

        int age = 0; double height = 0; double weight = 0;
        while (true) {
            try {
                System.out.print("나이를 입력하세요: "); age = sc.nextInt();
                System.out.print("키를 입력하세요 (cm 또는 m): "); height = sc.nextDouble();
                if (height >= 100.0) height /= 100.0;
                System.out.print("몸무게를 입력하세요 (kg): "); weight = sc.nextDouble();

                if (age <= 0 || height <= 0 || weight <= 0) {
                    System.out.println("❌ 0보다 큰 숫자를 입력하세요.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("❌ 숫자로만 입력해야 합니다.");
                sc.nextLine();
            }
        }

        // 데이터 뭉치를 만들어서 Controller에게 넘겨 저장 요청을 함
        Model member = new Model(name, gender, age, height, weight);
        controller.addMember(member); 
    }

    private void printAllMembers() {
        System.out.println("\n=============================================");
        System.out.println("📋  [전체 회원 목록]");
        System.out.println("=============================================");
        
        Model[] list = controller.getMemberArray();
        int count = controller.getMemberCount();

        if (count == 0) {
            System.out.println("등록된 회원이 없습니다.");
        } else {
            for (int i = 0; i < count; i++) {
                Model m = list[i];
                System.out.printf("%d. 이름: %s | 성별: %s | 나이: %d세 | 키: %.1fcm | 몸무게: %.1fkg (BMI: %.2f)\n", 
                        (i + 1), m.getName(), m.getGender(), m.getAge(), (m.getHeight() * 100), m.getWeight(), m.calculateBMI());
            }
        }
        System.out.println("=============================================");
    }

    private void printSpecialCareMembers() {
        System.out.println("\n=============================================");
        System.out.println("⚠️  [BMI 특별 관리 대상자 명단]");
        System.out.println("=============================================");
        
        Model[] list = controller.getMemberArray();
        int count = controller.getMemberCount();
        int careCount = 0;

        for (int i = 0; i < count; i++) {
            Model m = list[i];
            if (m != null && m.isRequiresSpecialCare()) {
                System.out.printf("- 이름: %s | 성별: %s | BMI: %.2f\n", m.getName(), m.getGender(), m.calculateBMI());
                careCount++;
            }
        }
        if (careCount == 0) System.out.println("특별 관리 대상 회원이 없습니다.");
        System.out.println("=============================================");
    }
}