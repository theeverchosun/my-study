package B_Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
	private Model[] memberArray;
    private int memberCount;
    private final String FILE_PATH = "memberList.txt";

    public Controller(int capacity) {
        this.memberArray = new Model[capacity];
        this.memberCount = 0;
        loadFromFile(); // 프로그램 시작 시 데이터 로드
    }

    public void addMember(Model member) {
        if (memberCount >= memberArray.length) {
            System.out.println("⚠️ 정원이 가득 찼습니다.");
            return;
        }
        memberArray[memberCount] = member;
        memberCount++;
        saveToFile(); // 추가될 때마다 파일 저장
    }

    // View에게 데이터를 넘겨주기 위한 Getter 함수들
    public Model[] getMemberArray() { return memberArray; }
    public int getMemberCount() { return memberCount; }
    public int getCapacity() { return memberArray.length; }

    // 파일 저장 기능 (Controller가 전담)
    public void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (int i = 0; i < memberCount; i++) {
                Model m = memberArray[i];
                if (m != null) {
                    bw.write(String.format("%s,%s,%d,%.2f,%.2f\n", 
                            m.getName(), m.getGender(), m.getAge(), m.getHeight(), m.getWeight()));
                }
            }
        } catch (IOException e) {
            System.out.println("❌ 파일 저장 실패: " + e.getMessage());
        }
    }

    // 파일 로드 기능 (Controller가 전담)
    public void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] data = line.split(",");
                if (data.length < 5) continue;

                Model member = new Model(
                    data[0].trim(),
                    data[1].trim(),
                    Integer.parseInt(data[2].trim()),
                    Double.parseDouble(data[3].trim()),
                    Double.parseDouble(data[4].trim())
                );
                if (memberCount < memberArray.length) {
                    memberArray[memberCount] = member;
                    memberCount++;
                }
            }
        } catch (IOException e) {
            // 파일이 없을 때는 그냥 넘어감
        }
    }
}