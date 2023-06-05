import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Program {

    /**
     * TODO: Переработать метод generateEmployee в рамках домашнего задания,
     *  метод должен генерировать рабочих (Employee) разных типов.
    */
    // static Worker generateEmployee(){
    //     String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    //     String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов", "Горбунов", "Лыткин", "Соколов" };

    //     int salary = random.nextInt(20000, 80000);
    //     return new Worker(names[random.nextInt(2)], surnames[random.nextInt(surnames.length)], salary);
    // }

    static Employee generateEmployee() {
        String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий",
                "Рубен", "Герман" };
        String[] surnames = new String[] { "Григорьев", "Фокин", "Шестаков", "Хохлов", "Шубин", "Бирюков", "Копылов",
                "Горбунов", "Лыткин", "Соколов" };

        Random random = new Random();
        int index = random.nextInt(1, 3);
        int age = random.nextInt(21, 45);
        int workerSalary = random.nextInt(50, 100) * 1000;
        int freelancerSalary = random.nextInt(1, 5) * 1000;
        int freelancerOrders = random.nextInt(4, 9);

        if (index % 2 == 0) {
            return new Freelancer(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], age,
                    freelancerSalary, freelancerOrders);
        }
        return new Worker(names[random.nextInt(names.length)], surnames[random.nextInt(surnames.length)], age,
                workerSalary);
    }


    /**
     * TODO: Придумать новые состояния для наших сотрудников
     *   Придумать несколько Comparator'ов для сортировки сотрудников
     *   по фамилии + имени или по возрасту + уровню зп.
     * @param args
     */
    public static void main(String[] args) {

        // Worker worker = new Worker("Анатолий", "Шестаков", 35, 80000);
        // System.out.println(worker);

        System.out.printf("\n*** Сотрудники ***\n\n");
        Employee[] employees = new Employee[10];
        for (int i = 0; i < employees.length; i++)
            employees[i] = generateEmployee();

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Arrays.sort(employees, new NameComparator());
        Arrays.sort(employees, new SalaryComparator());

        System.out.printf("\n*** Отсортированный по з/п массив сотрудников ***\n\n");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees, new AgeComporator());

        System.out.printf("\n*** Отсортированный по возрасту массив сотрудников ***\n\n");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

        Arrays.sort(employees, new SurnameComparator());

        System.out.printf("\n*** Отсортированный по фамилии массив сотрудников ***\n\n");

        for (Employee employee : employees) {
            System.out.println(employee);
        }

    }

}

class AgeComporator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2){
        return Integer.compare(o1.age, o2.age);
    }
}

// class SalaryComparator implements Comparator<Employee> {

//     @Override
//     public int compare(Employee o1, Employee o2) {

//         // return o1.calculateSalary() == o2.calculateSalary() ? 0 :
//         // (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
//         return Double.compare(o2.calculateSalary(), o1.calculateSalary());
//     }
// }

class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        // return o1.calculateSalary() == o2.calculateSalary() ? 0 :
        // (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
        int res = o1.name.compareTo(o2.name);
        if (res == 0) {
            res = Double.compare(o2.calculateSalary(), o1.calculateSalary());
        }
        return res;
    }
}

class SurnameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        // return o1.calculateSalary() == o2.calculateSalary() ? 0 :
        // (o1.calculateSalary() > o2.calculateSalary() ? 1 : -1);
        int res = o1.surName.compareTo(o2.surName);
        if (res == 0) {
            res = Double.compare(o2.calculateSalary(), o1.calculateSalary());
        }
        return res;
    }
}
