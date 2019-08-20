package com.bfbmedu.seven.vip.customer_di;

public class Property {
    private String name;
    private String ref;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Property(String name, String ref) {
        this.name = name;
        this.ref = ref;
    }

    public Property() {
    }
}
