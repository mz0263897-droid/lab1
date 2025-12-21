package Bilanyn.Roman.KI_305;

import java.io.FileNotFoundException;

public class CatApp {

    public static void main(String[] args) throws FileNotFoundException {

        Cat testCat = new Cat("Кузя", 7, "чорно-білий");

        testCat.voice();
        testCat.eat("Віскас");
        testCat.sleep(12);
        testCat.play();
        testCat.moveTail("вліво-вправо");
        testCat.scratch();
        testCat.biteOwner();
        testCat.catchMouse();
        testCat.doExperiment();
        testCat.showInfo();

        System.out.println("Усі експерименти виконано!");
        testCat.dispose();
    }
}
