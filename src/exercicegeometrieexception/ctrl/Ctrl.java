package exercicegeometrieexception.ctrl;

import exercicegeometrieexception.ihm.IIhmCtrl;
import exercicegeometrieexception.wrk.IWrkCtrl;
import javax.swing.JTextField;

public class Ctrl implements ICtrlIhm {

    private IIhmCtrl refIhm;
    private IWrkCtrl refWorker;

    public void demarrer() {
        refIhm.demarrer();
    }

    @Override
    public void selectCalcRadius(String value) {

        boolean aireValide = false;
        try {
            double valueDouble = Double.parseDouble(value);
            aireValide = true;
            refIhm.afficheResultatCircle(String.valueOf(refWorker.calcRadiusCircleFromArea(valueDouble)));
            refIhm.afficheMessage("");
        } catch (NumberFormatException e) {
            if (!aireValide) {
                refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du cercle (" + value + " invalide)");
            } 
        }
    }

    @Override
    public void selectCalcLargeur(String valueArea, String valueLongueur) {
        boolean aireValide = false;
        boolean longueurValide = false;
        try {
            double valueAreaDouble = Double.parseDouble(valueArea);
            aireValide = true;
            double valueLongueurDouble = Double.parseDouble(valueLongueur);
            longueurValide = true;
            refIhm.afficheResultatRectangle(String.valueOf(refWorker.calcLargeurFromRectangle(valueAreaDouble, valueLongueurDouble)));
            refIhm.afficheMessage("");

        } catch (NumberFormatException e) {
            if (!aireValide) {
                refIhm.afficheMessage("Veuillez entrer une valeur valide pour l'aire du rectangle (" + valueArea + " invalide)");
            } else if (!longueurValide) {
                refIhm.afficheMessage("Veuillez entrer une valeur valide pour longuer du rectangle (" + valueLongueur + " invalide)");
            }

        }
    }

    public void setRefIhm(IIhmCtrl refIhm) {
        this.refIhm = refIhm;
    }

    public void setRefWorker(IWrkCtrl refWorker) {
        this.refWorker = refWorker;
    }

}
