class Student {
    private static int count = 0;
    private int id;
    private String name;
    private String className;
    private float math;
    private float physics;
    private float chemistry;

    public Student() {
        count++;
        id = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getPhysics() {
        return physics;
    }

    public void setPhysics(float physics) {
        this.physics = physics;
    }

    public float getChemistry() {
        return chemistry;
    }

    public void setChemistry(float chemistry) {
        this.chemistry = chemistry;
    }

    public void display() {
        float average = (math + physics + chemistry) / 3;
        System.out.println("Name: " + name);
        System.out.println("Class: " + className);
        System.out.println("Average Mark: " + average);
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", this.id, this.name, this.math, this.chemistry, this.physics);
    }
}


