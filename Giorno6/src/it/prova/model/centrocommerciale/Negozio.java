package it.prova.model.centrocommerciale;

import java.util.List;

public class Negozio {
    private String ragioneSociale;
    private String partitaIva;
    private CentroCommerciale centroCommerciale;
    private List<Item> items;
    private List<Lavoratore> lavoratori;


    public Negozio(String ragioneSociale, String partitaIva, List<Item> items, List<Lavoratore> lavoratori) {
        this.ragioneSociale = ragioneSociale;
        this.partitaIva = partitaIva;
        this.items = items;
        this.lavoratori = lavoratori;
    }

    public String getRagioneSociale() {
        return ragioneSociale;
    }
    public void setRagioneSociale(String ragioneSociale) {
        this.ragioneSociale = ragioneSociale;
    }
    public String getPartitaIva() {
        return partitaIva;
    }
    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }
    public CentroCommerciale getCentroCommerciale() {
        return centroCommerciale;
    }
    public void setCentroCommerciale(CentroCommerciale centroCommerciale) {
        this.centroCommerciale = centroCommerciale;
    }
    public List<Item> getItems() {
        return items;
    }
    public void setItems(List<Item> items) {
        this.items = items;
    }
    public List<Lavoratore> getLavoratori() {
        return lavoratori;
    }
    public void setLavoratori(List<Lavoratore> lavoratori) {
        this.lavoratori = lavoratori;
    }

    public boolean addToItems(Lavoratore lavoratore,Item item) {
        if (lavoratori.contains(lavoratore)) {
            return lavoratore.handleItemAdd(item);
        }
        return false;
    }

    public boolean removeFromItems(Lavoratore lavoratore,Item item) {
        if (lavoratori.contains(lavoratore)) {
            return lavoratore.handleItemRemove(item);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Negozio " + ragioneSociale + " ha " + items.size() + " items e " + lavoratori.size() + " lavoratori\n" +
                "Items:\n" + items + "\n";
    }


}
