package moduls.gestioInici.model.classes;

import classes.Mail;

public class Job implements Runnable {

    public static boolean band = false;
    final int tiempo = 5;
    private final String email1;    
    private final String pass;
    private final String email2;
    private final String assumpte;
    private final String missatge;    

    /**
     * Constructor de clase
     * @param email1
     * @param pass
     * @param email2
     * @param assumpte
     * @param missatge
     */

    public Job(String email1, String pass, String email2, String assumpte, String missatge) {
        this.email1 = email1;
        this.pass = pass;
        this.email2 = email2;
        this.assumpte = assumpte;
        this.missatge = missatge;
    }


    @Override
    public void run() {
        band = false;
        Mail mail = new Mail(this.email1, this.pass, this.email2, this.assumpte, this.missatge);        
        mail.send();
        band = true;
    }

}
