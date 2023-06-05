
// TODO: Спроектировать класс Freelancer самостоятельно в рамках домашнего задания

class Freelancer extends Employee {

    protected int orders;

    public Freelancer(String name, String surName, int age, double salary, int orders) {
        super(name, surName, age, salary);
        this.orders = orders;

    }

    @Override
    public double calculateSalary() {
        return orders * salary;
    }

    @Override
    public String toString() {
        return String.format(
                "%s %s Возраст: %d; Фрилансер; З.п. (кол-во зак-ов в мес. (%d шт.) * ставку за зак.): %.2f (руб.)",
                name, surName, age, orders, salary * orders);
    }
}