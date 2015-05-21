package moduls.gestioInici.model.classes;

import moduls.gestioInici.model.classes.Job;
import javax.swing.JProgressBar;

public class JcThread implements Runnable {

    private final JProgressBar jProgressBar;
    private int i = 1;
    private int value = 50;//retardo en milisegundos

    /**
     * Constructor de clase
     * @param jProgressBar
     * @param value
     */
    public JcThread(JProgressBar jProgressBar, int value) {
        this.jProgressBar = jProgressBar;
        this.value = value;
    }

    @Override
    public void run() {

        i = 1;
        //mientra el trabajo en paralelo no finalice el jProgressBar continuara su animacion una y otra vez
        while (!Job.band) {
            //si llega al limite 100 comienza otra vez desde 1, sino incrementa i en +1
            i = (i > 100) ? 1 : i + 1;
            jProgressBar.setValue(i);
            jProgressBar.repaint();
            //retardo en milisegundos
            try {
                Thread.sleep(this.value);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            //si el trabajo en paralelo a terminado
            if (Job.band) {
                jProgressBar.setValue(100);

                System.out.println("Trabajo finalizado...");
                break;//rompe ciclo     
            }
        }
    }

}
