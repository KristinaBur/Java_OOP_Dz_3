public abstract class Employee implements Comparable<Employee> {

    protected String name;
    protected String surName;
    protected int age;
    protected double salary; // Ставка заработной платы

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surName;
    }

    public double getSalary() {
        return salary;
    }

    public int age() {
        return age;
    }

    public Employee(String name, String surName, int age, double salary) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.salary = salary;
    }

    /**
     * Расчет среднемесячной заработной платы
     * @return
     */
    public abstract double calculateSalary();

    @Override
    public int compareTo(Employee o) {
        int res = name.compareTo(o.name);
        if (res == 0){
            return Double.compare(calculateSalary(), o.calculateSalary());
        }
        return res;
    }
}