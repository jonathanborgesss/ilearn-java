package com.mycompany.ilearn.View.Catalogo;

import com.mycompany.ilearn.View.Catalogo.Views.Catalogo;

public class CatalogoView {
    public CatalogoView(){

    }
    public static void main(String[] args) {
        new CatalogoView();
        Catalogo catalogo = new Catalogo();
        catalogo.buildCatalogo();
    }
}
