import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Biblioteca {

    ArrayList<Libro> listaLibri;
    HashSet<Libro> setLibro;
    LinkedList<Libro> coda;

    public Biblioteca() {
        this.listaLibri = new ArrayList<Libro>();
        this.setLibro = new HashSet<Libro>();
        this.coda = new LinkedList<Libro>();
    }

    public void caricaDaFile(String nomeFile) throws IOException {
        BufferedReader lettore = new BufferedReader(new FileReader(nomeFile));

        String linea;

        while((linea = lettore.readLine()) != null){
            String[] infoLinea = linea.split(",");

            Libro libro = new Libro(infoLinea[0],infoLinea[1],infoLinea[2]);

            listaLibri.add(libro);
        }
    }

    public void eliminaDuplicati(){
        listaLibri.forEach(libro -> setLibro.add(libro));
    }

    //dato un libro Aggiungi alla coda
    public void aggiungiCoda(Libro libro){
        coda.add(libro);
    }

    //return lista di libri
    public List<Libro> cercaLibri(String criterio){

        return listaLibri.stream().filter(libro -> libro.getTitolo().contains(criterio)).toList();

    }
}
