package il.co.grauman.kindergarten.bl.reports.reportsModles;

public class Child {
    String childID , name , parent1 , parent2 , description;
    Byte [] image;

    public Child(String childID, String name, String parent1, String parent2, String description, Byte[] image) {
        this.childID = childID;
        this.name = name;
        this.parent1 = parent1;
        this.parent2 = parent2;
        this.description = description;
        this.image = image;
    }

    public String getChildID() {
        return childID;
    }

    public void setChildID(String childID) {
        this.childID = childID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent1() {
        return parent1;
    }

    public void setParent1(String parent1) {
        this.parent1 = parent1;
    }

    public String getParent2() {
        return parent2;
    }

    public void setParent2(String parent2) {
        this.parent2 = parent2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }
}
