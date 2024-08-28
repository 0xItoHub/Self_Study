Javaの`abstract`キーワードは、クラスやメソッドに適用され、**抽象的な（不完全な）概念を表現するために使われる**キーワードです。`abstract`は次の2つの場面で使用されます。

1. **抽象クラス (`abstract class`)**
2. **抽象メソッド (`abstract method`)**

### 抽象クラス (`abstract class`)
抽象クラスは、**インスタンス化できないクラス**であり、他のクラスによって継承されることを目的としています。抽象クラスは通常、具体的なメソッド（実装済みメソッド）と抽象メソッド（実装のないメソッド）の両方を含みます。

#### 特徴:
- 抽象クラスは**インスタンス化できません**。`new`キーワードを使って直接オブジェクトを作成することはできず、継承したサブクラスでインスタンス化します。
- 抽象クラスには、**抽象メソッド**（実装のないメソッド）を持つことができ、また、**具体的なメソッド**（実装済みのメソッド）も含めることができます。
- 抽象クラスを継承するクラスは、抽象クラス内のすべての抽象メソッドを**オーバーライドして実装**する必要があります。

### 抽象クラスの例
```java
// 抽象クラス
public abstract class Animal {
    // 抽象メソッド（実装がない）
    public abstract void makeSound();

    // 具体的なメソッド（実装済み）
    public void sleep() {
        System.out.println("The animal is sleeping");
    }
}

// 抽象クラスを継承する具体的なクラス
public class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}

// 使用例
public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();  // 抽象クラスのサブクラスのインスタンス化
        dog.makeSound();  // Bark
        dog.sleep();      // The animal is sleeping
    }
}
```

この例では、`Animal` は抽象クラスで、`makeSound` は抽象メソッドです。`Dog` クラスがこの抽象クラスを継承し、`makeSound` メソッドを実装しています。抽象クラス自体はインスタンス化できませんが、サブクラスである `Dog` はインスタンス化できます。

### 抽象メソッド (`abstract method`)
抽象メソッドは、**具体的な実装を持たないメソッド**で、メソッドのシグネチャのみが宣言されています。抽象メソッドを含むクラスは必ず抽象クラスである必要があり、抽象メソッドを持つクラスを継承するサブクラスは、その抽象メソッドを具体的に実装しなければなりません。

#### 特徴:
- 抽象メソッドは**メソッドの本体を持たず**、サブクラスで必ずオーバーライドされます。
- 抽象メソッドは、抽象クラス内にのみ定義されることができます。

### 抽象メソッドの例
```java
public abstract class Shape {
    // 抽象メソッド
    public abstract double calculateArea();
}

// 抽象クラスを継承する具体的なクラス
public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

// 使用例
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(5.0);  // サブクラスのインスタンス化
        System.out.println("Area: " + circle.calculateArea());  // 面積を計算
    }
}
```

この例では、`Shape` クラスが抽象クラスであり、`calculateArea` メソッドが抽象メソッドです。`Circle` クラスが `Shape` クラスを継承し、`calculateArea` メソッドを具体的に実装しています。

### 抽象クラス vs インターフェース
- **抽象クラス**は、部分的な実装を持ち、サブクラスがそれを継承して拡張する際に使われます。
- **インターフェース**は、すべてのメソッドが抽象的（Java 8以降はデフォルトメソッドもあり）で、クラスに特定の機能を「約束」させるために使います。

### まとめ
- `abstract`キーワードは、**クラスやメソッドが完全に実装されていないこと**を示すために使用されます。
- 抽象クラスは他のクラスによって継承され、抽象メソッドを具体的に実装します。
- 抽象クラスそのものはインスタンス化できませんが、そのサブクラスはインスタンス化可能です。
