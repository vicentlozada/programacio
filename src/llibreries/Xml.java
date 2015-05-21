package llibreries;

import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import utils.Menus;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import moduls.gestioEmpleats.gestioEF.model.classes.SingletonEF;
import moduls.gestioEmpleats.gestioEF.model.classes.EmpleatFix;

public class Xml {
	private static final String ENCODING = "UTF-8";

	public static void guardarXmlEF() {
		String PATH;
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(SingletonEF.efix, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showSaveDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				if (!PATH.endsWith(".xml")) {
					PATH = PATH + ".xml";
				}

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();

				Menus.information("Arxiu XML guardat amb Èxit!", "Arxiu XML");
			}
		} catch (HeadlessException | IOException e) {
			Menus.error("Error al guardar el XML", "Error");
		}
	}

	public static void generaXmlOcultEF() {
		String PATH = null;
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, EmpleatFix.class);

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(SingletonEF.efix, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/catering/moduls/gestioE/gestioEF/model/arxius/ef.xml";

			FileWriter fileXml = new FileWriter(PATH);
			fileXml.write(xml.toString());
			fileXml.close();
			osw.close();
			os.close();

		} catch (Exception e1) {
		}
	}

	public static void obrirXmlEF() {
		String PATH;

		try {
			XStream xstream = new XStream();

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showOpenDialog(null);

			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				SingletonEF.efix = (ArrayList<EmpleatFix>) xstream.fromXML(new FileReader(PATH));

				Menus.information("Arxiu XML obert amb �xit!", "Arxiu XML");

			}
		} catch (HeadlessException | FileNotFoundException e) {
			Menus.warning("Error en llegir el XML", "Error");
		}

	}

	public static void obrirXmlOcultEF() {
		String PATH = null;
		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, EmpleatFix.class);

			PATH = new java.io.File(".").getCanonicalPath()
					+ "/src/moduls/gestioE/gestioEF/model/arxius/ef.xml";
			SingletonEF.efix = (ArrayList<EmpleatFix>) xstream.fromXML(new FileReader(PATH));

		} catch (Exception e1) {

		}
	}

}
