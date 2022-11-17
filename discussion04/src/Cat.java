public class Cat extends Animal{
    public Cat(String name, int age) {
        super(name, age);
        this.noise = "Meow!";
    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }

    public static void main(String[] args) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        a.greet();
        c.greet();
        a = c;
        ((Cat) a).greet();
        a.greet();

        Dog d = new Dog("d", 19);
        d.greet();
        a = new Dog("Spot", 10);

    }
}
