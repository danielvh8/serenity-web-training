package serenityswag.inventory;

public enum InventoryItem {

    BACKPACK("Sauce Labs Backpack", "sauce-labs-backpack"),
    BIKE_LIGHT("Sauce Labs Bike Light", "sauce-labs-bike-light"),
    BOLT_T_SHIRT("Sauce Labs Bolt T-Shirt", "sauce-labs-bolt-t-shirt"),
    FLEECE_JACKET("Sauce Labs Fleece Jacket", "sauce-labs-fleece-jacket"),
    ONESIE("Sauce Labs Onesie", "sauce-labs-onesie"),
    T_SHIRT_RED("Test.allTheThings() T-Shirt (Red)", "test.allthethings()-t-shirt-(red)");

    private final String name;
    private final String dataId;

    InventoryItem(String name, String dataId) {
        this.name = name;
        this.dataId = dataId;
    }

    public String getName() {
        return name;
    }

    public String getDataId() {
        return dataId;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
