package it.esercizipercasa.model;

public class Biblioteca {
    private MaterialeBiblioteca[] materiali;

    public Biblioteca(MaterialeBiblioteca[] materiali) {
        this.materiali = materiali;
    }

    public MaterialeBiblioteca[] getMateriali() {
        return materiali;
    }
    public void setMateriali(MaterialeBiblioteca[] materiali) {
        this.materiali = materiali;
    }

    public void aggiungiMateriale( MaterialeBiblioteca m) {
        MaterialeBiblioteca[] nuoviMateriali = new MaterialeBiblioteca[materiali.length + 1];
        for (int i = 0; i < materiali.length; i++)
            nuoviMateriali[i] = materiali[i];
        nuoviMateriali[materiali.length] = m;
        materiali = nuoviMateriali;

    }
    public Biblioteca cercaMaterialePerTitolo(String titolo) {
        int count = 0;
        for (MaterialeBiblioteca m : materiali)
            if (m.getTitolo().equalsIgnoreCase(titolo))
                count++;
        MaterialeBiblioteca[] risultato = new MaterialeBiblioteca[count];
        count = 0;
        for (MaterialeBiblioteca m : materiali)
            if (m.getTitolo().equalsIgnoreCase(titolo))
                risultato[count++] = m;
        return new Biblioteca(risultato);
    }

    public Biblioteca elencaMaterialiDisponibili() {
        int count = 0;
        for (MaterialeBiblioteca m : materiali)
            if (m.isDisponibile())
                count++;
        MaterialeBiblioteca[] risultato = new MaterialeBiblioteca[count];
        count = 0;
        for (MaterialeBiblioteca m : materiali)
            if (m.isDisponibile())
                risultato[count++] = m;
        return new Biblioteca(risultato);
    }
    public Biblioteca elencaMaterialiInPrestito() {
        int count = 0;
        for (MaterialeBiblioteca m : materiali)
            if (!m.isDisponibile())
                count++;
        MaterialeBiblioteca[] risultato = new MaterialeBiblioteca[count];
        count = 0;
        for (MaterialeBiblioteca m : materiali)
            if (!m.isDisponibile())
                risultato[count++] = m;
        return new Biblioteca(risultato);
    }

    @Override
    public String toString() {
        String result = "Biblioteca con " + materiali.length + " materiali:\n";
        for (MaterialeBiblioteca m : materiali)
            result += "\t" + m.toString();
        return result;
    }
}
