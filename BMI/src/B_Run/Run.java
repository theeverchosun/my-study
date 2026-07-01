package B_Run;

import B_Model.Controller;
import B_Model.View;

public class Run {

	public static void main(String[] args) {
Controller controller = new Controller(10);
        
        // 2. 화면 출력을 담당하는 View를 만들고, 생성자로 controller를 연결해줍니다.
        View view = new View(controller);
        
        // 3. 프로그램 메뉴 시작!
        view.mainMenu(); 
    }
}