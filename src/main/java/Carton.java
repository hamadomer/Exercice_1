
import java.util.ArrayList;
import java.util.List;

public class Carton<T extends Item> {

    private int cartonHeight;
    private TypeOfCarton cartonType;
    private int usedCartonHeight = 0;
    private List<T> objectsList;

    public Carton(int cartonHeight, TypeOfCarton cartonType) {
        this.cartonHeight = cartonHeight;
        this.cartonType = cartonType;
        this.objectsList = new ArrayList<>();
    }

    public String addObject(T objectToAdd) {
        if (objectToAdd.getTypeOfCarton() == cartonType) {
            if (usedCartonHeight + objectToAdd.getSize() <= cartonHeight) {
                objectsList.add(objectToAdd);
                usedCartonHeight += objectToAdd.getSize();
                return "Done";
            } else {
                return "Can't add the " + objectToAdd.getClass() + ", not enough space";
            }
        } else {
           return "Can't add the " + objectToAdd.getClass() + " to a carton of type " + cartonType;
        }
    }

    public void removeObject(T objectToRemove) {
        if (objectsList.remove(objectToRemove)) {
            usedCartonHeight -= objectToRemove.getSize();
        }
    }

    public int getNumberOfObjectsInList() {
        return objectsList.size();
    }

    public int getUsedCartonHeight() {
        return this.usedCartonHeight;
    }

    public TypeOfCarton getCartonType() {
        return this.cartonType;
    }

    public void printAllObjects() {
        objectsList.forEach(object -> System.out.println(object.getName()));
    }

    @Override
    public String toString() {
        return String.format("The Carton has %d objects and the height used is %d", getNumberOfObjectsInList(), usedCartonHeight);
    }
}
