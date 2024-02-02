package unimet.saman_productions;

import unimet.saman_productions.studios.CartoonNetwork;
import unimet.saman_productions.studios.Studio;

public class Main {
    public static void main(String[] args) {
        Studio cartoonNetwork = new CartoonNetwork(4);
        cartoonNetwork.start();
    }
}