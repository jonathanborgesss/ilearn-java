package com.mycompany.ilearn.View.Catalogo;

import com.mycompany.ilearn.View.Catalogo.Views.Catalogo;

public class CatalogoView {
    public CatalogoView(){
        Catalogo catalogo = new Catalogo();
        catalogo.buildCatalogo();
    }
    public static void main(String[] args) {
        new CatalogoView();

    }
}
