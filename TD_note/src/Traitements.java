import java.util.ArrayList;
import java.util.Arrays;

public class Traitements {
    ArrayList<ArbreFruitier> arbres_fruitiers;
    ArbreOrnement[] arbreOrnements;
    int annePlantationParDefaut;

    @Override
    public String toString() {
        return "Traitements{" +
                "arbres_fruitiers=" + arbres_fruitiers +
                ", arbreOrnements=" + Arrays.toString(arbreOrnements) +
                ", annePlantationParDefaut=" + annePlantationParDefaut +
                '}';
    }


    public Traitements(int annePlantationParDefaut) {
        this.annePlantationParDefaut = annePlantationParDefaut;

    }
    public void test()
    {
        class Consumertri {
            public void tri(ArbreOrnement[] m) {
                for (int i = 0; i < m.length; i++) {
                    for (int j = i + 1; j < m.length; j++) {
                        if (m[i].getAnneePlantation() < m[j].getAnneePlantation()) {
                            ArbreOrnement temp = m[i];
                            m[i] = m[j];
                            m[j] = temp;
                        }
                    }
                }
            }

        }

        class ConsumerDefaultAnnee {
            public void annePlantationParDefaut(ArbreOrnement[] m) {
                ArbreOrnement[] arbresOrnement = getArbreOrnements();
                ArrayList<ArbreFruitier> arbresFruitiers = getArbres_fruitiers();

                for (int i = 0; i < arbresOrnement.length; i++) {
                    if (arbresOrnement[i].getAnneePlantation() < getAnnePlantationParDefaut()) {
                        arbresOrnement[i].setAnneePlantation(getAnnePlantationParDefaut());
                    }
                }

                for (int i = 0; i < arbresFruitiers.size(); i++) {
                    if (arbresFruitiers.get(i).getAnneePlantation() < getAnnePlantationParDefaut()) {
                        arbresFruitiers.get(i).setAnneePlantation(getAnnePlantationParDefaut());


                    }

                }

            }

        }
    }


    public ArrayList<ArbreFruitier> getArbres_fruitiers () {
        return arbres_fruitiers;
    }

    public ArbreOrnement[] getArbreOrnements () {
        return arbreOrnements;
    }

    public int getAnnePlantationParDefaut () {
        return annePlantationParDefaut;
    }

    public void init( Traitements t)
    {
        //ArbreFruitier a = new ArbreFruitier("tomate",2020);
     //  ArrayList<ArbreFruitier> arbres_fruitiers ;

     //  arbres_fruitiers.add()


    }
    
    public void serialiserArbres (String nomfichier) {

        try {
            FileOutputStream fos = new FileOutputStream(nomfichier);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.arbres_fruitiers);
            oos.writeObject(this.arbreOrnements);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deserialiserArbres (String nomfichier) {
        try {
            FileInputStream fis = new FileInputStream(nomfichier);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.arbres_fruitiers = (ArrayList<ArbreFruitier>) ois.readObject();
            this.arbreOrnements = (ArbreOrnement[]) ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        Traitements traitements = new Traitements(2008);
        traitements.getArbres_fruitiers().add(new ArbreFruitier("tommate", MoisAnnee.Janvier));
        traitements.getArbres_fruitiers().get(0).setAnneePlantation(2000);
        traitements.getArbres_fruitiers().get(0).setNom(" 1");
        traitements.getArbres_fruitiers().add(new ArbreFruitier("poivre", MoisAnnee.Fevrier));
        traitements.getArbres_fruitiers().get(1).setAnneePlantation(2001);
        traitements.getArbres_fruitiers().get(1).setNom(" 2");
        traitements.getArbres_fruitiers().add(new ArbreFruitier("dae", MoisAnnee.Mai));
        traitements.getArbres_fruitiers().get(2).setAnneePlantation(2010);
        traitements.getArbres_fruitiers().get(2).setNom(" 3");
        traitements.getArbreOrnements()[0] = new ArbreOrnement(essenceDarbre.Erable, true);
        traitements.getArbreOrnements()[0].setAnneePlantation(2000);
        traitements.getArbreOrnements()[0].setNom(" 1");
        traitements.getArbreOrnements()[1] = new ArbreOrnement(essenceDarbre.Tilleul, true);
        traitements.getArbreOrnements()[1].setAnneePlantation(2001);
        traitements.getArbreOrnements()[1].setNom(" 2");
        traitements.getArbreOrnements()[2] = new ArbreOrnement(essenceDarbre.Platane_commun, false);
        traitements.getArbreOrnements()[2].setAnneePlantation(20010);
        traitements.getArbreOrnements()[2].setNom(" 3");


        System.out.println("///////////////////////Question 1 ///////////////////////");
        System.out.println("Avant le tri");
        for (ArbreOrnement arbreOrnement : traitements.arbreOrnements) {
            System.out.println(arbreOrnement.anneePlantation+""+arbreOrnement.nom);

        }


    }
}
