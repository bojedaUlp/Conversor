package com.example.conversor;

import android.widget.EditText;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    private boolean dol,eur;
    private MutableLiveData<String> resultado;
    private MutableLiveData<Boolean> dolar;
    private MutableLiveData<Boolean>euro;
    private MutableLiveData<String> etD;
    private MutableLiveData<String> etE;


    public LiveData<String> getResultado(){
        if(resultado==null){
            resultado= new MutableLiveData<String>();
        }
        return resultado;
    }

    public LiveData<Boolean> getDolar(){
        if(dolar==null){
            dolar= new MutableLiveData<Boolean>();
        }
        return dolar;
    }

    public LiveData<Boolean> getEuro(){

        if(euro==null){
            euro= new MutableLiveData<Boolean>();
        }
        return euro;
    }

    public LiveData<String> getEtD(){
        if(etD==null){
            etD= new MutableLiveData<String>();
        }
        return etD;
    }

    public LiveData<String> getEtE(){
        if(etE==null){
            etE= new MutableLiveData<String>();
        }
        return etE;
    }



    public void cambiarEstadoDolar(){
        dolar.setValue(false);
        eur=false;
        dol=true;
    }

    public void cambiarEstadoEuro(){
        dol=false;
        eur=true;
        euro.setValue(false);
    }

    public void habilitarEt(EditText e){
        e.setEnabled(false);
        e.setText("");
    };
    public void  deshabilitarEt(EditText e){
        e.setEnabled(true);
        e.setText("");
    }

    public void convertir(String d,String e){

        double con,res=0.0;

           try{
               if( dol==true && !d.isEmpty()){
                   con=Double.parseDouble(d);
                   res=con*0.925272;
                   resultado.setValue(res+"");
               }else if(eur && !e.isEmpty()){

                        con=Double.parseDouble(e);
                        res=con*1.0807;
                        resultado.setValue(res+"");
               }
           }catch(NumberFormatException ex){
               resultado.setValue("Ingrese numero valido");
           }

    }

}
