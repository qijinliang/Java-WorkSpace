package Leetcode.栈和队列.设计一个最小栈.猫狗队列;

/** 实现要求
 *  1. 用户可以调用add方法将cat类或dog类的实例放入队列中
 *  2. 用户可以调用pollAll方法，将队列中所有的实例按照队列的先后顺序依次弹出；
 *  3. 用户可以调用pollDog方法，将队列中dog类的实例按照队列的先后顺序依次弹出；
 *  4. 用户可以调用pollCat方法，将队列中cat类的实例按照队列的先后顺序依次弹出；
 *  5. 用户可以调用isEmpty方法，检查队列中是否还有dog和cat的实例；
 *  6. 用户可以调用isDogEmpty方法，检查队列中是否还有do的实例；
 *  7. 用户可以调用isCatEmpty方法，检查队列中是否还有cat的实例。
 * */

public class Pet {
    private String type;

    public Pet(String type) {
        this.type = type;
    }
    public String getPetType() {
        return this.type;
    }
}

class Dog extends Pet {

    public Dog() {
        super("dog");
    }
}

class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}
