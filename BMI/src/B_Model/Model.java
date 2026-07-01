package B_Model;

public class Model {
	
	private String name;
    private String gender;
    private int age;
    private double height;
    private double weight;

    public Model() {}

    public Model(String name, String gender, int age, double height, double weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    // BMI 계산 로직 (Model의 역할)
    public double calculateBMI() {
        if (height <= 0) return 0;
        return weight / (height * height);
    }

    // 특별 관리 대상 판정 로직 (Model의 역할)
    public boolean isRequiresSpecialCare() {
        double bmi = calculateBMI();
        if (gender.equals("남") || gender.equals("남자")) {
            return bmi >= 25.0 || bmi < 18.5;
        } else if (gender.equals("여") || gender.equals("여자")) {
            return bmi >= 24.0 || bmi < 18.5;
        }
        return false;
    }

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

   

}
