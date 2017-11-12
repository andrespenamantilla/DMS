/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datamarket.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.Stateless;

/**
 *
 * @author andre
 */
@Stateless
public class FechaConverter {

    public String parsearFecha() {

        String month = null;

        Date date = new Date();
        DateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        Calendar fecha = Calendar.getInstance();
        int year = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH) + 1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
        int segundo = fecha.get(Calendar.SECOND);

        if (mes == 1) {
            month = "Enero";
        }

        if (mes == 2) {
            month = "Febrero";
        }

        if (mes == 3) {
            month = "Marzo";
        }

        if (mes == 4) {
            month = "Abril";
        }

        if (mes == 5) {
            month = "Mayo";
        }

        if (mes == 6) {
            month = "Junio";
        }

        if (mes == 7) {
            month = "Julio";
        }

        if (mes == 8) {
            month = "Agosto";
        }

        if (mes == 9) {
            month = "Septiembre";
        }

        if (mes == 10) {
            month = "Octubre";
        }

        if (mes == 11) {
            month = "Noviembre";
        }

        if (mes == 12) {
            month = "Diciembre";
        }

        return month+" "+dia+" de"+" "+year;
    }

    public String anio()
    {
    Date date = new Date();
    Integer anio = date.getYear();
    return anio.toString();
    }
    
}
