import java.util.ArrayList;

public class Quote_test {
    public static void main(String[] args) throws CloneNotSupportedException {
        /*ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        list2=list1;
        list2.add(2);
        list1.forEach(item -> System.out.println(item));
        list2.forEach(item -> System.out.println(item));*/

        people tom = new people("Tom", 21);
        people p = (people) tom.clone();
//        people=tom;                         //对象赋值是
        tom.setAge(2);
        System.out.println(tom.toString());
        System.out.println(p.toString());
        System.out.println(tom.hashCode());
        System.out.println(p.hashCode());
        System.out.println(p.equals(tom));

    }
}
class people implements Cloneable{
    private String name;
    private int age;

    public people() {
    }

    public people(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "people{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}