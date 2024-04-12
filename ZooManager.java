/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ZooManager {
    private List<Animal> animals;

    public ZooManager() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public void simulateZoo() {
        for (Animal animal : animals) {
            System.out.println("\n" + animal.getName() + ":");
            animal.makeSound();
            animal.eat();
            animal.sleep();
        }
    }

    public static void main(String[] args) {
        ZooManager zoo = new ZooManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Zoo Manager!");

        // Prompt user to add animals interactively
        while (true) {
            System.out.println("\nAdd a new animal to the zoo:");
            System.out.print("Enter animal type (Mammal/Bird/Reptile/Fish): ");
            String type = scanner.next();
            System.out.print("Enter animal name: ");
            String name = scanner.next();
            System.out.print("Enter animal age: ");
            int age = scanner.nextInt();
            System.out.print("Enter animal weight: ");
            double weight = scanner.nextDouble();

            Animal animal = null;
            switch (type.toLowerCase()) {
                case "mammal":
                    animal = new Mammal(name, age, weight);
                    break;
                case "bird":
                    animal = new Bird(name, age, weight);
                    break;
                case "reptile":
                    animal = new Reptile(name, age, weight);
                    break;
                case "fish":
                    animal = new Fish(name, age, weight);
                    break;
                default:
                    System.out.println("Invalid animal type. Please try again.");
                    continue;
            }

            zoo.addAnimal(animal);

            System.out.print("Add another animal? (yes/no): ");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes")) {
                break;
            }
        }

        // Simulate the zoo after adding animals
        System.out.println("\nZoo...");
        zoo.simulateZoo();

        scanner.close();
    }
}

abstract class Animal {
    protected String name;
    protected int age;
    protected double weight;

    public Animal(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void makeSound();
    public abstract void eat();
    public abstract void sleep();

    // Getters and setters for attributes
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

class Mammal extends Animal {
    public Mammal(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }

    @Override
    public void eat() {
        System.out.println(name + " is eating.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

class Bird extends Animal {
    public Bird(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " chirps.");
    }

    @Override
    public void eat() {
        System.out.println(name + " eats seeds.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " sleeps in a nest.");
    }
}

class Reptile extends Animal {
    public Reptile(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " hisses.");
    }

    @Override
    public void eat() {
        System.out.println(name + " eats insects.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " rests on rocks.");
    }
}

class Fish extends Animal {
    public Fish(String name, int age, double weight) {
        super(name, age, weight);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " makes bubbles.");
    }

    @Override
    public void eat() {
        System.out.println(name + " eats plankton.");
    }

    @Override
    public void sleep() {
        System.out.println(name + " rests in water.");
    }
}