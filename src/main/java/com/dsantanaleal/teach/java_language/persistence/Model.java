package com.dsantanaleal.teach.java_language.persistence;

import com.dsantanaleal.teach.java_language.model.Empleado;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;

public class Model {

    private Faker faker = new Faker();
    private FakeValuesService service = new FakeValuesService(new Locale("es-ES"), new RandomService());
    Collection<Empleado> empleados = new ArrayList<>(100);

    public void addFakeValues() {
        for(int i = 0; i < 100; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(faker.date().birthday());
            LocalDate date = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH));
            Empleado empleado = new Empleado((long)i, faker.name().firstName(), faker.name().lastName(), date);
            empleados.add(empleado);
        }
    }

    public void guardar(File archivo) {
        try (FileOutputStream fos = new FileOutputStream(archivo);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(empleados);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void crearArchivoBase(String nomArchivo) {
        Model fakeData = new Model();
        fakeData.addFakeValues();
        fakeData.guardar(new File(nomArchivo));
    }

    public static void main(String[] args) {
        Model.crearArchivoBase("empleados");
    }
}
