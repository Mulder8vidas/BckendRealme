package com.example.login.models;

public class EntradaData {

    public double flujo_anual = 0;
    public double ku = 0;
    public double kd = 0;

    public double xt = 0;

    public double yde = 0;
    public double taños = 0;

    public double crecimiento_anual = 0;


    public double flujo_total=0;

    public double majustes=0;

    public double tiempo_total=0;

    public double gm=0;

    public double ym=0;

    public double kuajuste=0;
    public double kdajuste=0;
    public double xtajuste=0;
    public double tasaimpuesto=0;

    public double flujo_totales=0;

    public EntradaData() {

        /*this.flujo_total+=flujo_anual*(1+crecimiento_anual)*(Math.pow((1+crecimiento_anual),taños)-1)/(crecimiento_anual);
        this.tiempo_total+=majustes*taños;
        this.gm+=Math.pow((1+crecimiento_anual),(1/majustes))-1;
        this.ym+=this.gm/crecimiento_anual*Math.pow((1+this.gm),(this.majustes-1));
        this.flujo_totales=this.flujo_anual*this.ym*(1+this.gm)*(Math.pow((Math.pow((1+this.gm),this.majustes)),this.taños)-1)/this.gm;
        this.kuajuste+=Math.pow((1+this.ku),(1/this.majustes))-1;
        this.kdajuste+=Math.pow((1+this.kd),(1/this.majustes))-1;
        this.xtajuste+=this.kuajuste;
        System.out.println(this.toString());*/

    }

    public void calcularData(){
        this.flujo_total+=flujo_anual*(1+crecimiento_anual)*(Math.pow((1+crecimiento_anual),taños)-1)/(crecimiento_anual);
        this.tiempo_total+=majustes*taños;
        this.gm+=Math.pow((1+crecimiento_anual),(1/majustes))-1;
        this.ym+=this.gm/crecimiento_anual*Math.pow((1+this.gm),(this.majustes-1));
        this.flujo_totales=this.flujo_anual*this.ym*(1+this.gm)*(Math.pow((Math.pow((1+this.gm),this.majustes)),this.taños)-1)/this.gm;
        this.kuajuste+=Math.pow((1+this.ku),(1/this.majustes))-1;
        this.kdajuste+=Math.pow((1+this.kd),(1/this.majustes))-1;
        this.xtajuste+=this.kuajuste;
    }

    public double getFlujo_anual() {
        return flujo_anual;
    }

    public void setFlujo_anual(double flujo_anual) {
        this.flujo_anual = flujo_anual;
    }

    public double getKu() {
        return ku;
    }

    public void setKu(double ku) {
        this.ku = ku;
    }

    public double getKd() {
        return kd;
    }

    public void setKd(double kd) {
        this.kd = kd;
    }

    public double getXt() {
        return xt;
    }

    public void setXt(double xt) {
        this.xt = xt;
    }

    public double getYde() {
        return yde;
    }

    public void setYde(double yde) {
        this.yde = yde;
    }

    public double getTaños() {
        return taños;
    }

    public void setTaños(double taños) {
        this.taños = taños;
    }

    public double getCrecimiento_anual() {
        return crecimiento_anual;
    }

    public void setCrecimiento_anual(double crecimiento_anual) {
        this.crecimiento_anual = crecimiento_anual;
    }

    public double getFlujo_total() {
        return flujo_total;
    }

    public void setFlujo_total(double flujo_total) {
        this.flujo_total = flujo_total;
    }

    public double getMajustes() {
        return majustes;
    }

    public void setMajustes(double majustes) {
        this.majustes = majustes;
    }

    public double getTiempo_total() {
        return tiempo_total;
    }

    public void setTiempo_total(double tiempo_total) {
        this.tiempo_total = tiempo_total;
    }

    public double getGm() {
        return gm;
    }

    public void setGm(double gm) {
        this.gm = gm;
    }

    public double getYm() {
        return ym;
    }

    public void setYm(double ym) {
        this.ym = ym;
    }

    public double getKuajuste() {
        return kuajuste;
    }

    public void setKuajuste(double kuajuste) {
        this.kuajuste = kuajuste;
    }

    public double getKdajuste() {
        return kdajuste;
    }

    public void setKdajuste(double kdajuste) {
        this.kdajuste = kdajuste;
    }

    public double getXtajuste() {
        return xtajuste;
    }

    public void setXtajuste(double xtajuste) {
        this.xtajuste = xtajuste;
    }

    public double getTasaimpuesto() {
        return tasaimpuesto;
    }

    public void setTasaimpuesto(double tasaimpuesto) {
        this.tasaimpuesto = tasaimpuesto;
    }

    public double getFlujo_totales() {
        return flujo_totales;
    }

    public void setFlujo_totales(double flujo_totales) {
        this.flujo_totales = flujo_totales;
    }
}
