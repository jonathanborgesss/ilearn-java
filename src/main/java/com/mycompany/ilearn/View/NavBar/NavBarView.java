package com.mycompany.ilearn.View.NavBar;

import com.mycompany.ilearn.View.Catalogo.CatalogoView;
import com.mycompany.ilearn.View.NavBar.Views.*;

public class NavBarView {
    public void handleView(String call){
        switch (call){
            case "About":
                NavBar.About();
                break;
            case "Contact":
                NavBar.Contact();
                break;
            case "Faq":
                NavBar.Faq();
                break;
            case "Resources":
                NavBar.Resources();
                break;
            case "Solutions":
                NavBar.Solutions();
                break;
            case "Catalogo":
                new CatalogoView();
                break;
            default:
                NavBar.About();
                break;
        }

    }
    public NavBarView(String call){
        handleView(call);
    }
    public static void main(String[] args) {
        new NavBarView("About");
    }
}
