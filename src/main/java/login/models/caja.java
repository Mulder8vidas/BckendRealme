package com.example.login.models;

public class caja {

     public double fco;
     public double vu;
     public double deuda=0;
     public double al;
     public double vl;
     public double kd;
     public double ku;
     public double xt;
     public double e;
     public double de;
     public double ke;
     public double kacc;
     public double waccj;

     public caja cajaAnterior;

     public caja cajaPosterior;

     public EntradaData entradaData;


     public double calcularFCO(int posicionActual){
          if(posicionActual==0){
                return 0;
          }else{
               if(!(this.entradaData.tiempo_total>=posicionActual)){
                    return 0;
               }
               return this.entradaData.flujo_anual*(1+this.entradaData.crecimiento_anual)*1/this.entradaData.crecimiento_anual*this.entradaData.gm/
                       (1+this.entradaData.gm)*Math.pow((1+ entradaData.gm),posicionActual);
          }

     }
     public double calcularVu(int posicionActual){


          if(!(this.entradaData.tiempo_total>=(posicionActual+1))){
               return 0;
          }else{


               if(this.cajaPosterior==null){
                    return 0;
               }
             /*  if(posicionActual==0){
                    return (this.cajaPosterior.calcularVu(posicionActual+1)+this.cajaPosterior.calcularFCO(posicionActual+1))/(1+this.cajaPosterior.calcularKu(posicionActual+1));
               }*/

              /* if(this.vu==0){
                    this.vu=(this.cajaPosterior.calcularVu(posicionActual+1)+this.cajaPosterior.calcularFCO(posicionActual+1))/(1+this.cajaPosterior.calcularKu(posicionActual+1));;
               }
               return this.vu;*/

               return (this.cajaPosterior.calcularVu(posicionActual+1)+this.cajaPosterior.calcularFCO(posicionActual+1))/(1+this.cajaPosterior.calcularKu(posicionActual+1));
          }


     }

     public double calcularDeuda(int posicionActual){

          if(this.deuda==0){


               this.deuda=this.calcularE(posicionActual)*this.calcularDE();
          }
          return this.deuda;


     }
     public double calcularAl(int posicionActual){
          if(posicionActual==0){
               return 0;
          }else{
               if(!(this.entradaData.tiempo_total>=(posicionActual))){
                    return 0;
               }
               if(this.cajaAnterior==null){
                    return 0;
               }

               return this.cajaAnterior.calcularDeuda(posicionActual-1)*this.calcularKd(posicionActual)*this.entradaData.tasaimpuesto;
          }
     }

     public double calcularVal(int posicionActual){
          if(!(this.entradaData.tiempo_total>=(posicionActual+1))){
               return 0;
          }
          if(this.cajaPosterior==null){
               return 0;
          }

          return (this.cajaPosterior.calcularVal(posicionActual+1)+this.cajaPosterior.calcularAl(posicionActual+1))/(1+this.cajaPosterior.calcularXt(posicionActual+1));
     }

     public double calcularVl(int posicionActual){
          return this.calcularVal(posicionActual)+this.calcularVu(posicionActual);
     }

     public double calcularKd(int posicionActual){
          if(!(this.entradaData.tiempo_total>=(posicionActual))){
               return 0;
          }
          return this.entradaData.kdajuste;
     }
     public double calcularKu(int posicionActual){
          if(!(this.entradaData.tiempo_total>=(posicionActual))){
               return 0;
          }
          return this.entradaData.kuajuste;
     }
     public double calcularXt(int posicionActual){
          if(!(this.entradaData.tiempo_total>=(posicionActual))){
               return 0;
          }
          return this.entradaData.xtajuste;


     }

     public double calcularE(int posicionActual) {

          int posicionPosterior=posicionActual+1;

          if(this.cajaPosterior==null){
               return 0;
          }
    /*      if(this.e==0){
               this.e=(1+this.cajaPosterior.calcularXt(posicionPosterior)*this.calcularVu(posicionActual)+this.cajaPosterior.calcularVal(posicionPosterior))/
                       (1+this.cajaPosterior.calcularXt(posicionPosterior)+this.entradaData.yde-this.entradaData.yde*this.cajaPosterior.calcularKd(posicionPosterior)*this.entradaData.tasaimpuesto+this.entradaData.yde*this.cajaPosterior.calcularXt(posicionPosterior));;
          }
          return this.e;*/


          return ((this.calcularVu(posicionActual)+this.cajaPosterior.calcularVal(posicionPosterior)))/
                  (1+this.cajaPosterior.calcularXt(posicionPosterior)+this.entradaData.yde-this.entradaData.yde*this.cajaPosterior.calcularKd(posicionPosterior)*this.entradaData.tasaimpuesto+this.entradaData.yde*this.cajaPosterior.calcularXt(posicionPosterior));
     }


     public double calcularDE() {
          return this.entradaData.yde;
     }
     public double calcularKe(int posicionActual){
          int posicionPosterior=posicionActual+1;
          int posicionAnterior=posicionActual-1;
          if(!(this.entradaData.tiempo_total>=(posicionActual))){
               return 0;
          }

          if(this.cajaAnterior==null){
               return 0;
          }
          if(this.ke==0){
               this.ke=this.calcularKu(posicionActual)+(this.calcularKu(posicionActual)-this.calcularKd(posicionActual))*this.cajaAnterior.calcularDeuda(posicionAnterior)/this.cajaAnterior.calcularE(posicionAnterior)-
                       (this.calcularKu(posicionActual)-this.calcularXt(posicionActual))*this.cajaAnterior.calcularVal(posicionAnterior)/this.cajaAnterior.calcularE(posicionAnterior);
          }


          return this.ke;
     }

     public double calcularWacc(int posicionActual){
          int posicionPosterior=posicionActual+1;
          int posicionAnterior=posicionActual-1;
          if(posicionActual==0){
               return 0;
          }
          if(!(this.entradaData.tiempo_total>=(posicionActual))){
               return 0;
          }
          if(this.cajaAnterior==null){
               return 0;
          }

          return this.cajaAnterior.calcularE(posicionAnterior)/this.cajaAnterior.calcularVl(posicionAnterior)*this.calcularKe(posicionActual)+this.cajaAnterior.calcularDeuda(posicionAnterior)/
                  this.cajaAnterior.calcularVl(posicionAnterior)*this.calcularKd(posicionActual)-this.calcularAl(posicionActual)/this.cajaAnterior.calcularVl(posicionAnterior);

     }
     public double calcularWaccJ(int posicionActual){
          int posicionPosterior=posicionActual+1;
          int posicionAnterior=posicionActual-1;
          if(posicionActual==0){
               return 0;
          }
          if(!(this.entradaData.tiempo_total>=(posicionActual))){
               return 0;
          }
          if(this.cajaAnterior==null){
               return 0;
          }

          return 1/(1+this.calcularDE())*this.calcularKe(posicionActual)+this.calcularDE()/(1+this.calcularDE())*this.calcularKd(posicionActual)*(1-this.entradaData.tasaimpuesto);
     }

     public double subTotalCaja(int posicionActual){
          int posicionPosterior=posicionActual+1;
          int posicionAnterior=posicionActual-1;
          if(!(this.entradaData.tiempo_total>=(posicionActual+1))){
               return 0;
          }
          if(this.cajaPosterior==null){
               return 0;
          }
          return (this.cajaPosterior.subTotalCaja(posicionPosterior)+this.cajaPosterior.calcularFCO(posicionPosterior))/(1+this.cajaPosterior.calcularWacc(posicionPosterior));
     }


     @Override
     public String toString() {
          return this.cajaPosterior==null ? "No tiene caja" : "Tiene caja";
     }
}
