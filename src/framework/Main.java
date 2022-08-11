package framework;

import framework.loading.Loader;

public class Main {
    public static void main(String[] args) {
        Loader.load();
        Engine.init();
    }
}
