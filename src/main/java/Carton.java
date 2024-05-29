
import java.util.ArrayList;
import java.util.List;

public class Carton<T extends Item> extends Item {

    final int cartonHeight;
    private TypeOfCarton cartonType;
    private int usedCartonHeight = 0;
    private List<T> objectsList;

    public Carton(int cartonHeight, TypeOfCarton cartonType) {
        this.cartonHeight = cartonHeight;
        this.cartonType = cartonType;
        this.objectsList = new ArrayList<>();
    }

    public String addObject(T objectToAdd) {
        if (objectToAdd instanceof Carton || objectToAdd.getTypeOfCarton() == TypeOfCarton.Carton) {
            if (usedCartonHeight + objectToAdd.getSize() <= cartonHeight) {
                objectsList.add(objectToAdd);

                for (T item : ((Carton<T>) objectToAdd).getList()) {
                    objectsList.add(item);
                }
                usedCartonHeight += objectToAdd.getSize();
                setCartonType(TypeOfCarton.Carton);
                System.out.println("case 1");
                return "Done";
            } else {
                System.out.println("case 2");
                return "Can't add the " + objectToAdd.getClass() + ", not enough space";
            }
        } else if (objectToAdd.getTypeOfCarton() == this.cartonType) {
            if (usedCartonHeight + objectToAdd.getSize() <= cartonHeight) {
                objectsList.add(objectToAdd);
                usedCartonHeight += objectToAdd.getSize();
                System.out.println("case 3");
                return "Done";
            } else {
                System.out.println("case 4");
                return "Can't add the " + objectToAdd.getClass() + ", not enough space";
            }
        } else {
            System.out.println("case 5");
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

    public int getSize() {
        return this.usedCartonHeight;
    }

    public TypeOfCarton getCartonType() {
        return this.cartonType;
    }

    public void printAllObjects() {
        objectsList.forEach(object -> System.out.println(object));
    }

    public List<T> getList() {
        return objectsList;
    }

    public void setCartonType(TypeOfCarton inputType) {
        this.cartonType = inputType;
    }

    @Override
    public String toString() {
        System.out.println(getNumberOfObjectsInList() + " : " + getUsedCartonHeight());
        return String.format("The Carton has %d objects and the height used is %d", getNumberOfObjectsInList(), getUsedCartonHeight());
    }
}
