package com.devsuperiors.dslists.projections;


public interface GameMinProjection {
    //metodos get correspondentes a minha ocnsulta

    Long getId();
    String getTitle();
    Integer getYear();
    String getImgUrl();
    String getShortDescription();
    Integer getPosition();

}
