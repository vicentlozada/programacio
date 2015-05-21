package llibreries;

import utils.Menus;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF;
import moduls.gestioEmpleats.gestioEF.model.classes.EmpleatFix;

public class Json {

    public static void guardarJsonEF() {
        String PATH;

        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("EmpleatFix", EmpleatFix.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

            int seleccion = fileChooser.showSaveDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                if (!PATH.endsWith(".json")) {
                    PATH = PATH + ".json";
                }

                Gson gson = new Gson();
                String json = gson.toJson(SingletonEF.efix);
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(json.toString());
                fileXml.close();

                Menus.information("Arxiu JSON guardat amb èxit!", "Arxiu JSON");
            }
        } catch (HeadlessException | IOException e) {
            Menus.error("Error al guardar el JSON", "Error");
        }
    }

    public static void obrirJsonEF() {
        String PATH = "";
        EmpleatFix ef = null;

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("EmpleatFix", EmpleatFix.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

            int seleccion = fileChooser.showOpenDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                SingletonEF.efix.clear();

                JsonReader lector = new JsonReader(new FileReader(PATH));
                JsonParser parseador = new JsonParser();
                JsonElement raiz = parseador.parse(lector);

                Gson json = new Gson();
                JsonArray lista = raiz.getAsJsonArray();

                for (JsonElement elemento : lista) {
                    ef = json.fromJson(elemento, EmpleatFix.class);
                    SingletonEF.efix.add(ef);
                }
                Menus.information("Arxiu JSON obert amb èxit!", "Arxiu JSON");
            }
        } catch (HeadlessException | FileNotFoundException | JsonIOException | JsonSyntaxException e) {
            Menus.warning("Error en llegir el JSON", "Error");
        }

    }

    public static void generaJsonOcultEF() {// Guarda Json de empleadosfijos de
        // forma silenciosa
        String PATH = null;
        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("EmpleatFix", EmpleatFix.class);

            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/moduls/gestioEmpleats/gestioEF/model/arxius/ef.json";

            Gson gson = new Gson();
            String json1 = gson.toJson(SingletonEF.efix);
            FileWriter fileXml = new FileWriter(PATH);
            fileXml.write(json1.toString());
            fileXml.close();

        } catch (Exception e) {
        }
    }

    public static void obrirJsonOcultEF() {// Abre json de
        // empleados fijos
        // de forma
        // silenciosa
        String PATH = null;
        EmpleatFix e1 = new EmpleatFix();

        try {
            PATH = new java.io.File(".").getCanonicalPath()
                    + "/src/moduls/gestioEmpleats/gestioEF/model/arxius/ef.json";
            SingletonEF.efix.clear();
            JsonReader lector = new JsonReader(new FileReader(PATH));
            JsonParser parseador = new JsonParser();
            JsonElement raiz = parseador.parse(lector);

            Gson json = new Gson();
            JsonArray lista = raiz.getAsJsonArray();
            int i=0;
            for (JsonElement elemento : lista) {
                e1 = json.fromJson(elemento, EmpleatFix.class);
                SingletonEF.efix.add(e1);
            }
        } catch (Exception e) {

        }
    }

}
