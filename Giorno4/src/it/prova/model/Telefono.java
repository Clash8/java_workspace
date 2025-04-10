package it.prova.model;

public class Telefono {
    private String modello;
    private String marca;
    private Sim simcard;

    public Telefono() {}

    public Telefono(String modello, String marca, Sim simcard) {
        this.modello = modello;
        this.marca = marca;
        this.simcard = simcard;
    }
    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Sim getSimcard() {
        return simcard;
    }
    public void setSimcard(Sim simcard) {
        this.simcard = simcard;
    }

    @Override
    public String toString() {
        return "Telefono [modello=" + modello + ", marca=" + marca + ", simcard=" + simcard + "]";
    }

    public boolean isSimCardInserita() {
        return this.simcard != null;
    }

    public static int quantiSenzaSimCard(Telefono[] elencoTelefoni) {
        int count = 0;
        for (Telefono t : elencoTelefoni)
            if (!t.isSimCardInserita())
                count++;
        return count;
    }

    public static int quantiTelefoniConMarca(Telefono[] elencoTelefoni, String marcaInput) {
        int count = 0;
        for (Telefono t : elencoTelefoni)
            if (t.getMarca().equalsIgnoreCase(marcaInput))
                count++;
        return count;
    }

    public int quantiTelefoniStessaMarca(Telefono[] elencoTelefoni) {
        return quantiTelefoniConMarca(elencoTelefoni, this.marca);
    }

    public static int[] numeriDiTelefonoConSim(Telefono[] telefoni) {
        int[] numeri = new int[telefoni.length];
        int count = 0;
        for (Telefono t : telefoni)
            if (t.isSimCardInserita()) {
                numeri[count++] = t.getSimcard().getNumero();
            }
        return numeri;
    }
    public static boolean ciSonoDuplicatiIMEI(Telefono[] telefoni){
        for (int i = 0; i < telefoni.length; i++) {
            for (int j = i + 1; j < telefoni.length; j++) {
                if (telefoni[i].getSimcard().getIMEI().equals(telefoni[j].getSimcard().getIMEI())) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getOccorrenzaTelefono(int tel) {
        return 0;
    }


    public static Telefono telefonoconPiuOccorrenze(Telefono[] telefoni) {
    return telefoni[0];
    }


}
