package com.example.login.services;

import com.example.login.models.EntradaData;
import com.example.login.models.TablaData;
import com.example.login.models.caja;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CajaService {


    public List<TablaData> calcularCaja(EntradaData entradaData){

        entradaData.calcularData();


        caja[] arregloCajas = new caja[(((int)entradaData.tiempo_total)+1)];

        for (int i = 0; i < arregloCajas.length; i++) {
            arregloCajas[i] = new caja();
        }

        for (int i = 0; i < arregloCajas.length; i++) {
            if (i == 0) {
                arregloCajas[i].cajaPosterior = arregloCajas[i + 1];
            }
            if (i > 0 && i < arregloCajas.length-1) {
                arregloCajas[i].cajaAnterior = arregloCajas[i - 1];
                arregloCajas[i].cajaPosterior = arregloCajas[i + 1];
            }
            if (i == arregloCajas.length-1) {
                arregloCajas[i].cajaAnterior = arregloCajas[i - 1];
            }

            arregloCajas[i].entradaData = entradaData;
        }

        List<TablaData> tabladatalist= new ArrayList<>();

        for (int i = 0; i < arregloCajas.length; i++) {

            caja cajaActual = arregloCajas[i];

            TablaData tablaData = new TablaData();
            tablaData.setPeriodo(i);
            tablaData.setFco(cajaActual.calcularFCO(i));
            tablaData.setVu(cajaActual.calcularVu(i));
            tablaData.setDeuda(cajaActual.calcularDeuda(i));
            tablaData.setAl(cajaActual.calcularAl(i));
            tablaData.setVal(cajaActual.calcularVal(i));
            tablaData.setVl(cajaActual.calcularVl(i));
            tablaData.setKd(cajaActual.calcularKd(i));
            tablaData.setKu(cajaActual.calcularKu(i));
            tablaData.setXt(cajaActual.calcularXt(i));
            tablaData.setE(cajaActual.calcularE(i));
            tablaData.setDe(cajaActual.calcularDE());
            tablaData.setKe(cajaActual.calcularKe(i));
            tablaData.setWacc(cajaActual.calcularWacc(i));
            tablaData.setWaccj(cajaActual.calcularWaccJ(i));
            tabladatalist.add(tablaData);


        }

        return tabladatalist;



    }


}
