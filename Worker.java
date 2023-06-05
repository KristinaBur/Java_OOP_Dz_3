
class Worker extends Employee {

    public Worker(String name, String surName, int age, double salary) {
        super(name, surName, age, salary);
    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s; Возраст: %d; Рабочий; Ср. з/п (фикс): %.2f (руб.)",
                name, surName, age, salary);
    }
}
